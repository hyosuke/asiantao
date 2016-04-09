package jp.ne.asiantao.entity;

import javax.annotation.Generated;
import jp.ne.asiantao.entity.DepartmentNames._DepartmentNames;
import jp.ne.asiantao.entity.MUserNames._MUserNames;
import jp.ne.asiantao.entity.OshiraseNames._OshiraseNames;
import jp.ne.asiantao.entity.SDvNames._SDvNames;
import jp.ne.asiantao.entity.ScheduleDetailNames._ScheduleDetailNames;
import jp.ne.asiantao.entity.ScheduleKanriNames._ScheduleKanriNames;
import jp.ne.asiantao.entity.ScheduleNames._ScheduleNames;
import jp.ne.asiantao.entity.WkScheduleDetailNames._WkScheduleDetailNames;

/**
 * 名前クラスの集約です。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.NamesAggregateModelFactoryImpl"}, date = "2015/09/19 17:01:17")
public class Names {

    /**
     * {@link Department}の名前クラスを返します。
     * 
     * @return Departmentの名前クラス
     */
    public static _DepartmentNames department() {
        return new _DepartmentNames();
    }

    /**
     * {@link MUser}の名前クラスを返します。
     * 
     * @return MUserの名前クラス
     */
    public static _MUserNames mUser() {
        return new _MUserNames();
    }

    /**
     * {@link Oshirase}の名前クラスを返します。
     * 
     * @return Oshiraseの名前クラス
     */
    public static _OshiraseNames oshirase() {
        return new _OshiraseNames();
    }

    /**
     * {@link Schedule}の名前クラスを返します。
     * 
     * @return Scheduleの名前クラス
     */
    public static _ScheduleNames schedule() {
        return new _ScheduleNames();
    }

    /**
     * {@link ScheduleDetail}の名前クラスを返します。
     * 
     * @return ScheduleDetailの名前クラス
     */
    public static _ScheduleDetailNames scheduleDetail() {
        return new _ScheduleDetailNames();
    }

    /**
     * {@link ScheduleKanri}の名前クラスを返します。
     * 
     * @return ScheduleKanriの名前クラス
     */
    public static _ScheduleKanriNames scheduleKanri() {
        return new _ScheduleKanriNames();
    }

    /**
     * {@link SDv}の名前クラスを返します。
     * 
     * @return SDvの名前クラス
     */
    public static _SDvNames sDv() {
        return new _SDvNames();
    }

    /**
     * {@link WkScheduleDetail}の名前クラスを返します。
     * 
     * @return WkScheduleDetailの名前クラス
     */
    public static _WkScheduleDetailNames wkScheduleDetail() {
        return new _WkScheduleDetailNames();
    }
}