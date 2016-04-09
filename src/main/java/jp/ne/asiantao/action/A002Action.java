package jp.ne.asiantao.action;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import jp.ne.asiantao.dto.DvDto;
import jp.ne.asiantao.dto.ScheduleDetailDto;
import jp.ne.asiantao.dto.UserDto;
import jp.ne.asiantao.entity.SDv;
import jp.ne.asiantao.entity.Schedule;
import jp.ne.asiantao.entity.ScheduleDetail;
import jp.ne.asiantao.entity.ScheduleKanri;
import jp.ne.asiantao.entity.WkScheduleDetail;
import jp.ne.asiantao.form.A002Form;
import jp.ne.asiantao.service.SDvService;
import jp.ne.asiantao.service.ScheduleDetailService;
import jp.ne.asiantao.service.ScheduleKanriService;
import jp.ne.asiantao.service.ScheduleService;
import jp.ne.asiantao.service.WkScheduleDetailService;
import jp.ne.asiantao.util.Auth;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

public class A002Action {

	@Resource
	@ActionForm
	protected A002Form a002Form;

	@Resource
	protected ScheduleDetailService scheduleDetailService;
	
	@Resource
	protected WkScheduleDetailService wkScheduleDetailService;
	
	@Resource ScheduleKanriService scheduleKanriService;

	@Resource
	protected SDvService sDvService;

	@Resource
	protected ScheduleService scheduleService;

	@Resource
	protected UserDto userDto;

	public ArrayList<DvDto> dvDtoList;
	
	public String mode;

	// 初期表示
	@Auth
	@Execute(validator = false)
	public String index() {

		// パラメータから選択情報を取得
		String selectMonth = a002Form.selectMonth;
		String firstFg = a002Form.firstFg;
		String userId = userDto.getS_userId();

		// スケジュール区分取得
		List<SDv> dvList = sDvService.selectDvList("SCHEDULE_DV");

		dvDtoList = new ArrayList<DvDto>();

		for (SDv dv : dvList) {

			DvDto dvDto = new DvDto();
			dvDto.setDvValue(dv.dvValue);
			dvDto.setDvName(dv.dvName);

			dvDtoList.add(dvDto);

		}
		HashMap<String, String> parm = new HashMap<String, String>();
		parm.put("selectMonth", selectMonth);
		parm.put("firstFg", firstFg);	
		//管理者登録、確定済みかどうかチェックする。
		WkScheduleDetail temp =wkScheduleDetailService.selectWkScheduleDetail2(parm);
		
		ScheduleKanri temp2 =scheduleKanriService.selectKakuteiDt(selectMonth, firstFg);
		
		if(temp!=null || temp2 != null ){
			mode = "2";
		}else{
			mode = "1";
		}
		
		// 半月分のスケジュールを取得する。
		List<ScheduleDetail> scheduleDetailList = scheduleDetailService
				.selectScheduleDetailList(userId, selectMonth, firstFg);

		// スケジュール情報作成
		if (scheduleDetailList.size() != 0) {// スケジュール登録済みの場合

			for (ScheduleDetail scheduleDetail : scheduleDetailList) {

				// 申請者数取得
				String shinseiQy = String.valueOf(scheduleDetailService
						.countShinseishaQy(selectMonth, scheduleDetail.day));

				// 曜日を取得
				Calendar cal = Calendar.getInstance();
				cal.set(Calendar.YEAR,
						Integer.parseInt(selectMonth.substring(0, 4)));
				cal.set(Calendar.MONTH,
						Integer.parseInt(selectMonth.substring(4, 6)) - 1);
				cal.set(Calendar.DATE, Integer.parseInt(scheduleDetail.day));
				String youbi = swichWeek(cal.get(Calendar.DAY_OF_WEEK));

				// Dtoにスケジュール情報を設定する。
				ScheduleDetailDto scheduleDetailDto = new ScheduleDetailDto();
				scheduleDetailDto.setDay(scheduleDetail.day);
				scheduleDetailDto.setDayStr(scheduleDetail.day.replaceFirst(
						"^0+", "") + "日" + "(" + youbi.substring(0, 1) + ")");
				scheduleDetailDto.setScheduleDv(scheduleDetail.scheduleDv);
				scheduleDetailDto.setShinseiQy(shinseiQy);

				// フォームのスケジュール情報リストに詰める
				a002Form.scheduleDetailDtoList.add(scheduleDetailDto);

			}

		} else {// スケジュール未登録の場合

			if (firstFg.equals("1")) {

				for (int i = 1; i <= 15; i++) {

					// 申請者数取得
					String shinseiQy = String.valueOf(scheduleDetailService
							.countShinseishaQy(selectMonth, String.valueOf(i)));

					// 曜日を取得
					Calendar cal = Calendar.getInstance();
					cal.set(Calendar.YEAR,
							Integer.parseInt(selectMonth.substring(0, 4)));
					cal.set(Calendar.MONTH,
							Integer.parseInt(selectMonth.substring(4, 6)) - 1);
					cal.set(Calendar.DATE, i);
					String youbi = swichWeek(cal.get(Calendar.DAY_OF_WEEK));

					// Dtoにスケジュール情報を設定する。
					ScheduleDetailDto scheduleDetailDto = new ScheduleDetailDto();
					scheduleDetailDto.setDay(String.format("%1$02d", i));
					scheduleDetailDto.setDayStr(String.valueOf(i) + "日" + "("
							+ youbi.substring(0, 1) + ")");
					scheduleDetailDto.setScheduleDv("00");
					scheduleDetailDto.setShinseiQy(shinseiQy);

					// フォームのスケジュール情報リストに詰める
					a002Form.scheduleDetailDtoList.add(scheduleDetailDto);
				}

			} else {
				// 月末日を取得する
				Calendar cal = Calendar.getInstance();
				cal.set(Calendar.YEAR,
						Integer.parseInt(selectMonth.substring(0, 4)));
				cal.set(Calendar.MONTH,
						Integer.parseInt(selectMonth.substring(4, 6)) - 1);
				int lastDayOfMonth = cal.getActualMaximum(Calendar.DATE);

				for (int i = 16; i <= lastDayOfMonth; i++) {

					// 申請者数取得
					String shinseiQy = String.valueOf(scheduleDetailService
							.countShinseishaQy(selectMonth, String.valueOf(i)));

					// 曜日を取得
					cal.set(Calendar.DATE, i);
					String youbi = swichWeek(cal.get(Calendar.DAY_OF_WEEK));

					// Dtoにスケジュール情報を設定する。
					ScheduleDetailDto scheduleDetailDto = new ScheduleDetailDto();
					scheduleDetailDto.setDay(String.valueOf(i));
					scheduleDetailDto.setDayStr(String.valueOf(i) + "日" + "("
							+ youbi.substring(0, 1) + ")");
					scheduleDetailDto.setScheduleDv("00");
					scheduleDetailDto.setShinseiQy(shinseiQy);

					// フォームのスケジュール情報リストに詰める
					a002Form.scheduleDetailDtoList.add(scheduleDetailDto);

				}

			}
		}

		return "a002.jsp";
	}

