package jp.ne.asiantao.service;

import java.util.List;
import javax.annotation.Generated;
import jp.ne.asiantao.entity.ScheduleKanri;

import static jp.ne.asiantao.entity.ScheduleKanriNames.*;
import static org.seasar.extension.jdbc.operation.Operations.*;

/**
 * {@link ScheduleKanri}のサービスクラスです。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2015/07/20 7:47:48")
public class ScheduleKanriService extends AbstractService<ScheduleKanri> {

    /**
     * 識別子でエンティティを検索します。
     * 
     * @param selectMonth
     *            識別子
     * @param firstFg
     *            識別子
     * @return エンティティ
     */
    public ScheduleKanri findById(String selectMonth, String firstFg) {
        return select().id(selectMonth, firstFg).getSingleResult();
    }

    /**
     * 識別子の昇順ですべてのエンティティを検索します。
     * 
     * @return エンティティのリスト
     */
    public List<ScheduleKanri> findAllOrderById() {
        return select().orderBy(asc(selectMonth()), asc(firstFg())).getResultList();
    }
    
    //確定日を返却する。
    public ScheduleKanri selectKakuteiDt(String selectMonth,String firstFg){
    	
    	return jdbcManager
    			.from(ScheduleKanri.class)
    			.where("selectMonth = ? and firstFg = ? and kakuteiDt IS NOT NULL",selectMonth,firstFg)
    			.getSingleResult();
    }
    
    
}