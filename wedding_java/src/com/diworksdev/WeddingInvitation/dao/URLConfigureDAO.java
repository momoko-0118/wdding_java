package com.diworksdev.WeddingInvitation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.diworksdev.WeddingInvitation.util.DBConnector;

public class URLConfigureDAO {

    private DBConnector dbConnector = new DBConnector();

    public boolean checkDuplication(
            String invitationSlug,
            int userId) {

        String sql =
            "SELECT id FROM login_user "
            + "WHERE invitation_slug = ? "
            + "AND id != ?";

        try {
            Connection connection =
                dbConnector.getConnection();

            PreparedStatement preparedStatement =
                connection.prepareStatement(sql);

            preparedStatement.setString(
                1,
                invitationSlug
            );

            preparedStatement.setInt(
                2,
                userId
            );

            ResultSet resultSet =
                preparedStatement.executeQuery();

            return resultSet.next();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateInvitationSlug(
            int userId,
            String invitationSlug) {

        String sql =
            "UPDATE login_user "
            + "SET invitation_slug = ? "
            + "WHERE id = ?";

        try {
            Connection connection =
                dbConnector.getConnection();

            PreparedStatement preparedStatement =
                connection.prepareStatement(sql);

            preparedStatement.setString(1,invitationSlug);
            preparedStatement.setInt(2,userId);

            int count =
                preparedStatement.executeUpdate();

            return count > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}