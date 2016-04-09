package jp.ne.asiantao.service;

import java.util.List;
import javax.annotation.Generated;
import jp.ne.asiantao.entity.Department;

import static jp.ne.asiantao.entity.DepartmentNames.*;
import static org.seasar.extension.jdbc.operation.Operations.*;

/**
 * {@link Department}のサービスクラスです。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2015/05/03 7:10:28")
public class DepartmentService extends AbstractService<Department> {

    /**
     * 識別子でエンティティを検索します。
     * 
     * @param id
     *            識別子
     * @return エンティティ
     */
    public Department findById(String id) {
        return select().id(id).getSingleResult();
    }

    /**
     * 識別子の昇順ですべてのエンティティを検索します。
     * 
     * @return エンティティのリスト
     */
    public List<Department> findAllOrderById() {
        return select().orderBy(asc(id())).getResultList();
    }
}