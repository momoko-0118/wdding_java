package com.diworksdev.WeddingInvitation.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware {

    private Map<String, Object> session;

    private boolean loggedIn;

    public String execute() {

        if (session.get("id") != null) {
            loggedIn = true;
        } else {
            loggedIn = false;
        }

        return SUCCESS;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    @Override
    public void setSession(
            Map<String, Object> session) {

        this.session = session;
    }
}