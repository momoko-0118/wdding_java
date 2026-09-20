package com.diworksdev.WeddingInvitation.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.WeddingInvitation.dao.UserRegistConfirmDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserRegistConfirmAction extends ActionSupport implements SessionAware{

	public UserRegistConfirmDAO userRegistConfirmDAO = new UserRegistConfirmDAO();
	
	public String familyName;
	public String lastName;
	public String familyNameAlphabet;
	public String lastNameAlphabet;
	public String mail;
	public String password;
	public String pass2;
	public int userGender;
	public String gen;
	public int deleteFlg;
	
	public Map<String,Object>session;
	private String errorFamilyName;
	private String errorLastName;
	private String errorFamilyNameAlphabet;
	private String errorLastNameAlphabet;
	private String errorMail;
	private String errorPass;
	private String errorUserGender;
	
	public String execute() {
		
		System.out.println("===== 最新コード実行 =====");
	    System.out.println("familyName = " + familyName);
	    System.out.println("password = " + password);
		
		String result = SUCCESS;
		
		if(familyName != null && !familyName.isEmpty()) {
			session.put("familyName", familyName);
		}else {
			setErrorFamilyName("名前（姓）が未入力です");
			result = ERROR;
		}
		
		if(lastName != null && !lastName.isEmpty()) {
			session.put("lastName", lastName);
		}else {
			setErrorLastName("名前（名）が未入力です");
			result = ERROR;
		}
		
		if(familyNameAlphabet != null && !familyNameAlphabet.isEmpty()) {
			session.put("familyNameAlphabet", familyNameAlphabet);
		}else {
			setErrorFamilyNameAlphabet("名前（ローマ字姓）が未入力です");
			result = ERROR;
		}
		
		if(lastNameAlphabet != null && !lastNameAlphabet.isEmpty()) {
			session.put("lastNameAlphabet", lastNameAlphabet);
		}else {
			setErrorLastNameAlphabet("名前（ローマ字名）が未入力です");
			result = ERROR;
		}
		
		if(mail != null && !mail.isEmpty()) {
			session.put("mail", mail);
		}else {
			setErrorMail("メールアドレスが未入力です");
			result = ERROR;
		}
		
		System.out.println(password);
		if(password != null && !password.isEmpty()) {
			System.out.println("===== password処理開始 =====");
			session.put("password", password);
			System.out.println("session put 完了");
			this.pass2=String.format("%"+password.length()+"s","").replace(' ', '●');
			System.out.println("pass2作成完了");
			System.out.println(password.length());
			System.out.println(String.format("%"+password.length()+"s",""));
			session.put("pass2", pass2);
			System.out.println(pass2);
		}else {
			setErrorPass("パスワードが未入力です");
			result = ERROR;
		}
		
		if(userGender==0) {
			// 男
			this.gen="男";
			session.put("userGender",userGender);
			//session.put("gen",this.gen);
		}else if(userGender==1) {
			// 女
			this.gen="女";
			session.put("userGender",userGender);
			//session.put("gen",this.gen);
		}else {
			setErrorUserGender("性別が未入力です");
			result=ERROR;
		}
		
		if(result.equals(SUCCESS)) {
		    if(userRegistConfirmDAO.duplication(mail)) {
		        setErrorMail("既に登録されているメールアドレスです");
		        result = ERROR;
		    }
		}
		
		System.out.println(session);
		System.out.println(familyName);
		System.out.println(familyNameAlphabet);
		System.out.println(lastName);
		System.out.println(lastNameAlphabet);
		System.out.println(mail);
		System.out.println(password);
		System.out.println(userGender);
		deleteFlg=0;
		session.put("deleteFlg",deleteFlg);
		return result;
		
	}
	
	public String getFamilyName() {
		return familyName;
	}
	
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFamilyNameAlphabet() {
		return familyNameAlphabet;
	}
	
	public void setFamilyNameAlphabet(String familyNameAlphabet) {
		this.familyNameAlphabet = familyNameAlphabet;
	}
	
	public String getLastNameAlphabet() {
		return lastNameAlphabet;
	}
	
	public void setLastNameAlphabet(String lastNameAlphabet) {
		this.lastNameAlphabet = lastNameAlphabet;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getPassword() {
	    return password;
	}

	public void setPassword(String password) {
	    this.password = password;
	}
	
	public int getUserGender() {
		return userGender;
	}
	
	public void setUserGender(int userGender) {
		this.userGender = userGender;
	}
	
	public String getGen() {
		return gen;
	}
	
	public void setGen(String gen) {
		this.gen = gen;
	}
	
	public int getDeleteFlg() {
		return deleteFlg;
	}
	
	public void setDeleteFlg(int deleteFlg) {
		this.deleteFlg=deleteFlg;
	}
	
	public Map<String,Object>getSession(){
		return session;
	}
	
	@Override
	public void setSession(Map<String,Object>session) {
		this.session=session;
	}
	
	public String getErrorFamilyName() {
		return errorFamilyName;
	}
	
	public void setErrorFamilyName(String errorFamilyName) {
		this.errorFamilyName=errorFamilyName;
	}
	
	public String getErrorLastName() {
		return errorLastName;
	}
	
	public void setErrorLastName(String errorLastName) {
		this.errorLastName=errorLastName;
	}
	
	public String getErrorFamilyNameAlphabet() {
		return errorFamilyNameAlphabet;
	}
	
	public void setErrorFamilyNameAlphabet(String errorFamilyNameAlphabet) {
		this.errorFamilyNameAlphabet=errorFamilyNameAlphabet;
	}
	
	public String getErrorLastNameAlphabet() {
		return errorLastNameAlphabet;
	}
	
	public void setErrorLastNameAlphabet(String errorLastNameAlphabet) {
		this.errorLastNameAlphabet=errorLastNameAlphabet;
	}
	
	public String getErrorMail() {
		return errorMail;
	}
	
	public void setErrorMail(String errorMail) {
		this.errorMail=errorMail;
	}
	
	public String getErrorPass() {
		return errorPass;
	}
	
	public void setErrorPass(String errorPass) {
		this.errorPass=errorPass;
	}
	
	public String getErrorUserGender() {
		return errorUserGender;
	}
	
	public void setErrorUserGender(String errorUserGender) {
		this.errorUserGender=errorUserGender;
	}
	
}
