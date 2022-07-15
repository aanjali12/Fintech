package com.coder.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.coder.bean.*;
import com.coder.web.*;

public class SelectDetails {
	public static User getEmployeeById(int sl_no) {
	User e=new User();
	try {
		Connection connection=GetConDao.getConnection();
		PreparedStatement preparedStatement =connection.prepareStatement("Select * from winter_internship where id=?");
		preparedStatement.setInt(1,sl_no);
		ResultSet rs=preparedStatement.executeQuery();
		if(rs.next()) {
			e.setBusiness_code(rs.getString(1));
			e.setCust_number(rs.getInt(2));
			e.setClear_date(rs.getDate(3));
			e.setBuisness_year(rs.getInt(4));
			e.setDoc_id(rs.getString(5));
			e.setPosting_date(rs.getDate(6));
			e.setDocument_create_date(rs.getDate(7));
			e.setDocument_create_date1(rs.getDate(8));
			e.setDue_in_date(rs.getDate(9));
			e.setInvoice_currency(rs.getString(10));
			e.setDocument_type(rs.getString(11));
			e.setPosting_id(rs.getInt(12));
			e.setArea_business(rs.getString(13));
			e.setTotal_open_amount(rs.getDouble(14));
			e.setBaseline_create_date(rs.getDate(15));
			e.setCust_payment_terms(rs.getString(16));
			e.setInvoice_id(rs.getInt(17));
			e.setIsOpen(rs.getInt(18));
			e.setAging_bucket(rs.getString(19));
			e.setIs_deleted(rs.getInt(20));
			}
		connection.close();
		} catch (Exception ex) {
		// TODO Auto-generated catch block
		ex.printStackTrace();
	}
	return e;
}
	public static ArrayList<User> getAllEmployees(){
		HashMap<Object,Object> Response=new HashMap<Object,Object>();

		ArrayList<User> list=new ArrayList<User>();
		try {
			Connection connection=GetConDao.getConnection();
			PreparedStatement preparedStatement =connection.prepareStatement("Select * from winter_internship limit 1000");
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next()) {
				User e=new User();
				e.setSl_no(rs.getInt("sl_no"));
				e.setBusiness_code(rs.getString("business_code"));
				e.setCust_number(rs.getInt("cust_number"));
				e.setClear_date(rs.getDate("clear_date"));
				e.setBuisness_year(rs.getInt("buisness_year"));
				e.setDoc_id(rs.getString("doc_id"));
				e.setPosting_date(rs.getDate("posting_date"));
				e.setDocument_create_date(rs.getDate("document_create_date"));
				e.setDocument_create_date1(rs.getDate("document_create_date1"));
				e.setDue_in_date(rs.getDate("due_in_date"));
				e.setInvoice_currency(rs.getString("invoice_currency"));
				e.setDocument_type(rs.getString("document_type"));
				e.setPosting_id(rs.getInt("posting_id"));
				e.setArea_business(rs.getString("area_business"));
				e.setTotal_open_amount(rs.getDouble("total_open_amount"));
				e.setBaseline_create_date(rs.getDate("baseline_create_date"));
				e.setCust_payment_terms(rs.getString("cust_payment_terms"));
				e.setInvoice_id(rs.getInt("invoice_id"));
				e.setIsOpen(rs.getInt("isOpen"));
				e.setAging_bucket(rs.getString("aging_bucket"));
				e.setIs_deleted(rs.getInt("is_deleted"));
				list.add(e);
				}
			Response.put("user", list);

			
			} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return list;
	}
	
}
