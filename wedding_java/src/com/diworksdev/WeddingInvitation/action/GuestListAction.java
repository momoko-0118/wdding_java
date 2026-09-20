package com.diworksdev.WeddingInvitation.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.diworksdev.WeddingInvitation.dao.GuestListDAO;
import com.diworksdev.WeddingInvitation.dto.GuestListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GuestListAction extends ActionSupport {

    private List<GuestListDTO> guests = new ArrayList<>();
    private final GuestListDAO guestListDAO = new GuestListDAO();

    @Override
    public String execute() {
        try {
            guests = guestListDAO.getAllList();
            return SUCCESS;
        } catch (SQLException e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public List<GuestListDTO> getGuests() {
        return guests;
    }
}