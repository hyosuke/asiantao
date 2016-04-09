package jp.ne.asiantao.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import jp.ne.asiantao.dto.ScheduleDetailDto;
import jp.ne.asiantao.dto.UserDto;
import jp.ne.asiantao.entity.ScheduleDetail;
import jp.ne.asiantao.entity.ScheduleKanri;
import jp.ne.asiantao.entity.WkScheduleDetail;
import jp.ne.asiantao.form.A007Form;
import jp.ne.asiantao.service.ScheduleDetailService;
import jp.ne.asiantao.service.ScheduleKanriService;
import jp.ne.asiantao.service.WkScheduleDetailService;
import jp.ne.asiantao.util.Auth;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

public class A007Action {

	@Resource
	@ActionForm
	protected A007Form a007Form;

	@Resource
	protected UserDto userDto;

	@Resource
	protected WkScheduleDetailService wkScheduleDetailService;

	@Resource
	protected ScheduleDetailService scheduleDetailService;

	@Resource
	protected ScheduleKanriService scheduleKanriService;

	public ArrayList<ScheduleDetailDto> scheduleDetailDtoList;

	public String kakuteiFg;

	@Auth
	@Execute(validator = false)
	public String index() {

		String selectMonth = a007Form.selectMonth;
		String firstFg = a007Form.firstFg;

		HashMap<String, String> parm = new HashMap<String, String>();

		parm.put("selectMonth", selectMonth);
		parm.put("firstFg", firstFg);
		// 確定済みかチェックする。
		List<ScheduleDetailDto> kakuteiQyList = scheduleDetailService
				.cntKakuteiQy(parm);

		if (kakuteiQyList.size()==0) {
			kakuteiFg = "0";
		} else {
			kakuteiFg = "1";
		}

		// 一覧情報作成

		scheduleDetailDtoList = new ArrayList<ScheduleDetailDto>();
		if (firstFg.equals("0")) {
			// 月末日取得
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR,
					Integer.parseInt(selectMonth.substring(0, 4)));
			cal.set(Calendar.MONTH,
					Integer.parseInt(selectMonth.substring(4, 6)) - 1);
			int lastDayOfMonth = cal.getActualMaximum(Calendar.DATE);

			for (int i = 16; i <= lastDayOfMonth; i++) {

				ScheduleDetailDto scheduleDetailDto = new ScheduleDetailDto();
				String day = String.valueOf(i);
				String dayStr = setDay(day, selectMonth);
				if (kakuteiFg == "1") {
					scheduleDetailDto.setDay(day);
					scheduleDetailDto.setDayStr(dayStr);
					scheduleDetailDto.setTorokuDt("-");
					for (ScheduleDetailDto kakuteiQy : kakuteiQyList) {

						if (day.equals(kakuteiQy.getDay())) {

							scheduleDetailDto.setTorokuQy(kakuteiQy.getCntQy());
						} else {
							scheduleDetailDto.setTorokuQy("0");
						}
					}
					

				} else {

					// 登録情報を取得する
					WkScheduleDetail wkScheduleDetail = wkScheduleDetailService
							.selectWkScheduleDetail(selectMonth, day);

					// 登録人数を設定する。
					long tourokuCnt = wkScheduleDetailService
							.countWkScheduleDetail(selectMonth, day);
					scheduleDetailDto.setDay(day);
					scheduleDetailDto.setDayStr(dayStr);
					if (wkScheduleDetail != null) {
						String tourokuDt = new SimpleDateFormat("yyyy/MM/dd")
								.format(wkScheduleDetail.torokuDt);
						scheduleDetailDto.setTorokuDt(tourokuDt);
						scheduleDetailDto.setTorokuFg("1");
						scheduleDetailDto.setTorokuQy(String
								.valueOf(tourokuCnt));
					} else {
						scheduleDetailDto.setTorokuDt("未登録");
						scheduleDetailDto.setTorokuFg("0");
						scheduleDetailDto.setTorokuQy("");
					}
				}
				scheduleDetailDtoList.add(scheduleDetailDto);
			}
		} else {

			for (int i = 1; i <= 15; i++) {

				ScheduleDetailDto scheduleDetailDto = new ScheduleDetailDto();

				String day = String.valueOf(i);
				String dayStr = setDay(day, selectMonth);
				
				if (kakuteiFg == "1") {
					scheduleDetailDto.setDay(day);
					scheduleDetailDto.setDayStr(dayStr);
					scheduleDetailDto.setTorokuDt("-");
					for (ScheduleDetailDto kakuteiQy : kakuteiQyList) {

						if (String.format("%1$02d", i).equals(kakuteiQy.getDay())) {

							scheduleDetailDto.setTorokuQy(kakuteiQy.getCntQy());
							break;
						} else {
							scheduleDetailDto.setTorokuQy("0");
						}
					}

				} else {
					// 登録情報を取得する
					WkScheduleDetail wkScheduleDetail = wkScheduleDetailService
							.selectWkScheduleDetail(selectMonth,
									String.format("%1$02d", i));
					// 登録人数を設定する。
					long tourokuCnt = wkScheduleDetailService
							.countWkScheduleDetail(selectMonth,
									String.format("%1$02d", i));

					scheduleDetailDto.setDay(String.format("%1$02d", i));
					scheduleDetailDto.setDayStr(dayStr);
					if (wkScheduleDetail != null) {
						String tourokuDt = new SimpleDateFormat("yyyy/MM/dd")
								.format(wkScheduleDetail.torokuDt);
						scheduleDetailDto.setTorokuDt(tourokuDt);
						scheduleDetailDto.setTorokuFg("1");
						scheduleDetailDto.setTorokuQy(String
								.valueOf(tourokuCnt));

					} else {
						scheduleDetailDto.setTorokuDt("未登録");
						scheduleDetailDto.setTorokuFg("0");
						scheduleDetailDto.setTorokuQy("");
					}

				}

				scheduleDetailDtoList.add(scheduleDetailDto);
			}
		}

