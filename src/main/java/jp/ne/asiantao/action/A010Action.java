package jp.ne.asiantao.action;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import jp.ne.asiantao.dto.ScheduleDetailDto;
import jp.ne.asiantao.dto.UserDto;
import jp.ne.asiantao.form.A010Form;
import jp.ne.asiantao.service.ScheduleDetailService;
import jp.ne.asiantao.util.Auth;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

public class A010Action {
	@Resource
	@ActionForm
	protected A010Form a010Form;

	@Resource
	protected UserDto userDto;

	@Resource
	protected ScheduleDetailService scheduleDetailService;

	public List<ScheduleDetailDto> scheduleDetailDtoList;

	@Auth
	@Execute(validator = false)
	public String index() {


		
		HashMap<String,String> parm = new HashMap<String,String>();
		
		parm.put("selectMonth",a010Form.selectMonth);
		parm.put("firstFg",a010Form.firstFg);
		parm.put("day",a010Form.day);
		
		
		scheduleDetailDtoList = scheduleDetailService.selectShiftList2(
				parm);

		return "a010.jsp";
	}

	@Auth
	@Execute(validator = false)
	public String return1() {

		return "/a002?selectMonth=" + a010Form.selectMonth + "&firstFg="
				+ a010Form.firstFg + "&redirect=true";
	}

}
