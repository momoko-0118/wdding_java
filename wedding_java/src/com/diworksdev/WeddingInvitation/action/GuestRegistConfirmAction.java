package com.diworksdev.WeddingInvitation.action;

import java.util.Arrays;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.WeddingInvitation.dao.GuestRegistConfirmDAO;
import com.opensymphony.xwork2.ActionSupport;

public class GuestRegistConfirmAction extends ActionSupport implements SessionAware{
	
public GuestRegistConfirmDAO guestRegistConfirmDAO = new GuestRegistConfirmDAO();
	
	public String familyName;
	public String lastName;
	public String familyNameKana;
	public String lastNameKana;
	public String familyNameAlphabet;
	public String lastNameAlphabet;
	public String attendance;
	public String whichGuest;
	public Integer guestGender;
	public String gen;
	public String relation;
	public String birth;
	public String allergies;
	public String allergiesDetails;
	public String postalCode;
	public String prefecture;
	public String address1;
	public String address2;
	public String tel;
	public String mail;
	
	public int deleteFlg;
	
	public Map<String,Object>session;
	private String errorFamilyName;
	private String errorLastName;
	private String errorFamilyNameKana;
	private String errorLastNameKana;
	private String errorFamilyNameAlphabet;
	private String errorLastNameAlphabet;
	private String errorAttendance;
	private String errorWhichGuest;
	private String errorGuestGender;
	private String errorRelation;
	private String errorBirth;
	private String errorAllergies;
	private String errorAllergiesDetails;
	private String errorPostalCode;
	private String errorPrefecture;
	private String errorAddress1;
	private String errorAddress2;
	private String errorTel;
	private String errorMail;
	
	private String[] pre = {
		    "北海道",
		    "青森県", "岩手県", "宮城県", "秋田県", "山形県", "福島県",
		    "茨城県", "栃木県", "群馬県", "埼玉県", "千葉県", "東京都", "神奈川県",
		    "新潟県", "富山県", "石川県", "福井県", "山梨県", "長野県",
		    "岐阜県", "静岡県", "愛知県", "三重県",
		    "滋賀県", "京都府", "大阪府", "兵庫県", "奈良県", "和歌山県",
		    "鳥取県", "島根県", "岡山県", "広島県", "山口県",
		    "徳島県", "香川県", "愛媛県", "高知県",
		    "福岡県", "佐賀県", "長崎県", "熊本県", "大分県", "宮崎県", "鹿児島県",
		    "沖縄県"
		};
	
	public String execute() {
		
		System.out.println("===== 最新コード実行 =====");
	    System.out.println("familyName = " + familyName);
		
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
		
		if(familyNameKana != null && !familyNameKana.isEmpty()) {
			session.put("familyNameKana", familyNameKana);
		}else {
			setErrorFamilyNameKana("カナ（姓）が未入力です");
			result = ERROR;
		}
		
		if(lastNameKana != null && !lastNameKana.isEmpty()) {
			session.put("lastNameKana", lastNameKana);
		}else {
			setErrorLastNameKana("カナ（名）が未入力です");
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
		
		if(attendance != null && !attendance.isEmpty()) {
			session.put("attendance", attendance);
		}else {
			setErrorAttendance("出欠が未入力です");
			result = ERROR;
		}
		
		if(whichGuest != null && !whichGuest.isEmpty()) {
			session.put("whichGuest", whichGuest);
		}else {
			setErrorWhichGuest("どちらのゲストか選んでください");
			result = ERROR;
		}
		
		if(guestGender==0) {
			// 男
			this.gen="男";
			session.put("guestGender",guestGender);
			//session.put("gen",this.gen);
		}else if(guestGender==1) {
			// 女
			this.gen="女";
			session.put("guestGender",guestGender);
			//session.put("gen",this.gen);
		}else {
			setErrorGuestGender("性別が未入力です");
			result=ERROR;
		}
		
		if(relation != null && !relation.isEmpty()) {
			session.put("relation", relation);
		}else {
			setErrorRelation("関係性を選んでください");
			result = ERROR;
		}
		
		if(birth != null && !birth.isEmpty()) {
			session.put("birth", birth);
		}else {
			setErrorBirth("生年月日が未入力です");
			result = ERROR;
		}
		
		if(allergies != null && !allergies.isEmpty()) {
			session.put("allergies", allergies);
		}else {
			setErrorAllergies("アレルギーが未入力です");
			result = ERROR;
		}
		
		if("あり".equals(allergies)) {
			if(allergiesDetails != null && !allergiesDetails.isEmpty()) {
				session.put("allergiesDetails", allergiesDetails);				
			}else {				
				setErrorAllergiesDetails("アレルギー詳細を入力してください");
				result = ERROR;
			}
		} else {
			session.put("allergiesDetails", "");
		}
		
		if(postalCode != null && !postalCode.isEmpty()) {
			session.put("postalCode", postalCode);
		}else {
			setErrorPostalCode("郵便番号が未入力です");
			result = ERROR;
		}
		
		if(prefecture != null && Arrays.asList(pre).contains(prefecture)) {
			session.put("prefecture", prefecture);
		}else {
			setErrorPrefecture("都道府県が未入力です");
			result = ERROR;
		}
		
		if(address1 != null && !address1.isEmpty()) {
			session.put("address1", address1);
		}else {
			setErrorAddress1("住所が未入力です");
			result = ERROR;
		}
		
		if(address2 != null && !address2.isEmpty()) {
			session.put("address2", address2);
		}else {
			setErrorAddress2("住所が未入力です");
			result = ERROR;
		}
		
		if(tel != null && !tel.isEmpty()) {
			session.put("tel", tel);
		}else {
			setErrorTel("電話番号が未入力です");
			result = ERROR;
		}
		if(mail != null && !mail.isEmpty()) {
			session.put("mail", mail);
		}else {
			setErrorMail("メールアドレスが未入力です");
			result = ERROR;
		}
		
		if(result.equals(SUCCESS)) {
		    if(guestRegistConfirmDAO.duplication(mail)) {
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
	
	public String getFamilyNameKana() {
		return familyNameKana;
	}
	
	public void setFamilyNameKana(String familyNameKana) {
		this.familyNameKana = familyNameKana;
	}
	
	public String getLastNameKana() {
		return lastNameKana;
	}
	
	public void setLastNameKana(String lastNameKana) {
		this.lastNameKana = lastNameKana;
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
	
	public String getAttendance() {
		return attendance;
	}
	
	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}	
	
	public String getWhichGuest() {
		return whichGuest;
	}
	
	public void setWhichGuest(String whichGuest) {
		this.whichGuest = whichGuest;
	}	
	
	public int getGuestGender() {
		return guestGender;
	}
	
	public void setGuestGender(int guestGender) {
		this.guestGender = guestGender;
	}
	
	public String getGen() {
		return gen;
	}
	
	public void setGen(String gen) {
		this.gen = gen;
	}
	
	public String getRelation() {
		return relation;
	}
	
	public void setRelation(String relation) {
		this.relation = relation;
	}	
	
	public String getBirth() {
		return birth;
	}
	
	public void setBirth(String birth) {
		this.birth = birth;
	}	
	
	public String getAllergies() {
		return allergies;
	}
	
	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}	
	
	public String getAllergiesDetails() {
		return allergiesDetails;
	}
	
	public void setAllergiesDetails(String allergiesDetails) {
		this.allergiesDetails = allergiesDetails;
	}	
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}	
	
	public String getPrefecture() {
		return prefecture;
	}
	
	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}	
	
	public String getAddress1() {
		return address1;
	}
	
	public void setAddress1(String address1) {
		this.address1 = address1;
	}	
	
	public String getAddress2() {
		return address2;
	}
	
	public void setAddress2(String address2) {
		this.address2 = address2;
	}	
	
	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}	
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
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
	
