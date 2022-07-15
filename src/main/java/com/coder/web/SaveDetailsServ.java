package com.coder.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coder.bean.User;
import com.coder.dao.SaveDetails;
import com.google.gson.Gson;

/**
 * Servlet implementation class SaveDetailsServ
 */
@WebServlet("/SaveDetailsServ")
public class SaveDetailsServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveDetailsServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		HashMap<Object,Object> Response =new HashMap();
		String business_code = request.getParameter("business_code");
		String doc_id = request.getParameter("doc_id");
		String invoice_currency = request.getParameter("invoice_currency");
		String document_type = request.getParameter("document_type");
		String area_business = request.getParameter("area_business");
		String cust_payment_terms = request.getParameter("cust_payment_terms");
		String aging_bucket = request.getParameter("aging_bucket");
		int cust_number = Integer.parseInt((String)request.getParameter("cust_number"));
		int buisness_year = Integer.parseInt((String)request.getParameter("buisness_year"));
		int posting_id = Integer.parseInt((String)request.getParameter("posting_id"));
		int invoice_id = Integer.parseInt((String)request.getParameter("invoice_id"));
	    int isOpen =0;
	    int is_deleted=0 ;
		double total_open_amount=Double.parseDouble((String)request.getParameter("total_open_amount"));
		SimpleDateFormat in = new SimpleDateFormat("yyyy-mm-dd");
		String clear = request.getParameter("clear_date");
		Date clear_date = (Date) in.parse(clear);
		String posting = request.getParameter("posting_date");
		Date posting_date = (Date) in.parse(posting);
		String document = request.getParameter("document_create_date");
		Date document_create_date = (Date) in.parse(document);
//		String document1 = request.getParameter("document_create_date1");
		Date document_create_date1 = in.parse("0000-00-00");
		String due = request.getParameter("due_in_date");
		Date due_in_date = (Date) in.parse(due);
		String baseline = request.getParameter("baseline_create_date");
		Date baseline_create_date = (Date) in.parse(baseline);
		
		User newUser = new User(business_code,cust_number, clear_date, buisness_year, doc_id, posting_date, document_create_date, document_create_date1, 
				due_in_date, invoice_currency, document_type, posting_id, area_business, total_open_amount, baseline_create_date, cust_payment_terms,
				invoice_id, isOpen, aging_bucket, is_deleted);
		int status=SaveDetails.save(newUser);
		if(status>0) {
			Response.put("insert", true);
		}else {
			Response.put("insert", false);
		}
		Gson gson=new Gson();
		String JSONresponse=gson.toJson(Response);
		response.setHeader("Access-Control-Allow-Origin","*");
		response.getWriter().append(JSONresponse);
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
