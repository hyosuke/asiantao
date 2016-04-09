package jp.ne.asiantao.form;

import java.util.ArrayList;
import java.util.List;

import jp.ne.asiantao.entity.Oshirase;

public class TopForm {

	//ユーザID
	public String userId;
	//パスワード
	public String pw;
	//メッセージ
	public ArrayList<String>  messageList = new ArrayList<String>();
	
	public List<Oshirase> oshiraseList;
}
