package jp.ne.asiantao.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Generated;

import jp.ne.asiantao.dto.ScheduleDetailDto;
import jp.ne.asiantao.entity.WkScheduleDetail;
import static jp.ne.asiantao.entity.ScheduleDetailNames.userId;
import static jp.ne.asiantao.entity.WkScheduleDetailNames.*;
import static org.seasar.extension.jdbc.operation.Operations.*;

/**
 * {@link WkScheduleDetail}のサービスクラスです。
 * 
 */
@Generated(value = { "S2JDBC-Gen 2.4.46",
		"org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl" }, date = "2015/05/17 10:55:15")
public class WkScheduleDetailService extends AbstractService<WkScheduleDetail> {

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
	public WkScheduleDetail findById(String userId, String selectMonth,
			String firstFg, String day) {
		return select().id(userId, selectMonth, firstFg, day).getSingleResult();
	}

	/**
	 * 識別子の昇順ですべてのエンティティを検索します。
	 * 
	 * @return エンティティのリスト
	 */
	public List<WkScheduleDetail> findAllOrderById() {
		return select().orderBy(asc(userId()), asc(selectMonth()),
				asc(firstFg()), asc(day())).getResultList();
	}

	// 年月、前半フラグを条件にして半月分の登録情報を取得する。
	public List<WkScheduleDetail> selectHalfData(String selectMonth,
			String firstFg) {

		return jdbcManager.from(WkScheduleDetail.class)
				.where("selectMonth = ? and firstFg = ?", selectMonth, firstFg)
				.orderBy(asc(userId())).getResultList();
	}

	// 年月日を条件にして登録情報(一件)を取得する。
	public WkScheduleDetail selectWkScheduleDetail(String selectMonth,
			String day) {
		return jdbcManager
				.from(WkScheduleDetail.class)
				.where("selectMonth = ? and day = ? and rownum <=1 ",
						selectMonth, day).getSingleResult();

	}

	// 年月日を条件にして登録情報を取得する。
	public List<WkScheduleDetail> selectWkScheduleDetailDay(String selectMonth,
			String day) {

		return jdbcManager.from(WkScheduleDetail.class)
				.where("selectMonth = ? and day = ?", selectMonth, day)
				.getResultList();
	}

	// 年月日を条件に指定して登録人数を取得する。
	public long countWkScheduleDetail(String selectMonth, String day) {

		return jdbcManager.from(WkScheduleDetail.class)
				.where("selectMonth = ? and day = ? ", selectMonth, day)
				.getCount();
	}

	// 年月を条件にして登録情報を一件取得する。
	public WkScheduleDetail selectWkScheduleDetail2(HashMap<String, String> parm) {
		return jdbcManager.selectBySqlFile(WkScheduleDetail.class,
				"data/SelectWkScheduleDetailSingle.sql", parm)
				.getSingleResult();
	}

	// 年月日を条件にして登録データを削除する。
	public long deleteWkScheduleDetail(HashMap<String, String> parm) {

		return jdbcManager.updateBySqlFile("data/DeleteWkScheduleDetail.sql",
				parm).execute();
	}

	// 年月を条件にして登録データを削除する。
	public long deleteWkScheduleDetail2(HashMap<String, String> parm) {

		return jdbcManager.updateBySqlFile("data/DeleteWkScheduleDetail2.sql",
				parm).execute();
	}
	
	// 一日単位で登録シフトを取得する。
	public List<ScheduleDetailDto> selectShiftList(HashMap<String, String> parm) {
		return jdbcManager.selectBySqlFile(ScheduleDetailDto.class,
				"data/SelectShiftList2.sql", parm).getResultList();
	}

	public int[] insertFukugen(List<WkScheduleDetail> wkScheduleList) {

		return jdbcManager.insertBatch(wkScheduleList).execute();
	}
}