package jp.ne.asiantao.entity;

import java.io.Serializable;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * ScheduleDetailエンティティクラス
 * 
 */
@Entity
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.EntityModelFactoryImpl"}, date = "2015/05/06 20:23:47")
public class ScheduleDetail implements Serializable {

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

    /** kakuteiScheduleDvプロパティ */
    @Column(length = 3, nullable = true, unique = false)
    public String kakuteiScheduleDv;

    /** kakuteiBikouプロパティ */
    @Column(length = 30, nullable = true, unique = false)
    public String kakuteiBikou;

    /** kakuteiPozishonDvプロパティ */
    @Column(length = 3, nullable = true, unique = false)
    public String kakuteiPozishonDv;
}