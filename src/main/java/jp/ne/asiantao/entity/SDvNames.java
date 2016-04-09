package jp.ne.asiantao.entity;

import javax.annotation.Generated;
import org.seasar.extension.jdbc.name.PropertyName;

/**
 * {@link SDv}のプロパティ名の集合です。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.NamesModelFactoryImpl"}, date = "2015/09/19 17:01:17")
public class SDvNames {

    /**
     * dvのプロパティ名を返します。
     * 
     * @return dvのプロパティ名
     */
    public static PropertyName<String> dv() {
        return new PropertyName<String>("dv");
    }

    /**
     * dvValueのプロパティ名を返します。
     * 
     * @return dvValueのプロパティ名
     */
    public static PropertyName<String> dvValue() {
        return new PropertyName<String>("dvValue");
    }

    /**
     * dvNameのプロパティ名を返します。
     * 
     * @return dvNameのプロパティ名
     */
    public static PropertyName<String> dvName() {
        return new PropertyName<String>("dvName");
    }

    /**
     * @author S2JDBC-Gen
     */
    public static class _SDvNames extends PropertyName<SDv> {

        /**
         * インスタンスを構築します。
         */
        public _SDvNames() {
        }

        /**
         * インスタンスを構築します。
         * 
         * @param name
         *            名前
         */
        public _SDvNames(final String name) {
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
        public _SDvNames(final PropertyName<?> parent, final String name) {
            super(parent, name);
        }

        /**
         * dvのプロパティ名を返します。
         *
         * @return dvのプロパティ名
         */
        public PropertyName<String> dv() {
            return new PropertyName<String>(this, "dv");
        }

        /**
         * dvValueのプロパティ名を返します。
         *
         * @return dvValueのプロパティ名
         */
        public PropertyName<String> dvValue() {
            return new PropertyName<String>(this, "dvValue");
        }

        /**
         * dvNameのプロパティ名を返します。
         *
         * @return dvNameのプロパティ名
         */
        public PropertyName<String> dvName() {
            return new PropertyName<String>(this, "dvName");
        }
    }
}