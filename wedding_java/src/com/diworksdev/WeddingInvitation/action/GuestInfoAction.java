package com.diworksdev.WeddingInvitation.action;

import java.sql.SQLException;

import com.diworksdev.WeddingInvitation.dao.GuestInfoDAO;
import com.diworksdev.WeddingInvitation.dto.GuestListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GuestInfoAction extends ActionSupport {

	private int id;
    private GuestListDTO guest = new GuestListDTO();
    private final GuestInfoDAO guestInfoDAO = new GuestInfoDAO();

    @Override
    public String execute() {
        try {
            guest = guestInfoDAO.getGuest(id);
            System.out.println(guest);
            if (guest == null) {
                return ERROR;
            }
            System.out.println("取得したゲストID = " + guest.getId());
            return SUCCESS;
        } catch (SQLException e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public GuestListDTO getGuest() {
        return guest;
    }
    
    public void setGuest(GuestListDTO guest) {
        this.guest = guest;
    }
	
	public void setId(int id) {
		this.id=id;
	}
	
	public int getId() {
		return id;
	}
}
