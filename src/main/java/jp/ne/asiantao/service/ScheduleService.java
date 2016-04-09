package jp.ne.asiantao.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Generated;

import jp.ne.asiantao.dto.MuserDto;
import jp.ne.asiantao.entity.Schedule;
import static jp.ne.asiantao.entity.ScheduleNames.*;
import static org.seasar.extension.jdbc.operation.Operations.*;

/**
 * {@link Schedule}のサービスクラスです。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2015/05/03 10:49:35")
public class ScheduleService extends AbstractService<Schedule> {

    /**
     * 識別子でエンティティを検索します。
     * 
     * @param userId
     *            識別子
     * @param selectMonth
     *            識別子
     * @param firstFg
     *            識別子
     * @return エンティティ
     */
    public Schedule findById(String userId, String selectMonth, String firstFg) {
        return select().id(userId, selectMonth, firstFg).getSingleResult();
    }

    /**
     * 識別子の昇順ですべてのエンティティを検索します。
     * 
     * @return エンティティのリスト
     */
    public List<Schedule> findAllOrderById() {
        return select().orderBy(asc(userId()), asc(selectMonth()), asc(firstFg())).getResultList();
    }
    
    //シフト未提出者を取得する。
    public List<MuserDto> SelectMiteishutushaList(HashMap<String,String> parm){
    	return jdbcManager
    			.selectBySqlFile(MuserDto.class, "data/SelectMiteishutusha.sql",parm)
    			.getResultList();
    }
}