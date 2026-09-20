package com.diworksdev.WeddingInvitation.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.WeddingInvitation.dao.GuestRegistDAO;
import com.opensymphony.xwork2.ActionSupport;

public class GuestRegistAction extends ActionSupport implements SessionAware {

    private String invitationSlug;
    private String errorMessage;
    private Map<String, Object> session;
    private GuestRegistDAO guestRegistDAO = new GuestRegistDAO();

    public String execute() {

        System.out.println(
            "invitationSlug = " + invitationSlug
        );
        if (invitationSlug == null ||
                invitationSlug.isEmpty()) {
            setErrorMessage(
                "招待URLが正しくありません。"
            );
            return ERROR;
        }

        int userId =guestRegistDAO.getUserIdBySlug(
                invitationSlug
            );

        System.out.println("取得したuserId = " + userId);

        if (userId == 0) {
            setErrorMessage(
                "招待状が見つかりません。"
            );
            return ERROR;
        }
        session.put("userId", userId);
        return SUCCESS;
    }

    public String getInvitationSlug() {
        return invitationSlug;
    }

    public void setInvitationSlug(String invitationSlug) {
        this.invitationSlug =invitationSlug;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
    	this.errorMessage =errorMessage;
    }

    @Override
    public void setSession(Map<String, Object> session) {
    	this.session = session;
    }
}