package com.diworksdev.WeddingInvitation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.diworksdev.WeddingInvitation.util.DBConnector;


public class UserRegistConfirmDAO {
	
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public boolean duplication(String mail) {
	    String sql = "SELECT 1 FROM login_user "
	               + "WHERE mail = ?";

	    try {
	        PreparedStatement preparedStatement =
	                connection.prepareStatement(sql);

	        preparedStatement.setString(1, mail);

	        ResultSet resultSet =
	                preparedStatement.executeQuery();

	        if(resultSet.next()) {
	            return true;
	        }
	        return false;

	    } catch(Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}

}
