package jp.ne.asiantao.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

import javax.annotation.Resource;

import jp.ne.asiantao.dto.ScheduleDto;
import jp.ne.asiantao.dto.UserDto;
import jp.ne.asiantao.entity.Schedule;
import jp.ne.asiantao.entity.ScheduleKanri;
import jp.ne.asiantao.entity.WkScheduleDetail;
import jp.ne.asiantao.form.A001Form;
import jp.ne.asiantao.service.ScheduleKanriService;
import jp.ne.asiantao.service.ScheduleService;
import jp.ne.asiantao.service.WkScheduleDetailService;
import jp.ne.asiantao.util.Auth;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

public class A001Action {

	@Resource
	@ActionForm
	protected A001Form a001Form;

	@Resource
	protected UserDto userDto;

	@Resource
	protected ScheduleService scheduleService;

	@Resource
	protected ScheduleKanriService scheduleKanriService;
	
	@Resource
	protected WkScheduleDetailService wkScheduleDetailService;


	// 初期表示
		@Auth
		@Execute(validator = false)
		public String index() {
			String str;
			String firstFg;
			String selectMonth;
			String tourokuDt;
			String kakutei;
			String selectStr;

			// カレンダークラスのインスタンス化
			Calendar calendar = Calendar.getInstance();
			int year = calendar.get(Calendar.YEAR);
			int month = calendar.get(Calendar.MONTH) + 1;

			// 一覧情報作成
			for (int i = 0; i <= 5; i++) {

				if (i % 2 == 1) {
					str = "後半";
					firstFg = "0";
					selectStr = String.valueOf(year)
							+ String.format("%1$02d", month) + firstFg;
				} else {
					if (i != 0) {
						month = month + 1;
					}
					str = "前半";
					firstFg = "1";
					selectStr = String.valueOf(year)
							+ String.format("%1$02d", month) + firstFg;
				}

				selectMonth = String.valueOf(year) + String.format("%1$02d", month);

				Schedule schedule = scheduleService.findById(userDto.getS_userId(),
						selectMonth, firstFg);

				ScheduleKanri scheduleKanri = scheduleKanriService.selectKakuteiDt(
						selectMonth, firstFg);
				
				HashMap<String, String> parm = new HashMap<String, String>();
			
				parm.put("selectMonth", selectMonth);
				parm.put("firstFg", firstFg);
				
				
				WkScheduleDetail wkScheduleDetail = wkScheduleDetailService.selectWkScheduleDetail2(parm);
				//スケジュールが未登録の場合
				if (schedule == null) {
					tourokuDt = "未登録";

				} else {
					tourokuDt = new SimpleDateFormat("yyyy/MM/dd")
							.format(schedule.torokuDt);

				}
				
				if (scheduleKanri == null && wkScheduleDetail == null) {
					kakutei = "未確定";
				} else if(scheduleKanri == null && wkScheduleDetail != null){
					
					kakutei = "作成中";
				}else{
					kakutei = new SimpleDateFormat("yyyy/MM/dd")
							.format(scheduleKanri.kakuteiDt);
				}

				selectMonth = year + "年" + month + "月" + str;

				// スケジュールDTOのインスタンス化
				ScheduleDto scheduledto = new ScheduleDto();
				scheduledto.setSelectMonth(selectMonth);
				scheduledto.setTourokuDt(tourokuDt);
				scheduledto.setKakutei(kakutei);
				scheduledto.setSelectStr(selectStr);
				a001Form.scheduleDtoList.add(scheduledto);
			}

			return "a001.jsp";
		}

	}