	// 登録ボタン押下
	@Execute(validator = false)
	public String regist() throws Exception {

		Schedule sche1 = scheduleService.findById(userDto.getS_userId(),
				a002Form.selectMonth, a002Form.firstFg);
		// スケジュール情報未登録の場合、登録する。
		if (sche1 == null) {

			Calendar calendar = Calendar.getInstance();
			String torokuDt = String.valueOf(calendar.get(Calendar.YEAR))
					+ "/"
					+ String.valueOf(calendar.get(Calendar.MONTH) + 1 + "/"
							+ String.valueOf(calendar.get(Calendar.DATE)));

			Schedule schedule = new Schedule();
			schedule.userId = userDto.getS_userId();
			schedule.torokuDt = DateFormat.getDateInstance().parse(torokuDt);
			schedule.selectMonth = a002Form.selectMonth;
			schedule.firstFg = a002Form.firstFg;
			scheduleService.insert(schedule);
		}

		// スケジュール詳細情報削除処理

		List<ScheduleDetail> scheduleDetaildeleteList = scheduleDetailService
				.selectScheduleDetailList(userDto.getS_userId(),
						a002Form.selectMonth, a002Form.firstFg);

		if (scheduleDetaildeleteList.size() != 0) {
			scheduleDetailService.delete(scheduleDetaildeleteList);
		}

		// スケジュール詳細情報登録処理
		List<ScheduleDetail> scheduleDetailList = new ArrayList<ScheduleDetail>();
		for (ScheduleDetailDto scheduleDetailDto : a002Form.scheduleDetailDtoList) {

			ScheduleDetail insertScheduleDetail = new ScheduleDetail();

			insertScheduleDetail.userId = userDto.getS_userId();
			insertScheduleDetail.selectMonth = a002Form.selectMonth;
			insertScheduleDetail.firstFg = a002Form.firstFg;
			insertScheduleDetail.scheduleDv = scheduleDetailDto.getScheduleDv();
			insertScheduleDetail.day = scheduleDetailDto.getDay();

			scheduleDetailList.add(insertScheduleDetail);
		}

		scheduleDetailService.regist(scheduleDetailList);

		return "/a001?redirect=true";
	}

	private String swichWeek(int weekValue) {
		switch (weekValue) {
		case Calendar.SUNDAY:
			return "日曜日";
		case Calendar.MONDAY:
			return "月曜日";
		case Calendar.TUESDAY:
			return "火曜日";
		case Calendar.WEDNESDAY:
			return "水曜日";
		case Calendar.THURSDAY:
			return "木曜日";
		case Calendar.FRIDAY:
			return "金曜日";
		case Calendar.SATURDAY:
			return "土曜日";
		}
		return null;
	}
}
