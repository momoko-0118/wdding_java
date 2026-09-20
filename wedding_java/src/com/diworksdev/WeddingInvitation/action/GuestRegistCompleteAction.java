package com.diworksdev.WeddingInvitation.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.WeddingInvitation.dao.GuestRegistCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class GuestRegistCompleteAction extends ActionSupport implements SessionAware{
	
private Map<String,Object> session;
	
	private String errorMessage;
	private GuestRegistCompleteDAO GuestRegistCompleteDAO=new GuestRegistCompleteDAO();
	
	public String execute() throws SQLException{
		
		 System.out.println(
			        "===== CompleteAction execute ===== "
			        + System.currentTimeMillis()
			    );
		
		boolean data=GuestRegistCompleteDAO.createGuest(
				session.get("userId").toString(),
				session.get("familyName").toString(),
				session.get("lastName").toString(),
				session.get("familyNameKana").toString(),
				session.get("lastNameKana").toString(),
				session.get("familyNameAlphabet").toString(),
				session.get("lastNameAlphabet").toString(),
				session.get("attendance").toString(),
				session.get("whichGuest").toString(),
				session.get("guestGender").toString(),
				session.get("relation").toString(),
				session.get("birth").toString(),
				session.get("allergies").toString(),
				session.get("allergiesDetails").toString(),
				session.get("postalCode").toString(),
				session.get("prefecture").toString(),
				session.get("address1").toString(),
				session.get("address2").toString(),
				session.get("tel").toString(),
				session.get("mail").toString(),				
				session.get("deleteFlg").toString());
		String result = SUCCESS;
		if(!data) {
			result=ERROR;
			setErrorMessage("エラーが発生したためアカウント登録できません。");
		}
		return result;				
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage=errorMessage;
	}
	
	@Override
	public void setSession(Map<String,Object> session) {
		this.session=session;
	}


}
