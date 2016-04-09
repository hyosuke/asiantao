package jp.ne.asiantao.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.annotation.Resource;

import jp.ne.asiantao.dto.ScheduleDto;
import jp.ne.asiantao.dto.UserDto;
import jp.ne.asiantao.entity.ScheduleKanri;
import jp.ne.asiantao.form.A003Form;
import jp.ne.asiantao.service.ScheduleDetailService;
import jp.ne.asiantao.service.ScheduleKanriService;
import jp.ne.asiantao.util.Auth;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

public class A003Action {

	@Resource
	@ActionForm
	protected A003Form a003Form;

	@Resource
	protected UserDto userDto;

	@Resource
	protected ScheduleDetailService scheduleDetailService;

	@Resource
	protected ScheduleKanriService scheduleKanriService;

	// 初期表示
	@Auth
	@Execute(validator = false)
	public String index() {

		String str;
		String firstFg;
		String selectMonth;
		String selectStr;

		// 処理年月を取得
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;

		// 一覧情報作成
		for (int i = 0; i <= 5; i++) {

			if (i % 2 == 1) {
				str = "後半";
				firstFg = "0";
				selectMonth = String.valueOf(year)
						+ String.format("%1$02d", month) + firstFg;
				selectStr = String.valueOf(year) + "年" + String.valueOf(month)
						+ "月" + str;
			} else {
				if (i != 0) {
					month -= 1;
					if (month == 0) {
						month += 12;
						year -= 1;
					}
				}
				str = "前半";
				firstFg = "1";
				selectMonth = String.valueOf(year)
						+ String.format("%1$02d", month) + firstFg;
				selectStr = String.valueOf(year) + "年" + String.valueOf(month)
						+ "月" + str;
			}

			ScheduleKanri scheduleKanri = scheduleKanriService.selectKakuteiDt(
					selectMonth.substring(0, 6), firstFg);
			if (scheduleKanri == null) {
				continue;
			}
			ScheduleDto scheduledto = new ScheduleDto();
			scheduledto.setSelectMonth(selectMonth);
			scheduledto.setSelectStr(selectStr);
			scheduledto.setKakutei(new SimpleDateFormat("yyyy/MM/dd")
					.format(scheduleKanri.kakuteiDt));

			a003Form.scheduleDtoList.add(scheduledto);

		}

		return "a003.jsp";
	}

}
