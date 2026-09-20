package com.diworksdev.WeddingInvitation.action;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.WeddingInvitation.dao.LoginDAO;
import com.diworksdev.WeddingInvitation.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

    public String loginMail;
    public String loginPassword;
    public String errorMessage;
    
    private Map<String, Object> session;
    
    private LoginDAO loginDAO = new LoginDAO();
    private LoginDTO loginDTO = new LoginDTO();
    
    @Override
    public String execute() {

        if(loginMail == null || loginMail.isEmpty() || loginPassword == null || loginPassword.isEmpty()) {
        	setErrorMessage("メールアドレスとパスワードを入力してください");
        	return ERROR;
        }
        
        String password = loginPassword.toString();
        
        MessageDigest sha256;
		String pass = "";
    	try {
			sha256 = MessageDigest.getInstance("SHA-256");
			byte[] hash = sha256.digest(password.getBytes());	
			StringBuilder sb = new StringBuilder();
			for(byte b : hash){
			    sb.append(String.format("%02x", b));
			}
			pass = sb.toString();
			System.out.println(sha256.digest(password.getBytes()));
			System.out.println(pass);
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
    	
    	loginDTO = loginDAO.getLoginUserInfo(loginMail,pass);

    	if (loginDTO.getLoginFlg()) {
    		String id = loginDTO.getId();
    	    System.out.println("DTOから取得 id = " + id);

    	    session.put("id", id);

    	    System.out.println(
    	        "session保存後 id = " + session.get("id")
			    );
			return SUCCESS;
    	}
    	setErrorMessage("メールアドレスかパスワードが間違っています");
        return ERROR;
    }

   public String getLoginMail() {
	   return loginMail;
   }
   
   public void setLoginMail(String loginMail) {
	   this.loginMail = loginMail;
   }
   
   public String getLoginPassword() {
	   return loginPassword;
   }
   
   public void setLoginPassword(String loginPassword) {
	   this.loginPassword = loginPassword;
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
