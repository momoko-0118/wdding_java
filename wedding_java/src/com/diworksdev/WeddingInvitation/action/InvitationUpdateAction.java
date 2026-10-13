package com.diworksdev.WeddingInvitation.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.WeddingInvitation.dao.InvitationUpdateDAO;
import com.diworksdev.WeddingInvitation.dto.InvitationDTO;
import com.opensymphony.xwork2.ActionSupport;

public class InvitationUpdateAction extends ActionSupport implements SessionAware {
	
	private InvitationDTO invitation;
	
	private int id;
    // メインビジュアル
    private String mainGroomName;
    private String mainBrideName;
    private String message;

    // 新郎
    private String groomName;
    private String groomTitle;
    private String groomMessage;

    // 新婦
    private String brideName;
    private String brideTitle;
    private String brideMessage;

    // 家族1
    private String family1Name;
    private String family1Title;
    private String family1Message;

    // 家族2
    private String family2Name;
    private String family2Title;
    private String family2Message;

    // 家族3
    private String family3Name;
    private String family3Title;
    private String family3Message;

    // 家族4
    private String family4Name;
    private String family4Title;
    private String family4Message;

    // 家族5
    private String family5Name;
    private String family5Title;
    private String family5Message;

    // パーティ情報
    private String weddingDate;
    private String types;
    private String ceremonyTime;
    private String receptionTime;
    private String giftMoney;
    private String ceremonyAddInfo;

    // 会場情報
    private String venueName;
    private String venueNameKana;
    private String venuePostalCode;
    private String venueAddress;
    private String venueTel;
    private String venueUrl;
    private String venueAddInfo;

    // ゲスト入力項目
    private boolean whichGuestItemR;
    private boolean whichGuestItemV;

    private boolean guestNameItemR;
    private boolean guestNameItemV;

    private boolean guestNameKanaItemR;
    private boolean guestNameKanaItemV;

    private boolean guestNameAlphabetItemR;
    private boolean guestNameAlphabetItemV;

    private boolean relationItemR;
    private boolean relationItemV;

    private boolean guestGenderItemR;
    private boolean guestGenderItemV;

    private boolean guestBirthItemR;
    private boolean guestBirthItemV;

    private boolean guestAddressItemR;
    private boolean guestAddressItemV;

    private boolean guestTelItemR;
    private boolean guestTelItemV;

    private boolean guestMailItemR;
    private boolean guestMailItemV;

    private boolean allergiesItemR;
    private boolean allergiesItemV;

    private boolean celebratePhotosItemR;
    private boolean celebratePhotosItemV;

    private boolean celebrateMessagesItemR;
    private boolean celebrateMessagesItemV;

    // 回答期限
    private String limitDate;

    // 結び
    private String lastMessage;

    private String errorMessage;

    private Map<String, Object> session;
    private InvitationUpdateDAO invitationUpdateDAO = new InvitationUpdateDAO();

    public String load() {

        // ログイン確認
        if (session.get("id") == null) {
            setErrorMessage("ログイン情報がありません");
            return ERROR;
        }

        // ログインユーザーID
        int userId = Integer.parseInt(session.get("id").toString());

        // DBから招待状を取得
        invitation = invitationUpdateDAO.getInvitation(id, userId);

        if (invitation == null) {
            setErrorMessage("招待状情報の取得に失敗しました");
            return ERROR;
        }

        return SUCCESS;
    }
    
