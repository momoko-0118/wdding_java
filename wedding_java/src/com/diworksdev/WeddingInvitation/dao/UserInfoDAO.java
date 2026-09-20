package com.diworksdev.WeddingInvitation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.diworksdev.WeddingInvitation.dto.ListDTO;
import com.diworksdev.WeddingInvitation.util.DBConnector;

public class UserInfoDAO {
	
	private DBConnector dbConnector=new DBConnector();
	private Connection connection=dbConnector.getConnection();
	
	public ListDTO getUser(int id) throws SQLException {	
		ListDTO dto=new ListDTO();
		String sql="SELECT lu.id,lu.family_name,lu.last_name,lu.family_name_alphabet,"
				+ "lu.last_name_alphabet,lu.mail,lu.password,lu.user_gender,ugi.user_gender_info,fi.flg,"
				+ "lu.registered_time,lu.update_time,lu.invitation_slug FROM login_user lu "
				+ "LEFT JOIN user_gender_info ugi ON lu.user_gender=ugi.id "
				+ "LEFT JOIN flg_info fi ON lu.delete_flg=fi.id "
				+ "WHERE lu.id = ? ORDER BY lu.registered_time DESC";
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			System.out.println("更新前の取得");
			System.out.println(id);
			if(resultSet.next()) {
				dto.setId(resultSet.getString("id"));
				dto.setFamilyName(resultSet.getString("family_name"));
				dto.setLastName(resultSet.getString("last_name"));
				dto.setFamilyNameAlphabet(resultSet.getString("family_name_alphabet"));
				dto.setLastNameAlphabet(resultSet.getString("last_name_alphabet"));	
				dto.setMail(resultSet.getString("mail"));
				dto.setPassword(resultSet.getString("password"));
				dto.setUserGender(resultSet.getString("user_gender"));
				dto.setUserGenderInfo(resultSet.getString("user_gender_info"));
				dto.setInvitationSlug(resultSet.getString("invitation_slug"));
				System.out.println("更新時の取得");
				System.out.println(dto.getFamilyName());
				System.out.println(dto.getLastName());
				System.out.println(dto.getFamilyNameAlphabet());
				System.out.println(dto.getLastNameAlphabet());
				System.out.println(dto.getMail());
			} else {
				return null;
			}
			}catch(Exception e) {
			e.printStackTrace();
		}finally {
				connection.close();
		}
		return dto;
	}

}
