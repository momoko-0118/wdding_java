package com.diworksdev.WeddingInvitation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.diworksdev.WeddingInvitation.util.DBConnector;

public class GuestRegistDAO {

    private DBConnector dbConnector = new DBConnector();

    public int getUserIdBySlug(String invitationSlug) {

        int userId = 0;

        String sql =
            "SELECT id FROM login_user WHERE invitation_slug = ?";

        try {
            Connection connection =
                dbConnector.getConnection();

            PreparedStatement preparedStatement =
                connection.prepareStatement(sql);

            preparedStatement.setString(1, invitationSlug);

            ResultSet resultSet =
                preparedStatement.executeQuery();

            if (resultSet.next()) {
                userId = resultSet.getInt("id");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return userId;
    }
}