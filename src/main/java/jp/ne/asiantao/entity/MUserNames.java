package jp.ne.asiantao.entity;

import javax.annotation.Generated;
import org.seasar.extension.jdbc.name.PropertyName;

/**
 * {@link MUser}のプロパティ名の集合です。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.NamesModelFactoryImpl"}, date = "2015/09/19 17:01:17")
public class MUserNames {

    /**
     * userIdのプロパティ名を返します。
     * 
     * @return userIdのプロパティ名
     */
    public static PropertyName<String> userId() {
        return new PropertyName<String>("userId");
    }

    /**
     * pwのプロパティ名を返します。
     * 
     * @return pwのプロパティ名
     */
    public static PropertyName<String> pw() {
        return new PropertyName<String>("pw");
    }

    /**
     * userNmのプロパティ名を返します。
     * 
     * @return userNmのプロパティ名
     */
    public static PropertyName<String> userNm() {
        return new PropertyName<String>("userNm");
    }

    /**
     * mailAdのプロパティ名を返します。
     * 
     * @return mailAdのプロパティ名
     */
    public static PropertyName<String> mailAd() {
        return new PropertyName<String>("mailAd");
    }

    /**
     * @author S2JDBC-Gen
     */
    public static class _MUserNames extends PropertyName<MUser> {

        /**
         * インスタンスを構築します。
         */
        public _MUserNames() {
        }

        /**
         * インスタンスを構築します。
         * 
         * @param name
         *            名前
         */
        public _MUserNames(final String name) {
            super(name);
        }

        /**
         * インスタンスを構築します。
         * 
         * @param parent
         *            親
         * @param name
         *            名前
         */
        public _MUserNames(final PropertyName<?> parent, final String name) {
            super(parent, name);
        }

        /**
         * userIdのプロパティ名を返します。
         *
         * @return userIdのプロパティ名
         */
        public PropertyName<String> userId() {
            return new PropertyName<String>(this, "userId");
        }

        /**
         * pwのプロパティ名を返します。
         *
         * @return pwのプロパティ名
         */
        public PropertyName<String> pw() {
            return new PropertyName<String>(this, "pw");
        }

        /**
         * userNmのプロパティ名を返します。
         *
         * @return userNmのプロパティ名
         */
        public PropertyName<String> userNm() {
            return new PropertyName<String>(this, "userNm");
        }

        /**
         * mailAdのプロパティ名を返します。
         *
         * @return mailAdのプロパティ名
         */
        public PropertyName<String> mailAd() {
            return new PropertyName<String>(this, "mailAd");
        }
    }
}