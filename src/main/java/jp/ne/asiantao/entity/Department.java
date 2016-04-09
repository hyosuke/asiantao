package jp.ne.asiantao.entity;

import java.io.Serializable;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Departmentエンティティクラス
 * 
 */
@Entity
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.EntityModelFactoryImpl"}, date = "2015/05/03 7:10:07")
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    /** idプロパティ */
    @Id
    @Column(length = 2, nullable = false, unique = true)
    public String id;

    /** nameプロパティ */
    @Column(length = 20, nullable = true, unique = false)
    public String name;
}