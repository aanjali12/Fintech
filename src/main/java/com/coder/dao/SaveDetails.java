package com.coder.dao;

import java.sql.Connection;
//import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.coder.bean.User;

public class SaveDetails {
	public static int save(User user) throws SQLException {
		int status=0;
		try {
		Connection connection=GetConDao.getConnection();
		PreparedStatement preparedStatement =connection.prepareStatement("INSERT INTO winter_internship"+"(business_code,cust_number,clear_date,buisness_year,doc_id,posting_date,"
				+ "document_create_date,document_create_date1,due_in_date,invoice_currency,document_type,posting_id,area_business,total_open_amount,baseline_create_date,cust_payment_terms,"
				+ "invoice_id,isOpen,aging_bucket,is_deleted) VALUES"
				+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
		preparedStatement.setString(1,user.getBusiness_code());
		preparedStatement.setInt(2,user.getCust_number());
		preparedStatement.setDate(3,new java.sql.Date(user.getClear_date().getTime()));
		preparedStatement.setInt(4, user.getBuisness_year());
		preparedStatement.setString(5,user.getDoc_id());
		preparedStatement.setDate(6, new java.sql.Date(user.getPosting_date().getTime()));
		preparedStatement.setDate(7,new java.sql.Date(user.getDocument_create_date().getTime()));
		preparedStatement.setDate(8, new java.sql.Date(user.getDocument_create_date1().getTime()));
		preparedStatement.setDate(9,new java.sql.Date(user.getDue_in_date().getTime()));
		preparedStatement.setString(10,user.getInvoice_currency());
		preparedStatement.setString(11,user.getDocument_type());
		preparedStatement.setInt(12,user.getPosting_id());
		preparedStatement.setString(13,user.getArea_business());
		preparedStatement.setDouble(14, user.getTotal_open_amount());
		preparedStatement.setDate(15,new java.sql.Date(user.getBaseline_create_date().getTime()));
		preparedStatement.setString(16,user.getCust_payment_terms());
		preparedStatement.setInt(17,user.getInvoice_id());
		preparedStatement.setInt(18,user.getIsOpen());
		preparedStatement.setString(19,user.getAging_bucket());
		preparedStatement.setInt(20,user.getIs_deleted());
		status=preparedStatement.executeUpdate();
		connection.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
