package jp.ne.asiantao.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Generated;

import jp.ne.asiantao.dto.ScheduleDetailDto;
import jp.ne.asiantao.entity.ScheduleDetail;
import static jp.ne.asiantao.entity.ScheduleDetailNames.*;
import static org.seasar.extension.jdbc.operation.Operations.*;

/**
 * {@link ScheduleDetail}のサービスクラスです。
 * 
 */
@Generated(value = { "S2JDBC-Gen 2.4.46",
		"org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl" }, date = "2015/05/03 10:49:35")
public class ScheduleDetailService extends AbstractService<ScheduleDetail> {

	/**
	 * 識別子でエンティティを検索します。
	 * 
	 * @param userId
	 *            識別子
	 * @param selectMonth
	 *            識別子
	 * @param firstFg
	 *            識別子
	 * @param day
	 *            識別子
	 * @return エンティティ
	 */
	public ScheduleDetail findById(String userId, String selectMonth,
			String firstFg, String day) {
		return select().id(userId, selectMonth, firstFg, day).getSingleResult();
	}

	/**
	 * 識別子の昇順ですべてのエンティティを検索します。
	 * 
	 * @return エンティティのリスト
	 */
	public List<ScheduleDetail> findAllOrderById() {
		return select().orderBy(asc(userId()), asc(selectMonth()),
				asc(firstFg()), asc(day())).getResultList();
	}

	// 半月分の個人のスケジュールを取得する。
	public List<ScheduleDetail> selectScheduleDetailList(String userId,
			String selectMonth, String firstFg) {
		return jdbcManager
				.from(ScheduleDetail.class)
				.where("userId = ? and selectMonth = ? and firstFg = ?",
						userId, selectMonth, firstFg).orderBy("day asc")
				.getResultList();
	}

	// 申請者数取得
	public long countShinseishaQy(String selectMonth, String day) {
		return jdbcManager
				.from(ScheduleDetail.class)
				.where("selectMonth = ? and day = ? and scheduleDv <> '00'",
						selectMonth, day).getCount();
	}

	// 登録データ存在チェック
	public long countTourokuUmu(String selectMonth, String firstFg,
			String userId) {

		return jdbcManager
				.from(ScheduleDetail.class)
				.where("userId = ? and selectMonth = ? and  firstFg = ? and rownum <= 1",
						userId, selectMonth, firstFg).getCount();
	}

	// 登録処理(複数件)
	public int[] regist(List<ScheduleDetail> scheduleDetailList) {
		return jdbcManager.insertBatch(scheduleDetailList).execute();
	}

	// 登録処理(一件)
	public int regist(ScheduleDetail scheduleDetail) {

		return jdbcManager.insert(scheduleDetail).execute();
	}

	// 削除処理
	public int[] delete(List<ScheduleDetail> scheduleDetailList) {
		return jdbcManager.deleteBatch(scheduleDetailList).execute();
	}

	// 削除処理
	public int deleteFukugen(HashMap<String, String> parm) {
		return jdbcManager.updateBySqlFile(
				"data/DeleteScheduleDetailFukugen.sql", parm).execute();
	}

	// 更新処理
	public int update(HashMap<String, String> parm) {

		return jdbcManager.updateBySqlFile("data/UpdateScheduleDetail.sql",
				parm).execute();
	}

	// 更新処理
	public int updateFukugen(HashMap<String, String> parm) {

		return jdbcManager.updateBySqlFile(
				"data/UpdateScheduleDetailFukugen.sql", parm).execute();
	}

	// 一日単位で確定シフトを取得する。
	public List<ScheduleDetailDto> selectShiftList(HashMap<String, String> parm) {
		return jdbcManager.selectBySqlFile(ScheduleDetailDto.class,
				"data/SelectShiftList.sql", parm).getResultList();
	}
	
	public List<ScheduleDetailDto> selectShiftList2(HashMap<String, String> parm) {
		return jdbcManager.selectBySqlFile(ScheduleDetailDto.class,
				"data/SelectShinseiShiftList.sql", parm).getResultList();
	}

	// 年月日を条件にして申請情報取得を取得する。
	public List<ScheduleDetailDto> selectShinseiList(
			HashMap<String, String> parm) {
		return jdbcManager.selectBySqlFile(ScheduleDetailDto.class,
				"data/SelectShinseiList.sql", parm).getResultList();
	}

	// 確定人数を取得する。
	public List<ScheduleDetailDto> cntKakuteiQy(HashMap<String, String> parm) {
		return jdbcManager.selectBySqlFile(ScheduleDetailDto.class,
				"data/SelectCntKakuteiQy.sql", parm).getResultList();
	}

	public List<ScheduleDetail> selectFukugen(String selectMonth, String firstFg) {

		return jdbcManager
				.from(ScheduleDetail.class)
				.where("selectMonth = ? and  firstFg = ? and kakuteiScheduleDv is not null",
						selectMonth, firstFg).getResultList();

	}

}