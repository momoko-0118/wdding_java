package com.diworksdev.WeddingInvitation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.diworksdev.WeddingInvitation.dto.LoginDTO;
import com.diworksdev.WeddingInvitation.util.DBConnector;


public class LoginDAO {
	
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private LoginDTO loginDTO = new LoginDTO();

	public LoginDTO getLoginUserInfo(String loginMail, String loginPassword) {
		String sql = "SELECT * FROM login_user where mail=? AND password=?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, loginMail);
			preparedStatement.setString(2, loginPassword);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				System.out.println("DB id = " + resultSet.getString("id"));
			    System.out.println("DB mail = " + resultSet.getString("mail"));
			    
				loginDTO.setId(resultSet.getString("id"));
				loginDTO.setMail(resultSet.getString("mail"));
				loginDTO.setPassword(resultSet.getString("password"));
				
				System.out.println("DTO id = " + loginDTO.getId());
				
				if(resultSet.getString("id")!=null) {
					loginDTO.setLoginFlg(true);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return loginDTO;
	}
}
