package jp.ne.asiantao.entity;

import java.util.Date;
import javax.annotation.Generated;
import org.seasar.extension.jdbc.name.PropertyName;

/**
 * {@link Oshirase}のプロパティ名の集合です。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.NamesModelFactoryImpl"}, date = "2015/09/19 17:01:17")
public class OshiraseNames {

    /**
     * tourokubiのプロパティ名を返します。
     * 
     * @return tourokubiのプロパティ名
     */
    public static PropertyName<Date> tourokubi() {
        return new PropertyName<Date>("tourokubi");
    }

    /**
     * tourokuNengetuのプロパティ名を返します。
     * 
     * @return tourokuNengetuのプロパティ名
     */
    public static PropertyName<String> tourokuNengetu() {
        return new PropertyName<String>("tourokuNengetu");
    }

    /**
     * ohiraseのプロパティ名を返します。
     * 
     * @return ohiraseのプロパティ名
     */
    public static PropertyName<String> ohirase() {
        return new PropertyName<String>("ohirase");
    }

    /**
     * @author S2JDBC-Gen
     */
    public static class _OshiraseNames extends PropertyName<Oshirase> {

        /**
         * インスタンスを構築します。
         */
        public _OshiraseNames() {
        }

        /**
         * インスタンスを構築します。
         * 
         * @param name
         *            名前
         */
        public _OshiraseNames(final String name) {
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
        public _OshiraseNames(final PropertyName<?> parent, final String name) {
            super(parent, name);
        }

        /**
         * tourokubiのプロパティ名を返します。
         *
         * @return tourokubiのプロパティ名
         */
        public PropertyName<Date> tourokubi() {
            return new PropertyName<Date>(this, "tourokubi");
        }

        /**
         * tourokuNengetuのプロパティ名を返します。
         *
         * @return tourokuNengetuのプロパティ名
         */
        public PropertyName<String> tourokuNengetu() {
            return new PropertyName<String>(this, "tourokuNengetu");
        }

        /**
         * ohiraseのプロパティ名を返します。
         *
         * @return ohiraseのプロパティ名
         */
        public PropertyName<String> ohirase() {
            return new PropertyName<String>(this, "ohirase");
        }
    }
}