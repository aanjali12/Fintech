package com.coder.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coder.dao.DeleteDetails2;
import com.coder.dao.GetConDao;
import com.google.gson.Gson;

/**
 * Servlet implementation class DeleteDetails
 */
@WebServlet("/DeleteDetails")
public class DeleteDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDetails() {
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
		Connection connection=GetConDao.getConnection();
		PreparedStatement preparedStatement =connection.prepareStatement("delete from winter_internship where sl_no=?");
		preparedStatement.setInt(1,sl_no);
		
		if(preparedStatement.executeUpdate()>0) {
			Response.put("update",true);
		}
		else {
			Response.put("update",false);
		}
		Gson gson=new Gson();
		response.setHeader("Access-Control-Allow-Origin","*");
		String Responsejson=gson.toJson(Response);
		response.getWriter().append(Responsejson);
		}
		catch(Exception e){
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