		return "a007.jsp";
	}

	@Execute(validator = false)
	public String regist() {

		List<WkScheduleDetail> wkScheduleDetailList = wkScheduleDetailService
				.selectHalfData(a007Form.selectMonth, a007Form.firstFg);

		String userId = null;
		long cnt = 0;

		// スケジュール詳細テーブルの登録
		for (WkScheduleDetail wkScheduleDetail : wkScheduleDetailList) {

			ScheduleDetail scheduleDetail = new ScheduleDetail();
			// 登録情報設定
			scheduleDetail.userId = wkScheduleDetail.userId;
			scheduleDetail.selectMonth = wkScheduleDetail.selectMonth;
			scheduleDetail.firstFg = wkScheduleDetail.firstFg;
			scheduleDetail.day = wkScheduleDetail.day;
			scheduleDetail.kakuteiScheduleDv = wkScheduleDetail.scheduleDv;
			scheduleDetail.kakuteiPozishonDv = wkScheduleDetail.pozishonDv;
			scheduleDetail.kakuteiBikou = wkScheduleDetail.bikou;

			if (userId == null || !userId.equals(wkScheduleDetail.userId)) {
				// 初回ループ或は1ループ前のユーザIDとループ中のユーザIDが異なる場合
				// ユーザーがスケジュール申請者かチェックする。
				cnt = scheduleDetailService.countTourokuUmu(
						scheduleDetail.selectMonth, scheduleDetail.firstFg,
						scheduleDetail.userId);

			}

			if (!(cnt == 0)) {
				// スケジュール申請者の場合、更新
				HashMap<String, String> parm = new HashMap<>();

				parm.put("kakuteiScheduleDv", wkScheduleDetail.scheduleDv);
				parm.put("kakuteiBikou", wkScheduleDetail.bikou);
				parm.put("kakuteiPozishondv", wkScheduleDetail.pozishonDv);
				parm.put("userId", wkScheduleDetail.userId);
				parm.put("selectMonth", wkScheduleDetail.selectMonth);
				parm.put("day", wkScheduleDetail.day);

				scheduleDetailService.update(parm);
			} else {
				// スケジュール未申請者の場合、登録
				scheduleDetailService.regist(scheduleDetail);
			}

			userId = wkScheduleDetail.userId;
		}

		// スケジュール管理テーブルの登録
		ScheduleKanri scheduleKanri = new ScheduleKanri();

		scheduleKanri.selectMonth = a007Form.selectMonth;
		scheduleKanri.firstFg = a007Form.firstFg;
		scheduleKanri.kakuteiDt = new Date();

		scheduleKanriService.insert(scheduleKanri);

		// スケジュール詳細ワークTの削除
		HashMap<String, String> parm = new HashMap<>();

		parm.put("selectMonth", a007Form.selectMonth);
		parm.put("firstFg", a007Form.firstFg);

		wkScheduleDetailService.deleteWkScheduleDetail2(parm);

		return "/a005?redirect=true";
	}

	@Execute(validator = false)
	public String reset() {

		// リクエストパラメータの取得
		String selectMonth = a007Form.selectMonth;
		String firstFg = a007Form.firstFg;

		// スケジュール管理テーブルの削除
		ScheduleKanri scheduleKanri = new ScheduleKanri();
		scheduleKanri.selectMonth = selectMonth;
		scheduleKanri.firstFg = firstFg;

		scheduleKanriService.delete(scheduleKanri);

		// 確定情報からワークテーブルの復元
		List<ScheduleDetail> fukugenList = scheduleDetailService.selectFukugen(
				selectMonth, firstFg);
		ArrayList<WkScheduleDetail> wkScheduleDetailList = new ArrayList<WkScheduleDetail>();
		for (ScheduleDetail fukugen : fukugenList) {

			WkScheduleDetail wkScheduleDetail = new WkScheduleDetail();

			wkScheduleDetail.userId = fukugen.userId;
			wkScheduleDetail.selectMonth = selectMonth;
			wkScheduleDetail.firstFg = firstFg;
			wkScheduleDetail.day = fukugen.day;
			wkScheduleDetail.scheduleDv = fukugen.kakuteiScheduleDv;
			wkScheduleDetail.pozishonDv = fukugen.kakuteiPozishonDv;
			wkScheduleDetail.bikou = fukugen.kakuteiBikou;
			wkScheduleDetail.torokuDt = new Date();

			wkScheduleDetailList.add(wkScheduleDetail);

		}

		wkScheduleDetailService.insertFukugen(wkScheduleDetailList);

		// 追加登録したユーザの確定スケジュール情報の削除
		HashMap<String, String> parm1 = new HashMap<String, String>();

		parm1.put("selectMonth", selectMonth);
		parm1.put("firstFg", firstFg);

		scheduleDetailService.deleteFukugen(parm1);

		// 申請登録したユーザの確定スケジュール情報の削除
		HashMap<String, String> parm2 = new HashMap<String, String>();

		parm2.put("selectMonth", selectMonth);
		parm2.put("firstFg", firstFg);
		parm2.put("kakuteiScheduleDv", null);
		parm2.put("kakuteiPozishondv", null);
		parm2.put("kakuteiBikou", null);

		scheduleDetailService.updateFukugen(parm2);

		return "/a005?redirect=true";
	}

	// 日付取得
	private String setDay(String day, String selectMonth) {

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, Integer.parseInt(selectMonth.substring(0, 4)));
		cal.set(Calendar.MONTH,
				Integer.parseInt(selectMonth.substring(4, 6)) - 1);
		cal.set(Calendar.DATE, Integer.parseInt(day));
		String youbi = swichWeek(cal.get(Calendar.DAY_OF_WEEK));

		return String.valueOf(day) + "日" + "(" + youbi.substring(0, 1) + ")";

	}

	// 曜日設定
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
