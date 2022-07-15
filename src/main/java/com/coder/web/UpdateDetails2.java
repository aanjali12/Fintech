package com.coder.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coder.bean.User;
import com.coder.dao.GetConDao;
import com.coder.dao.SaveDetails;
import com.coder.dao.UpdateDetails;
import com.google.gson.Gson;

/**
 * Servlet implementation class UpdateDetails2
 */
@WebServlet("/UpdateDetails2")
public class UpdateDetails2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDetails2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			HashMap<Object,Object> Response=new HashMap<Object,Object>();
			int sl_no = Integer.parseInt(request.getParameter("sl_no"));
			String business_code = request.getParameter("business_code");
			String doc_id = request.getParameter("doc_id");
			String invoice_currency = request.getParameter("invoice_currency");
			String document_type = request.getParameter("document_type");
			String area_business = request.getParameter("area_business");
			String cust_payment_terms = request.getParameter("cust_payment_terms");
			String aging_bucket = request.getParameter("aging_bucket");
			int cust_number = Integer.parseInt(request.getParameter("cust_number"));
			int buisness_year = Integer.parseInt(request.getParameter("buisness_year"));
			int posting_id = Integer.parseInt(request.getParameter("posting_id"));
			int invoice_id = Integer.parseInt(request.getParameter("invoice_id"));
			int isOpen = Integer.parseInt(request.getParameter("isOpen"));
			int is_deleted = Integer.parseInt(request.getParameter("is_deleted"));
			double total_open_amount=Double.parseDouble(request.getParameter("total_open_amount"));
			SimpleDateFormat in = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
			String clear = request.getParameter("clear_date");
			Date clear_date = in.parse(clear);
			String posting = request.getParameter("posting_date");
			Date posting_date = in.parse(posting);
			String document = request.getParameter("document_create_date");
			Date document_create_date = in.parse(document);
			String document1 = request.getParameter("document_create_date1");
			Date document_create_date1 =  in.parse(document1);
			String due = request.getParameter("due_in_date");
			Date due_in_date =  in.parse(due);
			String baseline = request.getParameter("baseline_create_date");
			Date baseline_create_date =in.parse(baseline);
			
			User newUser = new User(sl_no,business_code,cust_number, clear_date, buisness_year, doc_id, posting_date, document_create_date, document_create_date1, 
					due_in_date, invoice_currency, document_type, posting_id, area_business, total_open_amount, baseline_create_date, cust_payment_terms,
					invoice_id, isOpen, aging_bucket, is_deleted);
			Connection connection=GetConDao.getConnection();
			PreparedStatement preparedStatement =connection.prepareStatement("UPDATE winter_internship set business_code=?,cust_number=?,clear_date=?,buisness_year=?,doc_id=?,posting_date=?,"
					+ "document_create_date=?,document_create_date1=?,due_in_date=?,invoice_currency=?,document_type=?,posting_id=?,area_business=?,total_open_amount=?,baseline_create_date=?,cust_payment_terms=?,"
					+ "invoice_id=?,isOpen=?,aging_bucket=?,is_deleted=? where sl_no=?") ;
			preparedStatement.setString(1,business_code);
			preparedStatement.setInt(2,cust_number);
			preparedStatement.setDate(3,new java.sql.Date(clear_date.getTime()));
			preparedStatement.setInt(4, buisness_year);
			preparedStatement.setString(5,doc_id);
			preparedStatement.setDate(6,new java.sql.Date(posting_date.getTime()));
			preparedStatement.setDate(7,new java.sql.Date(document_create_date.getTime()));
			preparedStatement.setDate(8, new java.sql.Date(document_create_date1.getTime()));
			preparedStatement.setDate(9,new java.sql.Date(baseline_create_date.getTime()));
			preparedStatement.setString(10,invoice_currency);
			preparedStatement.setString(11,document_type);
			preparedStatement.setInt(12,posting_id);
			preparedStatement.setString(13,area_business);
			preparedStatement.setDouble(14,total_open_amount);
			preparedStatement.setDate(15,new java.sql.Date(baseline_create_date.getTime()));
			preparedStatement.setString(16,cust_payment_terms);
			preparedStatement.setInt(17,invoice_id);
			preparedStatement.setInt(18,isOpen);
			preparedStatement.setString(19,aging_bucket);
			preparedStatement.setInt(20,is_deleted);
			preparedStatement.setInt(21,sl_no);

			
			if(preparedStatement.executeUpdate()>0) {
				Response.put("update", true);
			}else {
				Response.put("update", false);
			}
			Gson gson=new Gson();
//		response.addHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Origin","*");
			String Responsejson=gson.toJson(Response);
			response.getWriter().append(Responsejson);
			}catch(ParseException e){
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