    public String execute() {

        // ログイン確認
        if (session.get("id") == null) {
            setErrorMessage("ログイン情報がありません");
            return ERROR;
        }

        // ログインしているユーザーID
        int userId =
                Integer.parseInt(session.get("id").toString());

        // DTO作成
        InvitationDTO dto = new InvitationDTO();
        dto.setId(id);
        dto.setUserId(userId);

        // メインビジュアル
        dto.setMainGroomName(mainGroomName);
        dto.setMainBrideName(mainBrideName);
        dto.setMessage(message);

        // 新郎
        dto.setGroomName(groomName);
        dto.setGroomTitle(groomTitle);
        dto.setGroomMessage(groomMessage);

        // 新婦
        dto.setBrideName(brideName);
        dto.setBrideTitle(brideTitle);
        dto.setBrideMessage(brideMessage);

        // 家族1
        dto.setFamily1Name(family1Name);
        dto.setFamily1Title(family1Title);
        dto.setFamily1Message(family1Message);

        // 家族2
        dto.setFamily2Name(family2Name);
        dto.setFamily2Title(family2Title);
        dto.setFamily2Message(family2Message);

        // 家族3
        dto.setFamily3Name(family3Name);
        dto.setFamily3Title(family3Title);
        dto.setFamily3Message(family3Message);

        // 家族4
        dto.setFamily4Name(family4Name);
        dto.setFamily4Title(family4Title);
        dto.setFamily4Message(family4Message);

        // 家族5
        dto.setFamily5Name(family5Name);
        dto.setFamily5Title(family5Title);
        dto.setFamily5Message(family5Message);

        // パーティ情報
        dto.setWeddingDate(weddingDate);
        dto.setTypes(types);
        dto.setCeremonyTime(ceremonyTime);
        dto.setReceptionTime(receptionTime);
        dto.setGiftMoney(giftMoney);
        dto.setCeremonyAddInfo(ceremonyAddInfo);

        // 会場情報
        dto.setVenueName(venueName);
        dto.setVenueNameKana(venueNameKana);
        dto.setVenuePostalCode(venuePostalCode);
        dto.setVenueAddress(venueAddress);
        dto.setVenueTel(venueTel);
        dto.setVenueUrl(venueUrl);
        dto.setVenueAddInfo(venueAddInfo);

        // ゲスト入力項目
        dto.setWhichGuestItemR(whichGuestItemR);
        dto.setWhichGuestItemV(whichGuestItemV);

        dto.setGuestNameItemR(guestNameItemR);
        dto.setGuestNameItemV(guestNameItemV);

        dto.setGuestNameKanaItemR(guestNameKanaItemR);
        dto.setGuestNameKanaItemV(guestNameKanaItemV);

        dto.setGuestNameAlphabetItemR(
                guestNameAlphabetItemR);
        dto.setGuestNameAlphabetItemV(
                guestNameAlphabetItemV);

        dto.setRelationItemR(relationItemR);
        dto.setRelationItemV(relationItemV);

        dto.setGuestGenderItemR(guestGenderItemR);
        dto.setGuestGenderItemV(guestGenderItemV);

        dto.setGuestBirthItemR(guestBirthItemR);
        dto.setGuestBirthItemV(guestBirthItemV);

        dto.setGuestAddressItemR(guestAddressItemR);
        dto.setGuestAddressItemV(guestAddressItemV);

        dto.setGuestTelItemR(guestTelItemR);
        dto.setGuestTelItemV(guestTelItemV);

        dto.setGuestMailItemR(guestMailItemR);
        dto.setGuestMailItemV(guestMailItemV);

        dto.setAllergiesItemR(allergiesItemR);
        dto.setAllergiesItemV(allergiesItemV);

        dto.setCelebratePhotosItemR(
                celebratePhotosItemR);
        dto.setCelebratePhotosItemV(
                celebratePhotosItemV);

        dto.setCelebrateMessagesItemR(
                celebrateMessagesItemR);
        dto.setCelebrateMessagesItemV(
                celebrateMessagesItemV);

        // 回答期限
        dto.setLimitDate(limitDate);

        // 結び
        dto.setLastMessage(lastMessage);

        // DB更新
        boolean result =
                invitationUpdateDAO.updateInvitation(dto);

        if (!result) {
            setErrorMessage("招待状情報の更新に失敗しました");
            return ERROR;
        }

        return SUCCESS;
    }

