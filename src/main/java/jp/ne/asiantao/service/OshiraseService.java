package jp.ne.asiantao.service;

import java.util.List;

import javax.annotation.Generated;

import jp.ne.asiantao.entity.Oshirase;

/**
 * {@link Oshirase}のサービスクラスです。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2015/09/19 10:15:21")
public class OshiraseService extends AbstractService<Oshirase> {
	
	
	public List<Oshirase> selectOshirase(String tourokuNengetu){
		
		return jdbcManager
				.from(Oshirase.class)
				.where("tourokuNengetu = ?",
						tourokuNengetu).orderBy("tourokubi desc")
				.getResultList();
	}
	
}