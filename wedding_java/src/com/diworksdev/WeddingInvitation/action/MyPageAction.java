package com.diworksdev.WeddingInvitation.action;

import java.sql.SQLException;

import com.diworksdev.WeddingInvitation.dao.UserInfoDAO;
import com.diworksdev.WeddingInvitation.dto.ListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport{
	
	private int id;
    private ListDTO user = new ListDTO();
    private final UserInfoDAO userInfoDAO = new UserInfoDAO();

    @Override
    public String execute() {
        try {
            user = userInfoDAO.getUser(id);
            System.out.println("mypageaction"+user);
            return SUCCESS;
        } catch (SQLException e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public ListDTO getUser() {
        return user;
    }
	
	public void setId(int id) {
		this.id=id;
	}
	
	public int getId() {
		return id;
	}

}
