package jp.ne.asiantao.entity;

import java.io.Serializable;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Oshiraseエンティティクラス
 * 
 */
@Entity
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.EntityModelFactoryImpl"}, date = "2015/09/19 10:14:56")
public class Oshirase implements Serializable {

    private static final long serialVersionUID = 1L;

    /** tourokubiプロパティ */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = true, unique = false)
    public Date tourokubi;

    /** tourokuNengetuプロパティ */
    @Column(length = 20, nullable = true, unique = false)
    public String tourokuNengetu;

    /** ohiraseプロパティ */
    @Column(length = 500, nullable = true, unique = false)
    public String ohirase;
}