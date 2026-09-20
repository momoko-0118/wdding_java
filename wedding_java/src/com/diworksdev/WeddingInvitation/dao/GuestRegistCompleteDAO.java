package com.diworksdev.WeddingInvitation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.diworksdev.WeddingInvitation.util.DBConnector;
import com.diworksdev.WeddingInvitation.util.DateUtil;

public class GuestRegistCompleteDAO {
	
	private DBConnector dbConnector=new DBConnector();
	private Connection connection=dbConnector.getConnection();	
	private DateUtil dateUtil=new DateUtil();
	private String sql="INSERT INTO guest_info(user_id,family_name,last_name,family_name_kana,last_name_kana,"
			+ "family_name_alphabet,last_name_alphabet,attendance,which_guest,guest_gender,relation,birth,"
			+ "allergies,allergies_details,postal_code,prefecture,address_1,address_2,tel,mail,"
			+ "delete_flg,registered_time,update_time) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public boolean createGuest(String userId,String familyName,String lastName,String familyNameKana,String lastNameKana,
			String familyNameAlphabet,String lastNameAlphabet,String attendance,String whichGuest,String guestGender,
			String relation,String birth,String allergies,String allergiesDetails,String postalCode,
			String prefecture,String address1,String address2,String tel,String mail,String deleteFlg) {
		try {
			
			System.out.println(
			        "===== createUser ===== "
			        + System.currentTimeMillis()
			    );

			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, Integer.parseInt(userId));
			preparedStatement.setString(2,familyName);
			preparedStatement.setString(3,lastName);
			preparedStatement.setString(4,familyNameKana);
			preparedStatement.setString(5,lastNameKana);
			preparedStatement.setString(6,familyNameAlphabet);
			preparedStatement.setString(7,lastNameAlphabet);
			preparedStatement.setString(8,attendance);
			preparedStatement.setString(9,whichGuest);
			preparedStatement.setInt(10,Integer.parseInt(guestGender));
			preparedStatement.setString(11,relation);
			preparedStatement.setString(12,birth);
			preparedStatement.setString(13,allergies);
			preparedStatement.setString(14,allergiesDetails);
			preparedStatement.setString(15,postalCode);
			preparedStatement.setString(16,prefecture);
			preparedStatement.setString(17,address1);
			preparedStatement.setString(18,address2);
			preparedStatement.setString(19,tel);
			preparedStatement.setString(20,mail);
			preparedStatement.setInt(21,Integer.parseInt(deleteFlg));
			preparedStatement.setString(22,dateUtil.getDate());
			preparedStatement.setString(23,dateUtil.getDate());
			
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
