package jp.ne.asiantao.service;

import java.util.List;
import javax.annotation.Generated;
import jp.ne.asiantao.entity.MUser;

import static jp.ne.asiantao.entity.MUserNames.*;
import static org.seasar.extension.jdbc.operation.Operations.*;

/**
 * {@link MUser}のサービスクラスです。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2015/05/03 7:10:28")
public class MUserService extends AbstractService<MUser> {

    /**
     * 識別子でエンティティを検索します。
     * 
     * @param userId
     *            識別子
     * @return エンティティ
     */
    public MUser findById(String userId) {
        return select().id(userId).getSingleResult();
    }

    /**
     * 識別子の昇順ですべてのエンティティを検索します。
     * 
     * @return エンティティのリスト
     */
    public List<MUser> findAllOrderById() {
        return select().orderBy(asc(userId())).getResultList();
    }
    
    //ログインチェック用　ユーザIDとパスワードでユーザ情報を取得する。
    public MUser logincheck(String userId, String pw){
    	
    return jdbcManager
    			.from(MUser.class)
    			.where("userId = ? and pw = ?",userId,pw)
    			.getSingleResult();
    }
    
    //登録処理
    public int regist(MUser mUser){
    	return jdbcManager.insert(mUser).execute();
    }
    
    //ユーザ一覧取得
    public List<MUser> selectUserList(){
    	
    	return jdbcManager
    			.from(MUser.class)
    			.where("userId <> 'asiantao'")
    			.getResultList();
    }
}