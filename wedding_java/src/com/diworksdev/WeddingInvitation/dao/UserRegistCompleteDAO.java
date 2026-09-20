package com.diworksdev.WeddingInvitation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.diworksdev.WeddingInvitation.util.DBConnector;
import com.diworksdev.WeddingInvitation.util.DateUtil;


public class UserRegistCompleteDAO {
	
	private DBConnector dbConnector=new DBConnector();
	private Connection connection=dbConnector.getConnection();	
	private DateUtil dateUtil=new DateUtil();
	private String sql="INSERT INTO login_user(family_name,last_name,family_name_alphabet,last_name_alphabet,"
			+ "mail,password,user_gender,delete_flg,registered_time,update_time) VALUES(?,?,?,?,?,?,?,?,?,?)";

	public boolean createUser(String familyName,String lastName,String familyNameAlphabet,String lastNameAlphabet,
			String mail,String password,String userGender,String deleteFlg) {
		try {
			
			System.out.println(
			        "===== createUser ===== "
			        + System.currentTimeMillis()
			    );
			
			System.out.println("connection = " + connection);
	        System.out.println("familyName = " + familyName);
	        System.out.println("lastName = " + lastName);
	        System.out.println("mail = " + mail);
	        System.out.println("userGender = " + userGender);
	        System.out.println("deleteFlg = " + deleteFlg);
	        System.out.println("date = " + dateUtil.getDate());

			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,familyName);
			preparedStatement.setString(2,lastName);
			preparedStatement.setString(3,familyNameAlphabet);
			preparedStatement.setString(4,lastNameAlphabet);
			preparedStatement.setString(5,mail);
			preparedStatement.setString(6,password);
			preparedStatement.setInt(7,Integer.parseInt(userGender));
			preparedStatement.setInt(8,Integer.parseInt(deleteFlg));
			preparedStatement.setString(9,dateUtil.getDate());
			preparedStatement.setString(10,dateUtil.getDate());
			
			int count = preparedStatement.executeUpdate();

	        System.out.println("insert件数 = " + count);
	        System.out.println("===== INSERT実行直前 =====");

	        return count > 0;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