    public InvitationDTO getInvitation() {
        return invitation;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getMainGroomName() {
        return mainGroomName;
    }

    public void setMainGroomName(String mainGroomName) {
        this.mainGroomName = mainGroomName;
    }

    public String getMainBrideName() {
        return mainBrideName;
    }

    public void setMainBrideName(String mainBrideName) {
        this.mainBrideName = mainBrideName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getGroomName() {
        return groomName;
    }

    public void setGroomName(String groomName) {
        this.groomName = groomName;
    }

    public String getGroomTitle() {
        return groomTitle;
    }

    public void setGroomTitle(String groomTitle) {
        this.groomTitle = groomTitle;
    }

    public String getGroomMessage() {
        return groomMessage;
    }

    public void setGroomMessage(String groomMessage) {
        this.groomMessage = groomMessage;
    }

    public String getBrideName() {
        return brideName;
    }

    public void setBrideName(String brideName) {
        this.brideName = brideName;
    }

    public String getBrideTitle() {
        return brideTitle;
    }

    public void setBrideTitle(String brideTitle) {
        this.brideTitle = brideTitle;
    }

    public String getBrideMessage() {
        return brideMessage;
    }

    public void setBrideMessage(String brideMessage) {
        this.brideMessage = brideMessage;
    }

    public String getFamily1Name() {
        return family1Name;
    }

    public void setFamily1Name(String family1Name) {
        this.family1Name = family1Name;
    }

    public String getFamily1Title() {
        return family1Title;
    }

    public void setFamily1Title(String family1Title) {
        this.family1Title = family1Title;
    }

    public String getFamily1Message() {
        return family1Message;
    }

    public void setFamily1Message(String family1Message) {
        this.family1Message = family1Message;
    }

    public String getFamily2Name() {
        return family2Name;
    }

    public void setFamily2Name(String family2Name) {
        this.family2Name = family2Name;
    }

    public String getFamily2Title() {
        return family2Title;
    }

    public void setFamily2Title(String family2Title) {
        this.family2Title = family2Title;
    }

    public String getFamily2Message() {
        return family2Message;
    }

    public void setFamily2Message(String family2Message) {
        this.family2Message = family2Message;
    }

    public String getFamily3Name() {
        return family3Name;
    }

    public void setFamily3Name(String family3Name) {
        this.family3Name = family3Name;
    }

    public String getFamily3Title() {
        return family3Title;
    }

    public void setFamily3Title(String family3Title) {
        this.family3Title = family3Title;
    }

    public String getFamily3Message() {
        return family3Message;
    }

    public void setFamily3Message(String family3Message) {
        this.family3Message = family3Message;
    }

    public String getFamily4Name() {
        return family4Name;
    }

    public void setFamily4Name(String family4Name) {
        this.family4Name = family4Name;
    }

    public String getFamily4Title() {
        return family4Title;
    }

    public void setFamily4Title(String family4Title) {
        this.family4Title = family4Title;
    }

    public String getFamily4Message() {
        return family4Message;
    }

    public void setFamily4Message(String family4Message) {
        this.family4Message = family4Message;
    }

    public String getFamily5Name() {
        return family5Name;
    }

    public void setFamily5Name(String family5Name) {
        this.family5Name = family5Name;
    }

    public String getFamily5Title() {
        return family5Title;
    }

    public void setFamily5Title(String family5Title) {
        this.family5Title = family5Title;
    }

    public String getFamily5Message() {
        return family5Message;
    }

    public void setFamily5Message(String family5Message) {
        this.family5Message = family5Message;
    }

    public String getWeddingDate() {
        return weddingDate;
    }

    public void setWeddingDate(String weddingDate) {
        this.weddingDate = weddingDate;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getCeremonyTime() {
        return ceremonyTime;
    }

    public void setCeremonyTime(String ceremonyTime) {
        this.ceremonyTime = ceremonyTime;
    }

    public String getReceptionTime() {
        return receptionTime;
    }

    public void setReceptionTime(String receptionTime) {
        this.receptionTime = receptionTime;
    }

    public String getGiftMoney() {
        return giftMoney;
    }

    public void setGiftMoney(String giftMoney) {
        this.giftMoney = giftMoney;
    }

    public String getCeremonyAddInfo() {
        return ceremonyAddInfo;
    }

    public void setCeremonyAddInfo(String ceremonyAddInfo) {
        this.ceremonyAddInfo = ceremonyAddInfo;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getVenueNameKana() {
        return venueNameKana;
    }

    public void setVenueNameKana(String venueNameKana) {
        this.venueNameKana = venueNameKana;
    }

    public String getVenuePostalCode() {
        return venuePostalCode;
    }

    public void setVenuePostalCode(String venuePostalCode) {
        this.venuePostalCode = venuePostalCode;
    }

    public String getVenueAddress() {
        return venueAddress;
    }

    public void setVenueAddress(String venueAddress) {
        this.venueAddress = venueAddress;
    }

    public String getVenueTel() {
        return venueTel;
    }

    public void setVenueTel(String venueTel) {
        this.venueTel = venueTel;
    }

    public String getVenueUrl() {
        return venueUrl;
    }

    public void setVenueUrl(String venueUrl) {
        this.venueUrl = venueUrl;
    }

    public String getVenueAddInfo() {
        return venueAddInfo;
    }

    public void setVenueAddInfo(String venueAddInfo) {
        this.venueAddInfo = venueAddInfo;
    }

    public boolean isWhichGuestItemR() {
        return whichGuestItemR;
    }

    public void setWhichGuestItemR(boolean whichGuestItemR) {
        this.whichGuestItemR = whichGuestItemR;
    }

    public boolean isWhichGuestItemV() {
        return whichGuestItemV;
    }

    public void setWhichGuestItemV(boolean whichGuestItemV) {
        this.whichGuestItemV = whichGuestItemV;
    }

    public boolean isGuestNameItemR() {
        return guestNameItemR;
    }

    public void setGuestNameItemR(boolean guestNameItemR) {
        this.guestNameItemR = guestNameItemR;
    }

    public boolean isGuestNameItemV() {
        return guestNameItemV;
    }

    public void setGuestNameItemV(boolean guestNameItemV) {
        this.guestNameItemV = guestNameItemV;
    }

    public boolean isGuestNameKanaItemR() {
        return guestNameKanaItemR;
    }

    public void setGuestNameKanaItemR(boolean guestNameKanaItemR) {
        this.guestNameKanaItemR = guestNameKanaItemR;
    }

    public boolean isGuestNameKanaItemV() {
        return guestNameKanaItemV;
    }

    public void setGuestNameKanaItemV(boolean guestNameKanaItemV) {
        this.guestNameKanaItemV = guestNameKanaItemV;
    }

    public boolean isGuestNameAlphabetItemR() {
        return guestNameAlphabetItemR;
    }

    public void setGuestNameAlphabetItemR(boolean guestNameAlphabetItemR) {
        this.guestNameAlphabetItemR = guestNameAlphabetItemR;
    }

    public boolean isGuestNameAlphabetItemV() {
        return guestNameAlphabetItemV;
    }

    public void setGuestNameAlphabetItemV(boolean guestNameAlphabetItemV) {
        this.guestNameAlphabetItemV = guestNameAlphabetItemV;
    }

    public boolean isRelationItemR() {
        return relationItemR;
    }

    public void setRelationItemR(boolean relationItemR) {
        this.relationItemR = relationItemR;
    }

    public boolean isRelationItemV() {
        return relationItemV;
    }

    public void setRelationItemV(boolean relationItemV) {
        this.relationItemV = relationItemV;
    }

    public boolean isGuestGenderItemR() {
        return guestGenderItemR;
    }

    public void setGuestGenderItemR(boolean guestGenderItemR) {
        this.guestGenderItemR = guestGenderItemR;
    }

    public boolean isGuestGenderItemV() {
        return guestGenderItemV;
    }

    public void setGuestGenderItemV(boolean guestGenderItemV) {
        this.guestGenderItemV = guestGenderItemV;
    }

    public boolean isGuestBirthItemR() {
        return guestBirthItemR;
    }

    public void setGuestBirthItemR(boolean guestBirthItemR) {
        this.guestBirthItemR = guestBirthItemR;
    }

    public boolean isGuestBirthItemV() {
        return guestBirthItemV;
    }

    public void setGuestBirthItemV(boolean guestBirthItemV) {
        this.guestBirthItemV = guestBirthItemV;
    }

    public boolean isGuestAddressItemR() {
        return guestAddressItemR;
    }

    public void setGuestAddressItemR(boolean guestAddressItemR) {
        this.guestAddressItemR = guestAddressItemR;
    }

    public boolean isGuestAddressItemV() {
        return guestAddressItemV;
    }

    public void setGuestAddressItemV(boolean guestAddressItemV) {
        this.guestAddressItemV = guestAddressItemV;
    }

    public boolean isGuestTelItemR() {
        return guestTelItemR;
    }

    public void setGuestTelItemR(boolean guestTelItemR) {
        this.guestTelItemR = guestTelItemR;
    }

    public boolean isGuestTelItemV() {
        return guestTelItemV;
    }

    public void setGuestTelItemV(boolean guestTelItemV) {
        this.guestTelItemV = guestTelItemV;
    }

    public boolean isGuestMailItemR() {
        return guestMailItemR;
    }

    public void setGuestMailItemR(boolean guestMailItemR) {
        this.guestMailItemR = guestMailItemR;
    }

    public boolean isGuestMailItemV() {
        return guestMailItemV;
    }

    public void setGuestMailItemV(boolean guestMailItemV) {
        this.guestMailItemV = guestMailItemV;
    }

    public boolean isAllergiesItemR() {
        return allergiesItemR;
    }

    public void setAllergiesItemR(boolean allergiesItemR) {
        this.allergiesItemR = allergiesItemR;
    }

    public boolean isAllergiesItemV() {
        return allergiesItemV;
    }

    public void setAllergiesItemV(boolean allergiesItemV) {
        this.allergiesItemV = allergiesItemV;
    }

    public boolean isCelebratePhotosItemR() {
        return celebratePhotosItemR;
    }

    public void setCelebratePhotosItemR(boolean celebratePhotosItemR) {
        this.celebratePhotosItemR = celebratePhotosItemR;
    }

    public boolean isCelebratePhotosItemV() {
        return celebratePhotosItemV;
    }

    public void setCelebratePhotosItemV(boolean celebratePhotosItemV) {
        this.celebratePhotosItemV = celebratePhotosItemV;
    }

    public boolean isCelebrateMessagesItemR() {
        return celebrateMessagesItemR;
    }

    public void setCelebrateMessagesItemR(boolean celebrateMessagesItemR) {
        this.celebrateMessagesItemR = celebrateMessagesItemR;
    }

    public boolean isCelebrateMessagesItemV() {
        return celebrateMessagesItemV;
    }

    public void setCelebrateMessagesItemV(boolean celebrateMessagesItemV) {
        this.celebrateMessagesItemV = celebrateMessagesItemV;
    }

    public String getLimitDate() {
        return limitDate;
    }

    public void setLimitDate(String limitDate) {
        this.limitDate = limitDate;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}