package com.diworksdev.WeddingInvitation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.diworksdev.WeddingInvitation.dto.InvitationDTO;
import com.diworksdev.WeddingInvitation.util.DBConnector;

public class InvitationUpdateDAO {

    private DBConnector dbConnector = new DBConnector();
    
    /**
     * 更新画面表示用
     * 招待状ID + ログインユーザーIDで招待状を1件取得する
     */
    public InvitationDTO getInvitation(int id, int userId) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql =
                "SELECT * "
                + "FROM invitation_info "
                + "WHERE id = ? "
                + "AND user_id = ?";

        try {

            connection = dbConnector.getConnection();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, userId);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                InvitationDTO dto = new InvitationDTO();

                dto.setId(resultSet.getInt("id"));
                dto.setUserId(resultSet.getInt("user_id"));
                dto.setDesignId(resultSet.getInt("design_id"));

                // メイン
                dto.setMainGroomName(resultSet.getString("main_groom_name"));
                dto.setMainBrideName(resultSet.getString("main_bride_name"));
                dto.setMessage(resultSet.getString("message"));

                // 新郎
                dto.setGroomName(resultSet.getString("groom_name"));
                dto.setGroomTitle(resultSet.getString("groom_title"));
                dto.setGroomMessage(resultSet.getString("groom_message"));

                // 新婦
                dto.setBrideName(resultSet.getString("bride_name"));
                dto.setBrideTitle(resultSet.getString("bride_title"));
                dto.setBrideMessage(resultSet.getString("bride_message"));

                // 家族1
                dto.setFamily1Name(resultSet.getString("family1_name"));
                dto.setFamily1Title(resultSet.getString("family1_title"));
                dto.setFamily1Message(resultSet.getString("family1_message"));

                // 家族2
                dto.setFamily2Name(resultSet.getString("family2_name"));
                dto.setFamily2Title(resultSet.getString("family2_title"));
                dto.setFamily2Message(resultSet.getString("family2_message"));

                // 家族3
                dto.setFamily3Name(resultSet.getString("family3_name"));
                dto.setFamily3Title(resultSet.getString("family3_title"));
                dto.setFamily3Message(resultSet.getString("family3_message"));

                // 家族4
                dto.setFamily4Name(resultSet.getString("family4_name"));
                dto.setFamily4Title(resultSet.getString("family4_title"));
                dto.setFamily4Message(resultSet.getString("family4_message"));

                // 家族5
                dto.setFamily5Name(resultSet.getString("family5_name"));
                dto.setFamily5Title(resultSet.getString("family5_title"));
                dto.setFamily5Message(resultSet.getString("family5_message"));

                // 結婚式概要
                dto.setWeddingDate(resultSet.getString("wedding_date"));
                dto.setTypes(resultSet.getString("types"));
                dto.setCeremonyTime(resultSet.getString("ceremony_time"));
                dto.setReceptionTime(resultSet.getString("reception_time"));
                dto.setGiftMoney(resultSet.getString("gift_money"));
                dto.setCeremonyAddInfo(resultSet.getString("ceremony_add_info"));

                // 会場
                dto.setVenueName( resultSet.getString("venue_name"));
                dto.setVenueNameKana(resultSet.getString("venue_name_kana"));
                dto.setVenuePostalCode(resultSet.getString("venue_postal_code"));
                dto.setVenueAddress(resultSet.getString("venue_address"));
                dto.setVenueTel(resultSet.getString("venue_tel"));
                dto.setVenueUrl(resultSet.getString("venue_url"));
                dto.setVenueAddInfo(resultSet.getString("venue_add_info"));

