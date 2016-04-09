package jp.ne.asiantao.service;

import java.util.List;

import javax.annotation.Generated;

import jp.ne.asiantao.entity.SDv;
import static jp.ne.asiantao.entity.SDvNames.*;
import static org.seasar.extension.jdbc.operation.Operations.*;

/**
 * {@link SDv}のサービスクラスです。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2015/05/04 8:11:28")
public class SDvService extends AbstractService<SDv> {

    /**
     * 識別子でエンティティを検索します。
     * 
     * @param dv
     *            識別子
     * @param dvValue
     *            識別子
     * @return エンティティ
     */
    public SDv findById(String dv, String dvValue) {
        return select().id(dv, dvValue).getSingleResult();
    }

    /**
     * 識別子の昇順ですべてのエンティティを検索します。
     * 
     * @return エンティティのリスト
     */
    public List<SDv> findAllOrderById() {
        return select().orderBy(asc(dv()), asc(dvValue())).getResultList();
    }
    
    //区分値,区分名の取得
    public List<SDv> selectDvList(String dv){
    	
    	return jdbcManager
    			.from(SDv.class)
    			.where("dv = ?",dv)
    			.orderBy("DV_VALUE ASC")
    			.getResultList();
    }
    
}