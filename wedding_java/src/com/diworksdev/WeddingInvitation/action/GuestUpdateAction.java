package com.diworksdev.WeddingInvitation.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.WeddingInvitation.dao.GuestUpdateDAO;
import com.diworksdev.WeddingInvitation.dto.GuestListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GuestUpdateAction extends ActionSupport implements SessionAware {

    private int id;

    private String familyName;
    private String lastName;
    private String familyNameKana;
    private String lastNameKana;
    private String familyNameAlphabet;
    private String lastNameAlphabet;
    private String honorifics;
    private String attendance;
    private String whichGuest;
    private String guestGender;
    private String relation;
    private String birth;
    private String allergies;
    private String allergiesDetails;
    private String postalCode;
    private String prefecture;
    private String address1;
    private String address2;
    private String tel;
    private String mail;
    private String invitation;

    private String errorMessage;

    private Map<String, Object> session;

    private GuestUpdateDAO guestUpdateDAO = new GuestUpdateDAO();

    public String execute() {

        if (session.get("id") == null) {
        	setErrorMessage("ログイン情報がありません");
            return ERROR;
        }

        // ログインしているユーザーID
        int userId = Integer.parseInt(session.get("id").toString());

        // DTOに更新するゲスト情報を入れる
        GuestListDTO dto = new GuestListDTO();

        dto.setId(String.valueOf(id));
        dto.setUserId(String.valueOf(userId));
        dto.setFamilyName(familyName);
        dto.setLastName(lastName);
        dto.setFamilyNameKana(familyNameKana);
        dto.setLastNameKana(lastNameKana);
        dto.setFamilyNameAlphabet(familyNameAlphabet);
        dto.setLastNameAlphabet(lastNameAlphabet);
        dto.setHonorifics(honorifics);
        dto.setAttendance(attendance);
        dto.setWhichGuest(whichGuest);
        dto.setGuestGender(guestGender);
        dto.setRelation(relation);
        dto.setBirth(birth);
        dto.setAllergies(allergies);
        dto.setAllergiesDetails(allergiesDetails);
        dto.setPostalCode(postalCode);
        dto.setPrefecture(prefecture);
        dto.setAddress1(address1);
        dto.setAddress2(address2);
        dto.setTel(tel);
        dto.setMail(mail);
        dto.setInvitation(invitation);
        
        // DB更新
        boolean result = guestUpdateDAO.updateGuest(dto);
        
        if (!result) {
            setErrorMessage("ゲスト情報の更新に失敗しました");
            return ERROR;
        }
        return SUCCESS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(
            String familyName) {
        this.familyName = familyName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(
            String lastName) {
        this.lastName = lastName;
    }

    public String getFamilyNameKana() {
        return familyNameKana;
    }

    public void setFamilyNameKana(
            String familyNameKana) {
        this.familyNameKana = familyNameKana;
    }

    public String getLastNameKana() {
        return lastNameKana;
    }

    public void setLastNameKana(
            String lastNameKana) {
        this.lastNameKana = lastNameKana;
    }

    public String getFamilyNameAlphabet() {
        return familyNameAlphabet;
    }

    public void setFamilyNameAlphabet(
            String familyNameAlphabet) {
        this.familyNameAlphabet =
                familyNameAlphabet;
    }

    public String getLastNameAlphabet() {
        return lastNameAlphabet;
    }

    public void setLastNameAlphabet(
            String lastNameAlphabet) {
        this.lastNameAlphabet =
                lastNameAlphabet;
    }

    public String getHonorifics() {
        return honorifics;
    }

    public void setHonorifics(
            String honorifics) {
        this.honorifics = honorifics;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(
            String attendance) {
        this.attendance = attendance;
    }

    public String getWhichGuest() {
        return whichGuest;
    }

    public void setWhichGuest(
            String whichGuest) {
        this.whichGuest = whichGuest;
    }

    public String getGuestGender() {
        return guestGender;
    }

    public void setGuestGender(
            String guestGender) {
        this.guestGender = guestGender;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(
            String relation) {
        this.relation = relation;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(
            String birth) {
        this.birth = birth;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(
            String allergies) {
        this.allergies = allergies;
    }

    public String getAllergiesDetails() {
        return allergiesDetails;
    }

    public void setAllergiesDetails(
            String allergiesDetails) {
        this.allergiesDetails =
                allergiesDetails;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(
            String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPrefecture() {
        return prefecture;
    }

    public void setPrefecture(
            String prefecture) {
        this.prefecture = prefecture;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(
            String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(
            String address2) {
        this.address2 = address2;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(
            String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(
            String mail) {
        this.mail = mail;
    }

    public String getInvitation() {
        return invitation;
    }

    public void setInvitation(
            String invitation) {
        this.invitation = invitation;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(
            String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public void setSession(
            Map<String, Object> session) {
        this.session = session;
    }
}