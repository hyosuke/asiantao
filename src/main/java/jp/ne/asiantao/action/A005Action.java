package jp.ne.asiantao.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

import javax.annotation.Resource;

import jp.ne.asiantao.dto.ScheduleDto;
import jp.ne.asiantao.dto.UserDto;
import jp.ne.asiantao.entity.ScheduleKanri;
import jp.ne.asiantao.entity.WkScheduleDetail;
import jp.ne.asiantao.form.A005Form;
import jp.ne.asiantao.service.ScheduleKanriService;
import jp.ne.asiantao.service.WkScheduleDetailService;
import jp.ne.asiantao.util.Auth;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

public class A005Action {

	@Resource
	@ActionForm
	protected A005Form a005Form;

	@Resource
	protected UserDto userDto;

	@Resource
	protected WkScheduleDetailService wkScheduleDetailService;

	@Resource
	protected ScheduleKanriService scheduleKanriService;

	// 初期表示
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

		// 処理年月取得
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

			HashMap<String, String> parm = new HashMap<>();
			parm.put("selectMonth", selectMonth);
			parm.put("firstFg", firstFg);
			WkScheduleDetail wkScheduleDetail = wkScheduleDetailService
					.selectWkScheduleDetail2(parm);

			ScheduleKanri scheduleKanri = scheduleKanriService.selectKakuteiDt(
					selectMonth, firstFg);
			if (wkScheduleDetail == null && scheduleKanri == null) {
				tourokuDt = "未登録";
				kakutei = "未確定";
				selectStr = selectStr + "0";

			} else if (wkScheduleDetail != null && scheduleKanri == null) {
				tourokuDt = new SimpleDateFormat("yyyy/MM/dd")
						.format(wkScheduleDetail.torokuDt);
				kakutei = "未確定";
				selectStr = selectStr + "1";

			} else {
				tourokuDt = "-";
				kakutei = new SimpleDateFormat("yyyy/MM/dd")
						.format(scheduleKanri.kakuteiDt);
				selectStr = selectStr + "1";

			}

			selectMonth = year + "年" + month + "月" + str;

			ScheduleDto scheduledto = new ScheduleDto();
			scheduledto.setSelectMonth(selectMonth);
			scheduledto.setTourokuDt(tourokuDt);
			scheduledto.setKakutei(kakutei);
			scheduledto.setSelectStr(selectStr);
			a005Form.scheduleDtoList.add(scheduledto);
		}

		return "a005.jsp";
	}
}
