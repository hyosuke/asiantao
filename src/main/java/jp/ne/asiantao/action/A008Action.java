package jp.ne.asiantao.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import jp.ne.asiantao.dto.DvDto;
import jp.ne.asiantao.dto.MuserDto;
import jp.ne.asiantao.dto.ScheduleDetailDto;
import jp.ne.asiantao.dto.UserDto;
import jp.ne.asiantao.entity.MUser;
import jp.ne.asiantao.entity.SDv;
import jp.ne.asiantao.entity.WkScheduleDetail;
import jp.ne.asiantao.form.A008Form;
import jp.ne.asiantao.service.MUserService;
import jp.ne.asiantao.service.SDvService;
import jp.ne.asiantao.service.ScheduleDetailService;
import jp.ne.asiantao.service.WkScheduleDetailService;
import jp.ne.asiantao.util.Auth;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

public class A008Action {


	@Resource
	@ActionForm
	protected A008Form a008Form;

	@Resource
	protected ScheduleDetailService scheduleDetailService;

	@Resource
	protected SDvService sDvService;

	@Resource
	protected WkScheduleDetailService wkScheduleDetailService;

	@Resource
	protected MUserService mUserService;

	@Resource
	protected UserDto userDto;

	public ArrayList<DvDto> positionList;

	public ArrayList<DvDto> scheduleList;

	public ArrayList<MuserDto> userList;

	public ArrayList<String> messageList;

	public int shinseiQy;

	public int userListSize;

	@Auth
	@Execute(validator = false)
	public String index() {
		setUpDisplay();

		return "a008.jsp";
	}

	@Execute(validator = false)
	public String regist() {
		messageList = new ArrayList<String>();
		ArrayList<ScheduleDetailDto> registListwk = a008Form.scheduleDetailDtoList;

		int torokuCnt = 0;

		for (ScheduleDetailDto scheduleDetailDtowk : registListwk) {

			if (scheduleDetailDtowk == null) {
				continue;
			}

			if (scheduleDetailDtowk.isTuikaFg()
					|| scheduleDetailDtowk.getOkFg()) {

				torokuCnt++;
			}

		}
		if (torokuCnt == 0) {

			messageList.add("登録対象が選ばれておりません");

			setUpDisplay();

			return "a008.jsp";
		}

		HashMap<String, String> parm = new HashMap<>();

		parm.put("selectMonth", a008Form.selectMonth);
		parm.put("day", a008Form.day);

		wkScheduleDetailService.deleteWkScheduleDetail(parm);

		for (ScheduleDetailDto scheduleDetailDtowk : registListwk) {

			if (scheduleDetailDtowk == null) {
				continue;
			}

			if (scheduleDetailDtowk.isTuikaFg()
					|| scheduleDetailDtowk.getOkFg()) {

				WkScheduleDetail wkScheduleDetail = new WkScheduleDetail();

				wkScheduleDetail.userId = scheduleDetailDtowk.getUserId();
				wkScheduleDetail.selectMonth = a008Form.selectMonth;
				if (Integer.parseInt(a008Form.day) <= 15) {
					wkScheduleDetail.firstFg = "1";
				} else {
					wkScheduleDetail.firstFg = "0";
				}
				wkScheduleDetail.day = a008Form.day;
				wkScheduleDetail.pozishonDv = scheduleDetailDtowk
						.getPozishonDv();
				wkScheduleDetail.scheduleDv = scheduleDetailDtowk
						.getScheduleDv();
				wkScheduleDetail.torokuDt = new Date();

				wkScheduleDetailService.insert(wkScheduleDetail);
			}
		}
		
		String firstFg;
		
		if(Integer.valueOf(a008Form.day).intValue() >15){
			firstFg = "0";
		}else{
			firstFg = "1";
		}
		
		return "/a007?selectMonth="+a008Form.selectMonth+"&firstFg="+firstFg+"&redirect=true";
	}

	protected void setUpDisplay() {
		HashMap<String, String> parm = new HashMap<String, String>();
		String selectMonth = a008Form.selectMonth;
		String day = String.format("%1$02d", Integer.parseInt(a008Form.day));
		parm.put("selectMonth", selectMonth);
		parm.put("day", day);

		// 申請者情報を取得する。
		List<ScheduleDetailDto> scheduleDetailDtoListwk = scheduleDetailService
				.selectShinseiList(parm);

		shinseiQy = scheduleDetailDtoListwk.size();

		// スケジュール区分リストを取得する。
		List<SDv> scheduleDvListwk = sDvService.selectDvList("SCHEDULE_DV");

		scheduleList = new ArrayList<DvDto>();
		for (SDv dv : scheduleDvListwk) {
			// 区分値が00以外のものを追加する。
			if (!dv.dvValue.equals("00")) {
				DvDto dvDto = new DvDto();
				dvDto.setDvValue(dv.dvValue);
				dvDto.setDvName(dv.dvName);
				scheduleList.add(dvDto);
			}
		}

		// ユーザリストを取得する。
		List<MUser> userListWk = mUserService.selectUserList();
		userListSize = userListWk.size();

		userList = new ArrayList<MuserDto>();
		for (MUser mUser : userListWk) {

			MuserDto mUserDto = new MuserDto();
			mUserDto.setUserId(mUser.userId);
			mUserDto.setUserNm(mUser.userNm);

			userList.add(mUserDto);
		}

		// ポジション区分リストを取得する。
		List<SDv> positionDvList = sDvService.selectDvList("POZISION_DV");
		positionList = new ArrayList<DvDto>();
		for (SDv dv : positionDvList) {

			DvDto dvDto = new DvDto();
			dvDto.setDvValue(dv.dvValue);
			dvDto.setDvName(dv.dvName);

			positionList.add(dvDto);

		}


		a008Form.scheduleDetailDtoList = new ArrayList<ScheduleDetailDto>();

		int cntQy = 0;
			for (ScheduleDetailDto scheduleDetailDto : scheduleDetailDtoListwk) {

				if (!scheduleDetailDto.getScheduleDv().equals("00")) {
					ArrayList<DvDto> scheduleDvList = new ArrayList<DvDto>();
				
					boolean check = false;
					// スケジュール区分の設定
					for (SDv sDv : scheduleDvListwk) {
						DvDto dvDto = new DvDto();
						if (sDv.dvValue.equals(scheduleDetailDto
								.getScheduleDv()) || check) {
							check = true;
							dvDto.setDvValue(sDv.dvValue);
							dvDto.setDvName(sDv.dvName);
							scheduleDvList.add(dvDto);
						}
					}

					scheduleDetailDto.setCntQy(String.valueOf(cntQy));
					scheduleDetailDto.setScheduleDvList(scheduleDvList);
					a008Form.scheduleDetailDtoList.add(scheduleDetailDto);
					
					cntQy++;
				}
			}
		}
}

