package com.diworksdev.WeddingInvitation.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.WeddingInvitation.dao.URLConfigureDAO;
import com.opensymphony.xwork2.ActionSupport;

public class URLConfigureAction extends ActionSupport implements SessionAware {

    private String invitationSlug;
    private String errorMessage;
    private String message;

    private Map<String, Object> session;

    private URLConfigureDAO urlConfigureDAO = new URLConfigureDAO();

    public String execute() {

        System.out.println("===== URLConfigureAction =====");
        System.out.println("invitationSlug = " + invitationSlug);

        if (session.get("userId") == null) {
            setErrorMessage("ログイン情報がありません。");
            return ERROR;
        }

        if (invitationSlug == null || invitationSlug.isEmpty()) {
            setErrorMessage("URLを入力してください。");
            return ERROR;
        }

        if (!invitationSlug.matches("^[a-zA-Z0-9-]+$")) {
            setErrorMessage("英数字とハイフンのみ入力できます。");
            return ERROR;
        }

        int userId = Integer.parseInt(
            session.get("userId").toString()
        );

        boolean duplication =
            urlConfigureDAO.checkDuplication(
                invitationSlug,
                userId
            );

        if (duplication) {
            setErrorMessage("このURLは既に使用されています。");
            return ERROR;
        }

        boolean result =
            urlConfigureDAO.updateInvitationSlug(
                userId,
                invitationSlug
            );

        if (!result) {
            setErrorMessage("URLの設定に失敗しました。");
            return ERROR;
        }

        setMessage("URLを設定しました。");

        return SUCCESS;
    }

    public String getInvitationSlug() {
        return invitationSlug;
    }

    public void setInvitationSlug(String invitationSlug) {
        this.invitationSlug = invitationSlug;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}