package com.diworksdev.WeddingInvitation.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.WeddingInvitation.dao.MyInvitationDAO;
import com.diworksdev.WeddingInvitation.dto.InvitationDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyInvitationAction
        extends ActionSupport
        implements SessionAware {

    private Map<String, Object> session;

    private ArrayList<InvitationDTO> invitationList =
            new ArrayList<InvitationDTO>();

    private String errorMessage;

    private MyInvitationDAO myInvitationDAO =
            new MyInvitationDAO();

    public String execute() {
    	
    	System.out.println("session.id = " + session.get("id"));

        if (session.get("id") == null) {

            setErrorMessage(
                    "ログイン情報がありません");

            return ERROR;
        }

        int userId = Integer.parseInt(session.get("id").toString());
        System.out.println("MyInvitation userId = " + userId);

        invitationList = myInvitationDAO.getInvitationList(userId);
        System.out.println("取得した招待状件数" + invitationList.size());

        return SUCCESS;
    }

    public ArrayList<InvitationDTO> getInvitationList() {
        return invitationList;
    }

    public void setInvitationList(ArrayList<InvitationDTO> invitationList) {
        this.invitationList = invitationList;
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