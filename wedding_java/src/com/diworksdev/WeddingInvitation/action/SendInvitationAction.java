package com.diworksdev.WeddingInvitation.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.WeddingInvitation.dao.UserInfoDAO;
import com.diworksdev.WeddingInvitation.dto.ListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SendInvitationAction extends ActionSupport implements SessionAware {

    private String invitationSlug;
    private String errorMessage;
    private Map<String, Object> session;
    private UserInfoDAO userInfoDAO = new UserInfoDAO();
    private ListDTO user = new ListDTO();

    public String execute() throws Exception {

        if (session.get("id")== null){
            setErrorMessage("ログイン情報がありません");
            return ERROR;
        }

        int id = Integer.parseInt(session.get("id").toString());
        
        user = userInfoDAO.getUser(id);
        
        if (user == null) {
        	setErrorMessage("ユーザー情報が見つかりません");
        	return ERROR;
        }

        invitationSlug = user.getInvitationSlug();
        if (invitationSlug == null || invitationSlug.isEmpty()) {
            setErrorMessage(
                "招待状URLが設定されていません"
            );
            return ERROR;
        }
        return SUCCESS;
    }
    
    public String getInvitationSlug() {
        return invitationSlug;
    }

    public void setInvitationSlug(
            String invitationSlug) {
        this.invitationSlug = invitationSlug;
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