	public String getErrorFamilyNameKana() {
		return errorFamilyNameKana;
	}
	
	public void setErrorFamilyNameKana(String errorFamilyNameKana) {
		this.errorFamilyNameKana=errorFamilyNameKana;
	}
	
	public String getErrorLastNameKana() {
		return errorLastNameKana;
	}
	
	public void setErrorLastNameKana(String errorLastNameKana) {
		this.errorLastNameKana=errorLastNameKana;
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
	
	public String getErrorAttendance() {
		return errorAttendance;
	}
	
	public void setErrorAttendance(String errorAttendance) {
		this.errorAttendance = errorAttendance;
	}	
	
	public String getErrorWhichGuest() {
		return errorWhichGuest;
	}
	
	public void setErrorWhichGuest(String errorWhichGuest) {
		this.errorWhichGuest = errorWhichGuest;
	}	
	
	public String getErrorGuestGender() {
		return errorGuestGender;
	}
	
	public void setErrorGuestGender(String errorGuestGender) {
		this.errorGuestGender = errorGuestGender;
	}
	
	public String getErrortRelation() {
		return errorRelation;
	}
	
	public void setErrorRelation(String errorRelation) {
		this.errorRelation = errorRelation;
	}	
	
	public String getErrorBirth() {
		return errorBirth;
	}
	
	public void setErrorBirth(String errorBirth) {
		this.errorBirth = errorBirth;
	}	
	
	public String getErrorAllergies() {
		return errorAllergies;
	}
	
	public void setErrorAllergies(String errorAllergies) {
		this.errorAllergies = errorAllergies;
	}	
	
	public String getErrorAllergiesDetails() {
		return errorAllergiesDetails;
	}
	
	public void setErrorAllergiesDetails(String errorAllergiesDetails) {
		this.errorAllergiesDetails = errorAllergiesDetails;
	}	
	
	public String getErrorPostalCode() {
		return errorPostalCode;
	}
	
	public void setErrorPostalCode(String errorPostalCode) {
		this.errorPostalCode = errorPostalCode;
	}	
	
	public String getErrorPrefecture() {
		return errorPrefecture;
	}
	
	public void setErrorPrefecture(String errorPrefecture) {
		this.errorPrefecture = errorPrefecture;
	}	
	
	public String getErrorAddress1() {
		return errorAddress1;
	}
	
	public void setErrorAddress1(String errorAddress1) {
		this.errorAddress1 = errorAddress1;
	}	
	
	public String getErrorAddress2() {
		return errorAddress2;
	}
	
	public void setErrorAddress2(String errorAddress2) {
		this.errorAddress2 = errorAddress2;
	}	
	
	public String getErrorTel() {
		return errorTel;
	}
	
	public void setErrorTel(String errorTel) {
		this.errorTel = errorTel;
	}	
	
	public String getErrorMail() {
		return errorMail;
	}
	
	public void setErrorMail(String errorMail) {
		this.errorMail=errorMail;
	}	

}
