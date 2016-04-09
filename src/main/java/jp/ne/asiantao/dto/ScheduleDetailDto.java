package jp.ne.asiantao.dto;

import java.util.ArrayList;

public class ScheduleDetailDto {

	private String day;
	
	private String dayStr;
	
	private String scheduleDv;

	private String shinseiQy;

	private String bikou;
	
	private String kakuteiScheduleDv;
	
	private String kakuteiBikou;
	
	private String kakuteiPozishonDv;
	
	private String kakuteiScheduleDvNm;
	
	private String kakuteiPozishonDvNm;
	
	private String userNm;
	
	private String pozishonDv;
	
	private String torokuDt;
	
	private String torokuFg;
	
	private String userId;
	
	private boolean okFg;
	
	private boolean tuikaFg;
	
	private String cntQy;
	
	public String getCntQy() {
		return cntQy;
	}

	public void setCntQy(String cntQy) {
		this.cntQy = cntQy;
	}

	private String torokuQy;
	
	public String getScheduleDvNm() {
		return scheduleDvNm;
	}

	public void setScheduleDvNm(String scheduleDvNm) {
		this.scheduleDvNm = scheduleDvNm;
	}

	public String getPozishonDvNm() {
		return pozishonDvNm;
	}

	public void setPozishonDvNm(String pozishonDvNm) {
		this.pozishonDvNm = pozishonDvNm;
	}

	private String scheduleDvNm;

	private String pozishonDvNm;
	
	
	public String getTorokuQy() {
		return torokuQy;
	}

	public void setTorokuQy(String torokuQy) {
		this.torokuQy = torokuQy;
	}

	public boolean isTuikaFg() {
		return tuikaFg;
	}

	public void setTuikaFg(boolean tuikaFg) {
		this.tuikaFg = tuikaFg;
	}

	public boolean getOkFg() {
		return okFg;
	}

	public void setOkFg(boolean okFg) {
		this.okFg = okFg;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	private ArrayList<DvDto> scheduleDvList = new ArrayList<DvDto>();
	
	public ArrayList<DvDto> getScheduleDvList() {
		return scheduleDvList;
	}

	public void setScheduleDvList(ArrayList<DvDto> scheduleDvList) {
		this.scheduleDvList = scheduleDvList;
	}


	public String getTorokuFg() {
		return torokuFg;
	}

	public void setTorokuFg(String torokuFg) {
		this.torokuFg = torokuFg;
	}

	public String getPozishonDv() {
		return pozishonDv;
	}

	public void setPozishonDv(String pozishonDv) {
		this.pozishonDv = pozishonDv;
	}

	public String getTorokuDt() {
		return torokuDt;
	}

	public void setTorokuDt(String torokuDt) {
		this.torokuDt = torokuDt;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public String getKakuteiScheduleDvNm() {
		return kakuteiScheduleDvNm;
	}

	public void setKakuteiScheduleDvNm(String kakuteiScheduleDvNm) {
		this.kakuteiScheduleDvNm = kakuteiScheduleDvNm;
	}

	public String getKakuteiPozishonDvNm() {
		return kakuteiPozishonDvNm;
	}

	public void setKakuteiPozishonDvNm(String kakuteiPozishonDvNm) {
		this.kakuteiPozishonDvNm = kakuteiPozishonDvNm;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getDayStr() {
		return dayStr;
	}

	public void setDayStr(String dayStr) {
		this.dayStr = dayStr;
	}

	public String getScheduleDv() {
		return scheduleDv;
	}

	public void setScheduleDv(String scheduleDv) {
		this.scheduleDv = scheduleDv;
	}


	public String getShinseiQy() {
		return shinseiQy;
	}

	public void setShinseiQy(String shinseiQy) {
		this.shinseiQy = shinseiQy;
	}

	public String getBikou() {
		return bikou;
	}

	public void setBikou(String bikou) {
		this.bikou = bikou;
	}

	public String getKakuteiScheduleDv() {
		return kakuteiScheduleDv;
	}

	public void setKakuteiScheduleDv(String kakuteiScheduleDv) {
		this.kakuteiScheduleDv = kakuteiScheduleDv;
	}

	public String getKakuteiBikou() {
		return kakuteiBikou;
	}

	public void setKakuteiBikou(String kakuteiBikou) {
		this.kakuteiBikou = kakuteiBikou;
	}

	public String getKakuteiPozishonDv() {
		return kakuteiPozishonDv;
	}

	public void setKakuteiPozishonDv(String kakuteiPozishonDv) {
		this.kakuteiPozishonDv = kakuteiPozishonDv;
	}
}
