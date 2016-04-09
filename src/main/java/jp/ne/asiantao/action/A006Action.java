package jp.ne.asiantao.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import jp.ne.asiantao.dto.MuserDto;
import jp.ne.asiantao.dto.UserDto;
import jp.ne.asiantao.form.A006Form;
import jp.ne.asiantao.service.ScheduleService;
import jp.ne.asiantao.util.Auth;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;


public class A006Action {
	
	@Resource
	@ActionForm
	protected A006Form a006Form;
	
	@Resource
	protected UserDto userDto;
	
	@Resource
	ScheduleService scheduleService;
	
	public ArrayList<String> miteishutuList;

	@Auth
	@Execute(validator=false)
	public String index(){
	
		miteishutuList = new ArrayList<String>();
		
		HashMap<String,String> parm = new HashMap<String,String>();
		
		parm.put("selectMonth", a006Form.selectMonth);
		parm.put("firstFg", a006Form.firstFg);
		
		List<MuserDto> userList = scheduleService.SelectMiteishutushaList(parm);
		
		if(userList.size() ==0 ){
			
				miteishutuList.add("未提出の方はいません。");
			
		}else{
			
			//シフト未申請者の一覧を作成
			for(MuserDto userdto:userList){
				
				miteishutuList.add(userdto.getUserNm());
			}
		}	
		return "a006.jsp";
	}

}
