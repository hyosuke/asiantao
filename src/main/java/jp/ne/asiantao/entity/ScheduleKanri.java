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
 * ScheduleKanriエンティティクラス
 * 
 */
@Entity
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.EntityModelFactoryImpl"}, date = "2015/07/20 7:47:23")
public class ScheduleKanri implements Serializable {

    private static final long serialVersionUID = 1L;

    /** selectMonthプロパティ */
    @Id
    @Column(length = 6, nullable = false, unique = false)
    public String selectMonth;

    /** firstFgプロパティ */
    @Id
    @Column(length = 1, nullable = false, unique = false)
    public String firstFg;

    /** kakuteiDtプロパティ */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = true, unique = false)
    public Date kakuteiDt;

}