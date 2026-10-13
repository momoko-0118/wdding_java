package com.diworksdev.WeddingInvitation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.diworksdev.WeddingInvitation.dto.InvitationDTO;
import com.diworksdev.WeddingInvitation.util.DBConnector;

public class MyInvitationDAO {

    private DBConnector dbConnector = new DBConnector();

    public ArrayList<InvitationDTO> getInvitationList(int userId) {

        ArrayList<InvitationDTO> list = new ArrayList<InvitationDTO>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql =
                "SELECT "
                + "id "
                + "FROM invitation_info "
                + "WHERE user_id = ? "
                + "ORDER BY registered_time DESC";
        
        System.out.println("SQL = " + sql);

        try {

            connection = dbConnector.getConnection();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, userId);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                InvitationDTO dto = new InvitationDTO();

                dto.setId(resultSet.getInt("id"));            
                list.add(dto);
            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            try {

                if (resultSet != null) {
                    resultSet.close();
                }

                if (preparedStatement != null) {
                    preparedStatement.close();
                }

                if (connection != null) {
                    connection.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return list;
    }
}