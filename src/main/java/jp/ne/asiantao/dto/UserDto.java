package jp.ne.asiantao.dto;

import java.io.Serializable;
import java.util.ArrayList;

import org.seasar.framework.container.annotation.tiger.Component;
import org.seasar.framework.container.annotation.tiger.InstanceType;

@Component(instance = InstanceType.SESSION)
public class UserDto implements Serializable{

	/**
	 * ユーザ情報セッション格納用クラス
	 */
	private static final long serialVersionUID = 1L;
	
	private String s_userId;
	
	public String getS_userId() {
		return s_userId;
	}

	public void setS_userId(String s_userId) {
		this.s_userId = s_userId;
	}

	public String getS_userNm() {
		return s_userNm;
	}

	public void setS_userNm(String s_userNm) {
		this.s_userNm = s_userNm;
	}

	public ArrayList<String> getS_messageList() {
		return s_messageList;
	}

	public void setS_messageList(ArrayList<String> s_messageList) {
		this.s_messageList = s_messageList;
	}

	private String s_userNm;
	
	private String kanriFg;
	
	
	private ArrayList<String>  s_messageList = new ArrayList<String>();


	public Boolean isLogin(){
		
		if(getS_userId()==null){
			
			return false;
		}else{
			return true;
		}
		
		
	}

	public String getKanriFg() {
		return kanriFg;
	}

	public void setKanriFg(String kanriFg) {
		this.kanriFg = kanriFg;
	}
	
}