                // ゲスト入力項目
                dto.setWhichGuestItemR(resultSet.getBoolean("which_guest_item_r"));
                dto.setWhichGuestItemV(resultSet.getBoolean("which_guest_item_v"));
                dto.setGuestNameItemR(resultSet.getBoolean("guest_name_item_r"));
                dto.setGuestNameItemV(resultSet.getBoolean("guest_name_item_v"));
                dto.setGuestNameKanaItemR(resultSet.getBoolean("guest_name_kana_item_r"));
                dto.setGuestNameKanaItemV(resultSet.getBoolean("guest_name_kana_item_v"));
                dto.setGuestNameAlphabetItemR(resultSet.getBoolean("guest_name_alphabet_item_r"));
                dto.setGuestNameAlphabetItemV(resultSet.getBoolean("guest_name_alphabet_item_v"));
                dto.setRelationItemR(resultSet.getBoolean("relation_item_r"));
                dto.setRelationItemV(resultSet.getBoolean("relation_item_v"));
                dto.setGuestGenderItemR(resultSet.getBoolean("guest_gender_item_r"));
                dto.setGuestGenderItemV(resultSet.getBoolean("guest_gender_item_v"));
                dto.setGuestBirthItemR(resultSet.getBoolean("guest_birth_item_r"));
                dto.setGuestBirthItemV(resultSet.getBoolean("guest_birth_item_v"));
                dto.setGuestAddressItemR(resultSet.getBoolean("guest_address_item_r"));
                dto.setGuestAddressItemV(resultSet.getBoolean("guest_address_item_v"));
                dto.setGuestTelItemR(resultSet.getBoolean("guest_tel_item_r"));
                dto.setGuestTelItemV(resultSet.getBoolean("guest_tel_item_v"));
                dto.setGuestMailItemR(resultSet.getBoolean("guest_mail_item_r"));
                dto.setGuestMailItemV(resultSet.getBoolean("guest_mail_item_v"));
                dto.setAllergiesItemR(resultSet.getBoolean("allergies_item_r"));
                dto.setAllergiesItemV(resultSet.getBoolean("allergies_item_v"));
                dto.setCelebratePhotosItemR(resultSet.getBoolean("celebrate_photos_item_r"));
                dto.setCelebratePhotosItemV(resultSet.getBoolean("celebrate_photos_item_v"));
                dto.setCelebrateMessagesItemR(resultSet.getBoolean("celebrate_messages_item_r"));
                dto.setCelebrateMessagesItemV(resultSet.getBoolean("celebrate_messages_item_v"));

                // 回答期限・結び
                dto.setLimitDate(resultSet.getString("limit_date"));
                dto.setLastMessage(resultSet.getString("last_message"));

                return dto;
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

