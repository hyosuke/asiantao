package jp.ne.asiantao.entity;

import java.io.Serializable;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * MUserエンティティクラス
 * 
 */
@Entity
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.EntityModelFactoryImpl"}, date = "2015/05/03 7:10:07")
public class MUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /** userIdプロパティ */
    @Id
    @Column(length = 10, nullable = false, unique = true)
    public String userId;

    /** pwプロパティ */
    @Column(length = 20, nullable = false, unique = false)
    public String pw;

    /** userNmプロパティ */
    @Column(length = 20, nullable = true, unique = false)
    public String userNm;

    /** mailAdプロパティ */
    @Column(length = 50, nullable = true, unique = false)
    public String mailAd;
    
    @Column(length = 1, nullable = false, unique = false)
    public String kanriFg;
    
}