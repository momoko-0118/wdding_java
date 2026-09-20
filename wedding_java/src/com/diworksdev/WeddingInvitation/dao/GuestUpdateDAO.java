package com.diworksdev.WeddingInvitation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.diworksdev.WeddingInvitation.dto.GuestListDTO;
import com.diworksdev.WeddingInvitation.util.DBConnector;

public class GuestUpdateDAO {

    private DBConnector dbConnector = new DBConnector();

    public boolean updateGuest(GuestListDTO dto) {

        String sql ="UPDATE guest_info SET family_name = ?, last_name = ?, family_name_kana = ?, last_name_kana = ?, "
                + "family_name_alphabet = ?, last_name_alphabet = ?, honorifics = ?, attendance = ?, which_guest = ?, "
                + "guest_gender = ?, relation = ?, birth = ?, allergies = ?, allergies_details = ?, postal_code = ?, "
                + "prefecture = ?, address_1 = ?, address_2 = ?, tel = ?, mail = ?, invitation = ?, "
                + "update_time = NOW() WHERE id = ? AND user_id = ?";
        
        Connection connection = null;

        try {
            connection = dbConnector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, dto.getFamilyName());
            preparedStatement.setString(2, dto.getLastName());
            preparedStatement.setString(3, dto.getFamilyNameKana());
            preparedStatement.setString(4, dto.getLastNameKana());
            preparedStatement.setString(5, dto.getFamilyNameAlphabet());
            preparedStatement.setString(6, dto.getLastNameAlphabet());
            preparedStatement.setString(7, dto.getHonorifics());
            preparedStatement.setString(8, dto.getAttendance());
            preparedStatement.setString(9, dto.getWhichGuest());
            preparedStatement.setInt(10,Integer.parseInt(dto.getGuestGender()));
            preparedStatement.setString(11, dto.getRelation());
            preparedStatement.setInt(12,Integer.parseInt(dto.getBirth()));
            preparedStatement.setString(13, dto.getAllergies());
            preparedStatement.setString(14, dto.getAllergiesDetails());
            preparedStatement.setString(15, dto.getPostalCode());
            preparedStatement.setString(16, dto.getPrefecture());
            preparedStatement.setString(17, dto.getAddress1());
            preparedStatement.setString(18, dto.getAddress2());
            preparedStatement.setString(19, dto.getTel());
            preparedStatement.setString(20, dto.getMail());
            preparedStatement.setString(21, dto.getInvitation());
            preparedStatement.setInt(22, Integer.parseInt(dto.getId()));
            preparedStatement.setInt(23, Integer.parseInt(dto.getUserId()));

            int count = preparedStatement.executeUpdate();

            return count > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
        	if (connection != null) {

                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        	}
        }
    }
}