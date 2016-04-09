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
 * WkScheduleDetailエンティティクラス
 * 
 */
@Entity
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.EntityModelFactoryImpl"}, date = "2015/05/17 10:54:52")
public class WkScheduleDetail implements Serializable {

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

    /** dayプロパティ */
    @Id
    @Column(length = 2, nullable = false, unique = false)
    public String day;

    /** scheduleDvプロパティ */
    @Column(length = 3, nullable = false, unique = false)
    public String scheduleDv;

    /** bikouプロパティ */
    @Column(length = 30, nullable = true, unique = false)
    public String bikou;

    /** pozishonDvプロパティ */
    @Column(length = 3, nullable = false, unique = false)
    public String pozishonDv;

    /** torokuDtプロパティ */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, unique = false)
    public Date torokuDt;
}