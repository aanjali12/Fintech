package com.coder.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteDetails2 {
	public static int delete(int sl_no) {
		int status=0;
		try {
			Connection connection=GetConDao.getConnection();
			PreparedStatement preparedStatement =connection.prepareStatement("delete from winter_internship where sl_no=?");
			preparedStatement.setInt(1,sl_no);
			status=preparedStatement.executeUpdate();
			connection.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
