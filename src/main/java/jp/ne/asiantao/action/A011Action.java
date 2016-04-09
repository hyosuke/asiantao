package jp.ne.asiantao.action;


import java.util.Calendar;
import java.util.Date;
import javax.annotation.Resource;
import jp.ne.asiantao.dto.UserDto;
import jp.ne.asiantao.entity.Oshirase;
import jp.ne.asiantao.form.A011Form;
import jp.ne.asiantao.service.OshiraseService;
import jp.ne.asiantao.util.Auth;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

public class A011Action {

	
	@Resource
	@ActionForm
	protected A011Form a011Form;
	
	@Resource
	protected UserDto userDto;
	
	@Resource
	protected OshiraseService oshiraseService;

	@Auth
	@Execute(validator = false)
	public String index(){
		
		return "a011.jsp";
		
	}
	
	@Auth
	@Execute(validator=false)
	public String regist(){
		
		Oshirase oshirase = new Oshirase();
		
		Calendar calendar = Calendar.getInstance();
		
		int year = calendar.get(Calendar.YEAR);
	    int month = calendar.get(Calendar.MONTH) + 1;

		oshirase.ohirase = a011Form.oshirase;
		oshirase.tourokubi = new Date();
		oshirase.tourokuNengetu = String.valueOf(year) + String.format("%1$02d", month);
		
		oshiraseService.insert(oshirase);
		
		return "/top?redirect=true";
	}
}
