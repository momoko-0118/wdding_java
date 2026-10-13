package com.diworksdev.WeddingInvitation.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware {

    private Map<String, Object> session;

    @Override
    public String execute() {

        // セッションに保存されているログイン情報を削除
        if (session != null) {
            session.clear();
        }

        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}