        return null;
    }
    
    //招待状更新
    public boolean updateInvitation(InvitationDTO dto) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql =
                "UPDATE invitation_info SET "
                + "main_groom_name = ?, "
                + "main_bride_name = ?, "
                + "message = ?, "
                + "groom_name = ?, "
                + "groom_title = ?, "
                + "groom_message = ?, "
                + "bride_name = ?, "
                + "bride_title = ?, "
                + "bride_message = ?, "
                + "family1_name = ?, "
                + "family1_title = ?, "
                + "family1_message = ?, "
                + "family2_name = ?, "
                + "family2_title = ?, "
                + "family2_message = ?, "
                + "family3_name = ?, "
                + "family3_title = ?, "
                + "family3_message = ?, "
                + "family4_name = ?, "
                + "family4_title = ?, "
                + "family4_message = ?, "
                + "family5_name = ?, "
                + "family5_title = ?, "
                + "family5_message = ?, "
                + "wedding_date = ?, "
                + "types = ?, "
                + "ceremony_time = ?, "
                + "reception_time = ?, "
                + "gift_money = ?, "
                + "ceremony_add_info = ?, "
                + "venue_name = ?, "
                + "venue_name_kana = ?, "
                + "venue_postal_code = ?, "
                + "venue_address = ?, "
                + "venue_tel = ?, "
                + "venue_url = ?, "
                + "venue_add_info = ?, "
                + "which_guest_item_r = ?, "
                + "which_guest_item_v = ?, "
                + "guest_name_item_r = ?, "
                + "guest_name_item_v = ?, "
                + "guest_name_kana_item_r = ?, "
                + "guest_name_kana_item_v = ?, "
                + "guest_name_alphabet_item_r = ?, "
                + "guest_name_alphabet_item_v = ?, "
                + "relation_item_r = ?, "
                + "relation_item_v = ?, "
                + "guest_gender_item_r = ?, "
                + "guest_gender_item_v = ?, "
                + "guest_birth_item_r = ?, "
                + "guest_birth_item_v = ?, "
                + "guest_address_item_r = ?, "
                + "guest_address_item_v = ?, "
                + "guest_tel_item_r = ?, "
                + "guest_tel_item_v = ?, "
                + "guest_mail_item_r = ?, "
                + "guest_mail_item_v = ?, "
                + "allergies_item_r = ?, "
                + "allergies_item_v = ?, "
                + "celebrate_photos_item_r = ?, "
                + "celebrate_photos_item_v = ?, "
                + "celebrate_messages_item_r = ?, "
                + "celebrate_messages_item_v = ?, "
                + "limit_date = ?, "
                + "last_message = ?, "
                + "update_time = NOW() "
                + "WHERE id = ? AND user_id = ?";

        try {

            connection = dbConnector.getConnection();

            preparedStatement =
                    connection.prepareStatement(sql);

            int index = 1;

            // メイン
            preparedStatement.setString(index++, dto.getMainGroomName());
            preparedStatement.setString(index++, dto.getMainBrideName());
            preparedStatement.setString(index++, dto.getMessage());

            // 新郎
            preparedStatement.setString(index++, dto.getGroomName());
            preparedStatement.setString(index++, dto.getGroomTitle());
            preparedStatement.setString(index++, dto.getGroomMessage());

            // 新婦
            preparedStatement.setString(index++, dto.getBrideName());
            preparedStatement.setString(index++, dto.getBrideTitle());
            preparedStatement.setString(index++, dto.getBrideMessage());

            // 家族1
            preparedStatement.setString(index++, dto.getFamily1Name());
            preparedStatement.setString(index++, dto.getFamily1Title());
            preparedStatement.setString(index++, dto.getFamily1Message());

            // 家族2
            preparedStatement.setString(index++, dto.getFamily2Name());
            preparedStatement.setString(index++, dto.getFamily2Title());
            preparedStatement.setString(index++, dto.getFamily2Message());

            // 家族3
            preparedStatement.setString(index++, dto.getFamily3Name());
            preparedStatement.setString(index++, dto.getFamily3Title());
            preparedStatement.setString(index++, dto.getFamily3Message());

            // 家族4
            preparedStatement.setString(index++, dto.getFamily4Name());

            preparedStatement.setString(index++, dto.getFamily4Title());

            preparedStatement.setString(index++, dto.getFamily4Message());

            // 家族5
            preparedStatement.setString(index++, dto.getFamily5Name());
            preparedStatement.setString(index++, dto.getFamily5Title());
            preparedStatement.setString(index++, dto.getFamily5Message());

            //結婚式概要
            preparedStatement.setString(index++,dto.getWeddingDate());
            preparedStatement.setString(index++, dto.getTypes());
            preparedStatement.setString(index++,dto.getCeremonyTime());
            preparedStatement.setString(index++,dto.getReceptionTime());
            preparedStatement.setString(index++, dto.getGiftMoney());
            preparedStatement.setString(index++, dto.getCeremonyAddInfo());

            // 会場
            preparedStatement.setString(index++, dto.getVenueName());
            preparedStatement.setString(index++, dto.getVenueNameKana());
            preparedStatement.setString(index++, dto.getVenuePostalCode());
            preparedStatement.setString(index++, dto.getVenueAddress());
            preparedStatement.setString(index++,dto.getVenueTel());
            preparedStatement.setString(index++, dto.getVenueUrl());
            preparedStatement.setString(index++, dto.getVenueAddInfo());

            //ゲスト入力項目
            preparedStatement.setBoolean(index++, dto.isWhichGuestItemR());
            preparedStatement.setBoolean(index++, dto.isWhichGuestItemV());

            preparedStatement.setBoolean(index++, dto.isGuestNameItemR());
            preparedStatement.setBoolean(index++, dto.isGuestNameItemV());

            preparedStatement.setBoolean(index++, dto.isGuestNameKanaItemR());
            preparedStatement.setBoolean(index++, dto.isGuestNameKanaItemV());

            preparedStatement.setBoolean(index++, dto.isGuestNameAlphabetItemR());
            preparedStatement.setBoolean(index++, dto.isGuestNameAlphabetItemV());

            preparedStatement.setBoolean(index++, dto.isRelationItemR());
            preparedStatement.setBoolean(index++, dto.isRelationItemV());

            preparedStatement.setBoolean(index++, dto.isGuestGenderItemR());
            preparedStatement.setBoolean(index++, dto.isGuestGenderItemV());

            preparedStatement.setBoolean(index++, dto.isGuestBirthItemR());
            preparedStatement.setBoolean(index++, dto.isGuestBirthItemV());

            preparedStatement.setBoolean(index++, dto.isGuestAddressItemR());
            preparedStatement.setBoolean(index++, dto.isGuestAddressItemV());

            preparedStatement.setBoolean(index++, dto.isGuestTelItemR());
            preparedStatement.setBoolean(index++, dto.isGuestTelItemV());

            preparedStatement.setBoolean(index++, dto.isGuestMailItemR());
            preparedStatement.setBoolean(index++, dto.isGuestMailItemV());

            preparedStatement.setBoolean(index++, dto.isAllergiesItemR());
            preparedStatement.setBoolean(index++, dto.isAllergiesItemV());

            preparedStatement.setBoolean(index++, dto.isCelebratePhotosItemR());
            preparedStatement.setBoolean(index++, dto.isCelebratePhotosItemV());

            preparedStatement.setBoolean(index++, dto.isCelebrateMessagesItemR());
            preparedStatement.setBoolean(index++, dto.isCelebrateMessagesItemV());

            // 回答期限
            preparedStatement.setString(index++,dto.getLimitDate());
            preparedStatement.setString(index++, dto.getLastMessage());

            // 更新対象の招待状ID
            preparedStatement.setInt(index++, dto.getId());

            // ログインユーザーID
            preparedStatement.setInt(index++, dto.getUserId());

            int count =  preparedStatement.executeUpdate();

            return count > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;

        } finally {

            try {

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
    }

}