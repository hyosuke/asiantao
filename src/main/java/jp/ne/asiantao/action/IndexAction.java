package jp.ne.asiantao.action;

import org.seasar.struts.annotation.Execute;

public class IndexAction {
	@Execute(validator = false)
	public String index() {
		
		return "/login/login.jsp";
	}
}
