package jp.ne.asiantao.form;

import java.util.ArrayList;

import org.seasar.struts.annotation.Required;

public class LoginForm {
	
	@Required
	public String userId;
	
	@Required
	public String pw;
	
	public ArrayList<String>  messageList = new ArrayList<String>();

}
