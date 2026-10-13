package com.diworksdev.WeddingInvitation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.diworksdev.WeddingInvitation.util.DBConnector;

public class SendInvitationDAO {

    private DBConnector dbConnector = new DBConnector();

    public String getInvitationSlug(int invitationId,int userId) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql =
                "SELECT invitation_slug "
                + "FROM invitation_info "
                + "WHERE id = ? "
                + "AND user_id = ?";

        try {

            connection = dbConnector.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,invitationId);
            preparedStatement.setInt(2,userId);

            System.out.println("招待状ID = " + invitationId);
            System.out.println("ユーザーID = " + userId);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                String invitationSlug = resultSet.getString("invitation_slug");
                System.out.println("取得したinvitationSlug = " + invitationSlug);

                return invitationSlug;
            }

            System.out.println("対象の招待状が見つかりませんでした");

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

        return null;
    }
}