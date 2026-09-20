package com.diworksdev.WeddingInvitation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.diworksdev.WeddingInvitation.dto.InvitationDTO;
import com.diworksdev.WeddingInvitation.util.DBConnector;

public class InvitationRegistDAO {

    private DBConnector dbConnector =
            new DBConnector();

    public boolean insert(InvitationDTO dto) {

        String sql =
                "INSERT INTO invitation_info ("
                + "user_id, "
                + "design_id, "
                + "main_groom_name, "
                + "main_bride_name, "
                + "message, "
                + "groom_name, "
                + "groom_title, "
                + "groom_message, "
                + "bride_name, "
                + "bride_title, "
                + "bride_message, "
                + "family1_name, "
                + "family1_title, "
                + "family1_message, "
                + "family2_name, "
                + "family2_title, "
                + "family2_message, "
                + "family3_name, "
                + "family3_title, "
                + "family3_message, "
                + "family4_name, "
                + "family4_title, "
                + "family4_message, "
                + "family5_name, "
                + "family5_title, "
                + "family5_message, "
                + "wedding_date, "
                + "types, "
                + "ceremony_time, "
                + "reception_time, "
                + "gift_money, "
                + "ceremony_add_info, "
                + "venue_name, "
                + "venue_name_kana, "
                + "venue_postal_code, "
                + "venue_address, "
                + "venue_tel, "
                + "venue_url, "
                + "venue_add_info, "
                + "add_info1_title, "
                + "add_info1_details, "
                + "add_info2_title, "
                + "add_info2_details, "
                + "add_info3_title, "
                + "add_info3_details, "
                + "add_info4_title, "
                + "add_info4_details, "
                + "add_info5_title, "
                + "add_info5_details, "
                + "which_guest_item_r, "
                + "which_guest_item_v, "
                + "guest_name_item_r, "
                + "guest_name_item_v, "
                + "guest_name_kana_item_r, "
                + "guest_name_kana_item_v, "
                + "guest_name_alphabet_item_r, "
                + "guest_name_alphabet_item_v, "
                + "relation_item_r, "
                + "relation_item_v, "
                + "guest_gender_item_r, "
                + "guest_gender_item_v, "
                + "guest_birth_item_r, "
                + "guest_birth_item_v, "
                + "guest_address_item_r, "
                + "guest_address_item_v, "
                + "guest_tel_item_r, "
                + "guest_tel_item_v, "
                + "guest_mail_item_r, "
                + "guest_mail_item_v, "
                + "allergies_item_r, "
                + "allergies_item_v, "
                + "celebrate_photos_item_r, "
                + "celebrate_photos_item_v, "
                + "celebrate_messages_item_r, "
                + "celebrate_messages_item_v, "
                + "limit_date, "
                + "last_message, "
                + "registered_time, "
                + "update_time"
                + ") VALUES ("
                + "?,?,?,?,?,?,?,?,?,?,"
                + "?,?,?,?,?,?,?,?,?,?,"
                + "?,?,?,?,?,?,?,?,?,?,"
                + "?,?,?,?,?,?,?,?,?,?,"
                + "?,?,?,?,?,?,?,?,?,?,"
                + "?,?,?,?,?,?,?,?,?,?,"
                + "?,?,?,?,?,?,?,?,?,?,"
                + "?,?,?,?,?,?,?,"
                + "NOW(), NOW()"
                + ")";

        Connection connection = null;

        try {

            connection =
                    dbConnector.getConnection();

            PreparedStatement ps =
                    connection.prepareStatement(sql);

            int index = 1;

            ps.setInt(index++, dto.getUserId());
            ps.setInt(index++, dto.getDesignId());

            ps.setString(index++, dto.getMainGroomName());
            ps.setString(index++, dto.getMainBrideName());
            ps.setString(index++, dto.getMessage());

            ps.setString(index++, dto.getGroomName());
            ps.setString(index++, dto.getGroomTitle());
            ps.setString(index++, dto.getGroomMessage());

            ps.setString(index++, dto.getBrideName());
            ps.setString(index++, dto.getBrideTitle());
            ps.setString(index++, dto.getBrideMessage());

            ps.setString(index++, dto.getFamily1Name());
            ps.setString(index++, dto.getFamily1Title());
            ps.setString(index++, dto.getFamily1Message());

            ps.setString(index++, dto.getFamily2Name());
            ps.setString(index++, dto.getFamily2Title());
            ps.setString(index++, dto.getFamily2Message());

            ps.setString(index++, dto.getFamily3Name());
            ps.setString(index++, dto.getFamily3Title());
            ps.setString(index++, dto.getFamily3Message());

            ps.setString(index++, dto.getFamily4Name());
            ps.setString(index++, dto.getFamily4Title());
            ps.setString(index++, dto.getFamily4Message());

            ps.setString(index++, dto.getFamily5Name());
            ps.setString(index++, dto.getFamily5Title());
            ps.setString(index++, dto.getFamily5Message());

            ps.setString(index++, dto.getWeddingDate());
            ps.setString(index++, dto.getTypes());
            ps.setString(index++, dto.getCeremonyTime());
            ps.setString(index++, dto.getReceptionTime());
            ps.setString(index++, dto.getGiftMoney());
            ps.setString(index++, dto.getCeremonyAddInfo());

            ps.setString(index++, dto.getVenueName());
            ps.setString(index++, dto.getVenueNameKana());
            ps.setString(index++, dto.getVenuePostalCode());
            ps.setString(index++, dto.getVenueAddress());
            ps.setString(index++, dto.getVenueTel());
            ps.setString(index++, dto.getVenueUrl());
            ps.setString(index++, dto.getVenueAddInfo());

            ps.setString(index++, dto.getAddInfo1Title());
            ps.setString(index++, dto.getAddInfo1Details());
            ps.setString(index++, dto.getAddInfo2Title());
            ps.setString(index++, dto.getAddInfo2Details());
            ps.setString(index++, dto.getAddInfo3Title());
            ps.setString(index++, dto.getAddInfo3Details());
            ps.setString(index++, dto.getAddInfo4Title());
            ps.setString(index++, dto.getAddInfo4Details());
            ps.setString(index++, dto.getAddInfo5Title());
            ps.setString(index++, dto.getAddInfo5Details());

            ps.setBoolean(index++, dto.isWhichGuestItemR());
            ps.setBoolean(index++, dto.isWhichGuestItemV());

            ps.setBoolean(index++, dto.isGuestNameItemR());
            ps.setBoolean(index++, dto.isGuestNameItemV());

            ps.setBoolean(index++, dto.isGuestNameKanaItemR());
            ps.setBoolean(index++, dto.isGuestNameKanaItemV());

            ps.setBoolean(index++, dto.isGuestNameAlphabetItemR());
            ps.setBoolean(index++, dto.isGuestNameAlphabetItemV());

            ps.setBoolean(index++, dto.isRelationItemR());
            ps.setBoolean(index++, dto.isRelationItemV());

            ps.setBoolean(index++, dto.isGuestGenderItemR());
            ps.setBoolean(index++, dto.isGuestGenderItemV());

            ps.setBoolean(index++, dto.isGuestBirthItemR());
            ps.setBoolean(index++, dto.isGuestBirthItemV());

            ps.setBoolean(index++, dto.isGuestAddressItemR());
            ps.setBoolean(index++, dto.isGuestAddressItemV());

            ps.setBoolean(index++, dto.isGuestTelItemR());
            ps.setBoolean(index++, dto.isGuestTelItemV());

            ps.setBoolean(index++, dto.isGuestMailItemR());
            ps.setBoolean(index++, dto.isGuestMailItemV());

            ps.setBoolean(index++, dto.isAllergiesItemR());
            ps.setBoolean(index++, dto.isAllergiesItemV());

            ps.setBoolean(index++, dto.isCelebratePhotosItemR());
            ps.setBoolean(index++, dto.isCelebratePhotosItemV());

            ps.setBoolean(index++, dto.isCelebrateMessagesItemR());
            ps.setBoolean(index++, dto.isCelebrateMessagesItemV());

            ps.setString(index++, dto.getLimitDate());
            ps.setString(index++, dto.getLastMessage());

            int count = ps.executeUpdate();

            return count > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;

        } finally {

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