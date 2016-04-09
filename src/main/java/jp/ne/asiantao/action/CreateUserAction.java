package jp.ne.asiantao.action;

import java.util.ArrayList;

import javax.annotation.Resource;

import jp.ne.asiantao.dto.UserDto;
import jp.ne.asiantao.entity.MUser;
import jp.ne.asiantao.form.CreateUserForm;
import jp.ne.asiantao.service.MUserService;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

public class CreateUserAction {
	
	@Resource
	protected UserDto userDto;
	
	@Resource
	@ActionForm
	protected CreateUserForm createUserForm;
	
	@Resource
	protected MUserService mUserService;
	
	//@Resource
	//protected MUser mUser;
	
	//初期表示
	@Execute(validator=false)
	public String index(){
		
		//新規登録画面(入力モード)へ遷移
		return "createuser.jsp";
	}
	
	//登録ボタン押下
	@Execute(validator=true,input="createuser.jsp")
	public String regist(){
		
		//重複チェック
		MUser mUsercheck = mUserService.findById(createUserForm.userId);
		
		if(mUsercheck==null){//未登録の場合
			
			MUser mUser = new MUser();
			//エンティティに入力情報を設定
			mUser.userId = createUserForm.userId;
			mUser.userNm = createUserForm.userNm;
			mUser.pw = createUserForm.pw;
			mUser.mailAd= createUserForm.mailAd;
			mUser.kanriFg = "0";
			//DB登録
			int registCnt = mUserService.regist(mUser);
			
			if(registCnt==0){
				
				createUserForm.messageList.add("登録処理に失敗しました");
				return "createuser.jsp";
			}
			//登録完了メッセージ作成
			ArrayList<String>  s_messageList = new ArrayList<String>();
			s_messageList.add("登録完了しました");
			
			//セッション情報設定 ユーザID,ユーザ名,メッセージ
			userDto.setS_userId(createUserForm.userId);
			userDto.setS_userNm(createUserForm.userNm);
			userDto.setS_messageList(s_messageList);
			
			//ログイン画面へ遷移
			return "/login?redirect=true";
		
		}else{//登録済の場合
			
			createUserForm.messageList.add("入力したユーザIDは既に登録済です");
			
			return "createuser.jsp";
			
		}
	}

}
