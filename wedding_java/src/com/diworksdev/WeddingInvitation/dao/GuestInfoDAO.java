package com.diworksdev.WeddingInvitation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.diworksdev.WeddingInvitation.dto.GuestListDTO;
import com.diworksdev.WeddingInvitation.util.DBConnector;

public class GuestInfoDAO {
	
	private DBConnector dbConnector=new DBConnector();
	private Connection connection=dbConnector.getConnection();
	
	public GuestListDTO getGuest(int id) throws SQLException{		
		GuestListDTO dto = new GuestListDTO();
		String sql ="SELECT gi.id,gi.user_id,gi.family_name,gi.last_name,gi.family_name_kana,gi.last_name_kana,"
				+ "gi.family_name_alphabet,gi.last_name_alphabet,gi.honorifics,gi.attendance,gi.which_guest,"
				+ "ggi.guest_gender_info,gi.relation,gi.birth,gi.allergies,gi.allergies_details,gi.postal_code,"
				+ "gi.prefecture,gi.address_1,gi.address_2,gi.tel,gi.mail,gi.invitation,fi.flg,"
				+ "gi.registered_time,gi.update_time FROM guest_info gi "
				+ "LEFT JOIN guest_gender_info ggi ON gi.guest_gender=ggi.id "
				+ "LEFT JOIN flg_info fi ON gi.delete_flg=fi.id "
				+ "ORDER BY gi.registered_time DESC";
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				dto.setId(resultSet.getString("id"));
				dto.setUserId(resultSet.getString("user_id"));
				dto.setFamilyName(resultSet.getString("family_name"));
				dto.setLastName(resultSet.getString("last_name"));
				dto.setFamilyNameKana(resultSet.getString("family_name_kana"));
				dto.setLastNameKana(resultSet.getString("last_name_kana"));
				dto.setFamilyNameAlphabet(resultSet.getString("family_name_alphabet"));
				dto.setLastNameAlphabet(resultSet.getString("last_name_alphabet"));
				dto.setHonorifics(resultSet.getString("honorifics"));
				dto.setAttendance(resultSet.getString("attendance"));
				dto.setWhichGuest(resultSet.getString("which_guest"));
				dto.setGuestGenderInfo(resultSet.getString("guest_gender_info"));
				dto.setRelation(resultSet.getString("relation"));
				dto.setBirth(resultSet.getString("birth"));
				dto.setAllergies(resultSet.getString("allergies"));
				dto.setAllergiesDetails(resultSet.getString("allergies_details"));
				dto.setPostalCode(resultSet.getString("postal_code"));
				dto.setPrefecture(resultSet.getString("prefecture"));
				dto.setAddress1(resultSet.getString("address_1"));
				dto.setAddress2(resultSet.getString("address_2"));
				dto.setTel(resultSet.getString("tel"));
				dto.setMail(resultSet.getString("mail"));
				dto.setInvitation(resultSet.getString("invitation"));
				dto.setDeleteFlg(resultSet.getString("flg"));
				dto.setRegisteredTime(resultSet.getString("registered_time"));
				dto.setUpdateTime(resultSet.getString("update_time"));
			}
			}catch(Exception e) {
			e.printStackTrace();
		}finally {
				connection.close();
		}
		return dto;
	}

}
