package jp.ne.asiantao.entity;

import java.io.Serializable;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Scheduleエンティティクラス
 * 
 */
@Entity
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.EntityModelFactoryImpl"}, date = "2015/05/03 10:49:11")
public class Schedule implements Serializable {

    private static final long serialVersionUID = 1L;

    /** userIdプロパティ */
    @Id
    @Column(length = 10, nullable = false, unique = false)
    public String userId;

    /** selectMonthプロパティ */
    @Id
    @Column(length = 6, nullable = false, unique = false)
    public String selectMonth;

    /** firstFgプロパティ */
    @Id
    @Column(length = 1, nullable = false, unique = false)
    public String firstFg;

    /** torokuDtプロパティ */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, unique = false)
    public Date torokuDt;
}