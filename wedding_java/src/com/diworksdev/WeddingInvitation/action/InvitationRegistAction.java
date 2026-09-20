package com.diworksdev.WeddingInvitation.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.WeddingInvitation.dao.InvitationRegistDAO;
import com.diworksdev.WeddingInvitation.dto.InvitationDTO;
import com.opensymphony.xwork2.ActionSupport;

public class InvitationRegistAction extends ActionSupport implements SessionAware {

    private Map<String, Object> session;

    private int designId;

    private String mainGroomName;
    private String mainBrideName;
    private String message;

    private String groomName;
    private String groomTitle;
    private String groomMessage;

    private String brideName;
    private String brideTitle;
    private String brideMessage;

    private String family1Name;
    private String family1Title;
    private String family1Message;

    private String family2Name;
    private String family2Title;
    private String family2Message;

    private String family3Name;
    private String family3Title;
    private String family3Message;

    private String family4Name;
    private String family4Title;
    private String family4Message;

    private String family5Name;
    private String family5Title;
    private String family5Message;

    private String weddingDate;
    private String types;
    private String ceremonyTime;
    private String receptionTime;
    private String giftMoney;
    private String ceremonyAddInfo;

    private String venueName;
    private String venueNameKana;
    private String venuePostalCode;
    private String venueAddress;
    private String venueTel;
    private String venueUrl;
    private String venueAddInfo;

    private String addInfo1Title;
    private String addInfo1Details;
    private String addInfo2Title;
    private String addInfo2Details;
    private String addInfo3Title;
    private String addInfo3Details;
    private String addInfo4Title;
    private String addInfo4Details;
    private String addInfo5Title;
    private String addInfo5Details;

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

    private String limitDate;
    private String lastMessage;

    private String errorMessage;

    private final InvitationRegistDAO invitationRegistDAO =
            new InvitationRegistDAO();

    @Override
    public String execute() {

        if (session.get("id") == null) {
            errorMessage = "ログイン情報がありません";
            return ERROR;
        }

        int userId = Integer.parseInt(
                session.get("id").toString()
        );

        InvitationDTO dto =
                new InvitationDTO();

        dto.setUserId(userId);
        dto.setDesignId(designId);

        dto.setMainGroomName(mainGroomName);
        dto.setMainBrideName(mainBrideName);
        dto.setMessage(message);

        dto.setGroomName(groomName);
        dto.setGroomTitle(groomTitle);
        dto.setGroomMessage(groomMessage);

        dto.setBrideName(brideName);
        dto.setBrideTitle(brideTitle);
        dto.setBrideMessage(brideMessage);

        dto.setFamily1Name(family1Name);
        dto.setFamily1Title(family1Title);
        dto.setFamily1Message(family1Message);

        dto.setFamily2Name(family2Name);
        dto.setFamily2Title(family2Title);
        dto.setFamily2Message(family2Message);

        dto.setFamily3Name(family3Name);
        dto.setFamily3Title(family3Title);
        dto.setFamily3Message(family3Message);

        dto.setFamily4Name(family4Name);
        dto.setFamily4Title(family4Title);
        dto.setFamily4Message(family4Message);

        dto.setFamily5Name(family5Name);
        dto.setFamily5Title(family5Title);
        dto.setFamily5Message(family5Message);

        dto.setWeddingDate(weddingDate);
        dto.setTypes(types);
        dto.setCeremonyTime(ceremonyTime);
        dto.setReceptionTime(receptionTime);
        dto.setGiftMoney(giftMoney);
        dto.setCeremonyAddInfo(ceremonyAddInfo);

        dto.setVenueName(venueName);
        dto.setVenueNameKana(venueNameKana);
        dto.setVenuePostalCode(venuePostalCode);
        dto.setVenueAddress(venueAddress);
        dto.setVenueTel(venueTel);
        dto.setVenueUrl(venueUrl);
        dto.setVenueAddInfo(venueAddInfo);

        dto.setAddInfo1Title(addInfo1Title);
        dto.setAddInfo1Details(addInfo1Details);
        dto.setAddInfo2Title(addInfo2Title);
        dto.setAddInfo2Details(addInfo2Details);
        dto.setAddInfo3Title(addInfo3Title);
        dto.setAddInfo3Details(addInfo3Details);
        dto.setAddInfo4Title(addInfo4Title);
        dto.setAddInfo4Details(addInfo4Details);
        dto.setAddInfo5Title(addInfo5Title);
        dto.setAddInfo5Details(addInfo5Details);

        dto.setWhichGuestItemR(whichGuestItemR);
        dto.setWhichGuestItemV(whichGuestItemV);

        dto.setGuestNameItemR(guestNameItemR);
        dto.setGuestNameItemV(guestNameItemV);

        dto.setGuestNameKanaItemR(guestNameKanaItemR);
        dto.setGuestNameKanaItemV(guestNameKanaItemV);

        dto.setGuestNameAlphabetItemR(guestNameAlphabetItemR);
        dto.setGuestNameAlphabetItemV(guestNameAlphabetItemV);

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

        dto.setCelebratePhotosItemR(celebratePhotosItemR);
        dto.setCelebratePhotosItemV(celebratePhotosItemV);

        dto.setCelebrateMessagesItemR(celebrateMessagesItemR);
        dto.setCelebrateMessagesItemV(celebrateMessagesItemV);

        dto.setLimitDate(limitDate);
        dto.setLastMessage(lastMessage);

        boolean result =
                invitationRegistDAO.insert(dto);

        if (!result) {
            errorMessage =
                    "招待状の登録に失敗しました";
            return ERROR;
        }

        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public int getDesignId() {
        return designId;
    }

    public void setDesignId(int designId) {
        this.designId = designId;
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

    public String getAddInfo1Title() {
        return addInfo1Title;
    }

    public void setAddInfo1Title(String addInfo1Title) {
        this.addInfo1Title = addInfo1Title;
    }

    public String getAddInfo1Details() {
        return addInfo1Details;
    }

    public void setAddInfo1Details(String addInfo1Details) {
        this.addInfo1Details = addInfo1Details;
    }

    public String getAddInfo2Title() {
        return addInfo2Title;
    }

    public void setAddInfo2Title(String addInfo2Title) {
        this.addInfo2Title = addInfo2Title;
    }

    public String getAddInfo2Details() {
        return addInfo2Details;
    }

    public void setAddInfo2Details(String addInfo2Details) {
        this.addInfo2Details = addInfo2Details;
    }

    public String getAddInfo3Title() {
        return addInfo3Title;
    }

    public void setAddInfo3Title(String addInfo3Title) {
        this.addInfo3Title = addInfo3Title;
    }

    public String getAddInfo3Details() {
        return addInfo3Details;
    }

    public void setAddInfo3Details(String addInfo3Details) {
        this.addInfo3Details = addInfo3Details;
    }

    public String getAddInfo4Title() {
        return addInfo4Title;
    }

    public void setAddInfo4Title(String addInfo4Title) {
        this.addInfo4Title = addInfo4Title;
    }

    public String getAddInfo4Details() {
        return addInfo4Details;
    }

    public void setAddInfo4Details(String addInfo4Details) {
        this.addInfo4Details = addInfo4Details;
    }

    public String getAddInfo5Title() {
        return addInfo5Title;
    }

    public void setAddInfo5Title(String addInfo5Title) {
        this.addInfo5Title = addInfo5Title;
    }

    public String getAddInfo5Details() {
        return addInfo5Details;
    }

    public void setAddInfo5Details(String addInfo5Details) {
        this.addInfo5Details = addInfo5Details;
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
}