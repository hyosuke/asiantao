package jp.ne.asiantao.entity;

import java.io.Serializable;


import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * SDvエンティティクラス
 * 
 */
@Entity
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.EntityModelFactoryImpl"}, date = "2015/05/04 8:11:04")
public class SDv implements Serializable {

    private static final long serialVersionUID = 1L;

    /** dvプロパティ */
    @Id
    @Column(length = 20, nullable = false, unique = false)
    public String dv;

    /** dvValueプロパティ */
    @Id
    @Column(length = 3, nullable = false, unique = false)
    public String dvValue;

    /** dvNameプロパティ */
    @Column(length = 20, nullable = false, unique = false)
    public String dvName;
    
    
}