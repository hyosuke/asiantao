package jp.ne.asiantao.action;

import javax.annotation.Resource;

import jp.ne.asiantao.dto.UserDto;
import jp.ne.asiantao.entity.MUser;
import jp.ne.asiantao.form.LoginForm;
import jp.ne.asiantao.service.MUserService;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

public class LoginAction {
	
	
	//アクションフォームDI
	@Resource
	@ActionForm
	protected LoginForm loginform;
	
	//m_userサービスDI
	@Resource
	protected MUserService mUserService;
	
	//userセッションオブジェクトDI
	@Resource
	protected UserDto userDto;
	
	//初期表示
	@Execute(validator=false)
	public String index(){
	
		//ログイン画面へ遷移
		return "login.jsp";
	}
	
	
	//ログインボタン押下
	@Execute(validator=true, input="login.jsp")
	public String check(){
		
		//ログイン認証
		MUser user = mUserService.logincheck(loginform.userId, loginform.pw);
		
		//認証NGの場合
		if(user == null){

			loginform.messageList.add("ユーザIDとパスワードが一致しません");
			
			//ログイン画面に遷移
			return "login.jsp";
		
		//認証OKの場合
		}else{
			
			//ユーザ情報をセッションに格納
			userDto.setS_userId(user.userId);
			userDto.setS_userNm(user.userNm);
			userDto.setKanriFg(user.kanriFg);
			//トップ画面へリダイレクト
			return "/top?redirect=true";
		
		}
		
		
	}
}
