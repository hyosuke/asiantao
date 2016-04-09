package jp.ne.asiantao.action;



import java.util.Calendar;

import javax.annotation.Resource;

import jp.ne.asiantao.dto.UserDto;
import jp.ne.asiantao.form.TopForm;
import jp.ne.asiantao.service.OshiraseService;
import jp.ne.asiantao.util.Auth;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

public class TopAction {
	
	
	//アクションフォーム
	@Resource
	@ActionForm
	protected TopForm topform;
	
	//userセッション情報
	@Resource
	protected UserDto userDto;
	
	@Resource
	protected OshiraseService oshiraseService;
	
	@Auth
	@Execute(validator= false)
	public String index(){
		
		Calendar calendar = Calendar.getInstance();
		
		 int year = calendar.get(Calendar.YEAR);
		 int month = calendar.get(Calendar.MONTH) + 1;
		 
		 String tourokuNengetu = String.valueOf(year) + String.format("%02d", month); 
		
		 topform.oshiraseList = oshiraseService.selectOshirase(tourokuNengetu);
		 
		return "top.jsp";
	}

}
