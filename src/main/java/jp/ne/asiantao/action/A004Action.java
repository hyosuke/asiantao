package jp.ne.asiantao.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import jp.ne.asiantao.dto.ScheduleDetailDto;
import jp.ne.asiantao.dto.UserDto;
import jp.ne.asiantao.form.A004Form;
import jp.ne.asiantao.service.ScheduleDetailService;
import jp.ne.asiantao.util.Auth;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

public class A004Action {
	
	@Resource
	@ActionForm
	protected A004Form a004Form;
	
	@Resource
	protected ScheduleDetailService scheduleDetailService;
	
	@Resource
	protected UserDto userDto;
	
	public ArrayList<ScheduleDetailDto> scheduleDetailDtoList;
	
	public ArrayList<String> dayList;

	//初期表示
	@Auth
	@Execute(validator=false)
	public String index(){
		
		//リクエストパラメータ取得
		String selectMonth = a004Form.selectMonth;
		String firstFg = a004Form.firstFg;
	
		//一覧情報作成
		scheduleDetailDtoList = new ArrayList<ScheduleDetailDto>();
		dayList = new ArrayList<String>();

		if(firstFg.equals("0")){//月後半の場合
			//月末日取得
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, Integer.parseInt(selectMonth.substring(0, 4)));
			cal.set(Calendar.MONTH, Integer.parseInt(selectMonth.substring(4, 6))-1);
			int lastDayOfMonth = cal.getActualMaximum(Calendar.DATE);
			
			for(int i = 16; i <= lastDayOfMonth ; i++){
				
				dayList.add(String.valueOf(i));
				
				HashMap<String,String> parm = new HashMap<String,String>();
				
				parm.put("selectMonth", selectMonth);
				parm.put("firstFg", firstFg);
				parm.put("day", String.valueOf(i));
				
				List<ScheduleDetailDto>  scheduleDetailList =scheduleDetailService.selectShiftList(parm);
				
				for(ScheduleDetailDto scheduleDetail :scheduleDetailList){
						
						ScheduleDetailDto scheduleDetailDto = new ScheduleDetailDto();
						scheduleDetailDto.setDay(scheduleDetail.getDay().replaceFirst("^0+", ""));
						scheduleDetailDto.setUserNm(scheduleDetail.getUserNm());
						scheduleDetailDto.setKakuteiScheduleDvNm(scheduleDetail.getScheduleDvNm());
						scheduleDetailDto.setKakuteiPozishonDvNm(scheduleDetail.getPozishonDvNm());
						scheduleDetailDto.setKakuteiBikou(scheduleDetail.getBikou());
						
						scheduleDetailDtoList.add(scheduleDetailDto);
					
						
				}	
				
			}
			
		}else{//月前半の場合
			
			for(int i = 1 ; i <= 15 ; i++){
				
				dayList.add(String.valueOf(i));
				
				HashMap<String,String> parm = new HashMap<String,String>();
				
				parm.put("selectMonth", selectMonth);
				parm.put("firstFg", firstFg);
				parm.put("day", String.format("%1$02d",i));
				
				List<ScheduleDetailDto> scheduleDetailList = new ArrayList<ScheduleDetailDto> ();
				
				scheduleDetailList =scheduleDetailService.selectShiftList(parm);
				
				for(ScheduleDetailDto scheduleDetail :scheduleDetailList){
						
						ScheduleDetailDto scheduleDetailDto = new ScheduleDetailDto();
						scheduleDetailDto.setDay(scheduleDetail.getDay().replaceFirst("^0+", ""));
						scheduleDetailDto.setUserNm(scheduleDetail.getUserNm());
						scheduleDetailDto.setKakuteiScheduleDvNm(scheduleDetail.getScheduleDvNm());
						scheduleDetailDto.setKakuteiPozishonDvNm(scheduleDetail.getPozishonDvNm());
						scheduleDetailDto.setKakuteiBikou(scheduleDetail.getBikou());
						
						scheduleDetailDtoList.add(scheduleDetailDto);
					
				}	
			}
			
		}	
		
		return "a004.jsp";
	}
}
