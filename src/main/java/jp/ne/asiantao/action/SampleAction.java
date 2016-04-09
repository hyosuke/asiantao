package jp.ne.asiantao.action;

import org.seasar.struts.annotation.Execute;

public class SampleAction {
	@Execute(validator = false)
	public String index() {
		
		return "sample.jsp";
	}
}
