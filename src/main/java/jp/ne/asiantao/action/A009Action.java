package jp.ne.asiantao.action;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;

import jp.ne.asiantao.dto.ScheduleDetailDto;
import jp.ne.asiantao.dto.UserDto;
import jp.ne.asiantao.entity.ScheduleKanri;
import jp.ne.asiantao.form.A009Form;
import jp.ne.asiantao.service.ScheduleDetailService;
import jp.ne.asiantao.service.ScheduleKanriService;
import jp.ne.asiantao.service.WkScheduleDetailService;
import jp.ne.asiantao.util.Auth;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

public class A009Action {

	@Resource
	@ActionForm
	protected A009Form a009Form;
	
	@Resource
	protected UserDto userDto;

	@Resource
	protected ScheduleKanriService scheduleKanriService;
	
	@Resource
	protected ScheduleDetailService scheduleDetailService;
	
	@Resource
	protected WkScheduleDetailService wkscheduleDetailService;
	
	public boolean mode;
	
	
	@Auth
	@Execute(validator = false)
	public String index() {
		
		String selectMonth = a009Form.selectMonth;
		String firstFg = a009Form.firstFg;
		String day = a009Form.day;
		
		ScheduleKanri scheduleKanri = scheduleKanriService.selectKakuteiDt(selectMonth, firstFg);
		
		HashMap<String,String> parm = new HashMap<String,String>();
		
		parm.put("selectMonth", selectMonth);
		parm.put("firstFg", firstFg);
		parm.put("day",  String.format("%1$02d", Integer.parseInt(day)));
		
		a009Form.scheduleDetailDtoList = new ArrayList<ScheduleDetailDto>();
		
		if(scheduleKanri==null){
			a009Form.scheduleDetailDtoList = (ArrayList<ScheduleDetailDto>)wkscheduleDetailService.selectShiftList(parm);
			mode = true;
			
		}else{
			a009Form.scheduleDetailDtoList =(ArrayList<ScheduleDetailDto>)scheduleDetailService.selectShiftList(parm);
			mode = false;
		}
		
		return "a009.jsp";
	}

	@Auth
	@Execute(validator=false)
	public String reset( ){
		
		String selectMonth = a009Form.selectMonth;
		String firstFg = a009Form.firstFg;
		String day = a009Form.day;
		
		HashMap<String, String> parm = new HashMap<String,String>();
		
		parm.put("selectMonth", selectMonth);
		parm.put("firstFg", firstFg);
		parm.put("day", day);
		
		wkscheduleDetailService.deleteWkScheduleDetail(parm);
		
		return "/a007?selectMonth="+a009Form.selectMonth+"&firstFg="+a009Form.firstFg+"&redirect=true";
		
	}
	
	@Auth
	@Execute(validator=false)
	public String return1( ){
	
		return "/a007?selectMonth="+a009Form.selectMonth+"&firstFg="+a009Form.firstFg+"&redirect=true";
	}
	
}
