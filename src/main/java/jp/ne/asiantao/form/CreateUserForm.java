package jp.ne.asiantao.form;

import java.util.ArrayList;

import org.seasar.struts.annotation.Required;

public class CreateUserForm {

	@Required
	public String userId;
	
	@Required
	public String pw;
	
	@Required
	public String userNm;
	
	
	public String mailAd;
	
	public ArrayList<String>  messageList = new ArrayList<String>();
	
}
