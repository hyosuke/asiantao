package jp.ne.asiantao.entity;

import java.util.Date;
import javax.annotation.Generated;
import org.seasar.extension.jdbc.name.PropertyName;

/**
 * {@link WkScheduleDetail}のプロパティ名の集合です。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.NamesModelFactoryImpl"}, date = "2015/09/19 17:01:17")
public class WkScheduleDetailNames {

    /**
     * userIdのプロパティ名を返します。
     * 
     * @return userIdのプロパティ名
     */
    public static PropertyName<String> userId() {
        return new PropertyName<String>("userId");
    }

    /**
     * selectMonthのプロパティ名を返します。
     * 
     * @return selectMonthのプロパティ名
     */
    public static PropertyName<String> selectMonth() {
        return new PropertyName<String>("selectMonth");
    }

    /**
     * firstFgのプロパティ名を返します。
     * 
     * @return firstFgのプロパティ名
     */
    public static PropertyName<String> firstFg() {
        return new PropertyName<String>("firstFg");
    }

    /**
     * dayのプロパティ名を返します。
     * 
     * @return dayのプロパティ名
     */
    public static PropertyName<String> day() {
        return new PropertyName<String>("day");
    }

    /**
     * scheduleDvのプロパティ名を返します。
     * 
     * @return scheduleDvのプロパティ名
     */
    public static PropertyName<String> scheduleDv() {
        return new PropertyName<String>("scheduleDv");
    }

    /**
     * bikouのプロパティ名を返します。
     * 
     * @return bikouのプロパティ名
     */
    public static PropertyName<String> bikou() {
        return new PropertyName<String>("bikou");
    }

    /**
     * pozishonDvのプロパティ名を返します。
     * 
     * @return pozishonDvのプロパティ名
     */
    public static PropertyName<String> pozishonDv() {
        return new PropertyName<String>("pozishonDv");
    }

    /**
     * torokuDtのプロパティ名を返します。
     * 
     * @return torokuDtのプロパティ名
     */
    public static PropertyName<Date> torokuDt() {
        return new PropertyName<Date>("torokuDt");
    }

    /**
     * @author S2JDBC-Gen
     */
    public static class _WkScheduleDetailNames extends PropertyName<WkScheduleDetail> {

        /**
         * インスタンスを構築します。
         */
        public _WkScheduleDetailNames() {
        }

        /**
         * インスタンスを構築します。
         * 
         * @param name
         *            名前
         */
        public _WkScheduleDetailNames(final String name) {
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
        public _WkScheduleDetailNames(final PropertyName<?> parent, final String name) {
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
         * selectMonthのプロパティ名を返します。
         *
         * @return selectMonthのプロパティ名
         */
        public PropertyName<String> selectMonth() {
            return new PropertyName<String>(this, "selectMonth");
        }

        /**
         * firstFgのプロパティ名を返します。
         *
         * @return firstFgのプロパティ名
         */
        public PropertyName<String> firstFg() {
            return new PropertyName<String>(this, "firstFg");
        }

        /**
         * dayのプロパティ名を返します。
         *
         * @return dayのプロパティ名
         */
        public PropertyName<String> day() {
            return new PropertyName<String>(this, "day");
        }

        /**
         * scheduleDvのプロパティ名を返します。
         *
         * @return scheduleDvのプロパティ名
         */
        public PropertyName<String> scheduleDv() {
            return new PropertyName<String>(this, "scheduleDv");
        }

        /**
         * bikouのプロパティ名を返します。
         *
         * @return bikouのプロパティ名
         */
        public PropertyName<String> bikou() {
            return new PropertyName<String>(this, "bikou");
        }

        /**
         * pozishonDvのプロパティ名を返します。
         *
         * @return pozishonDvのプロパティ名
         */
        public PropertyName<String> pozishonDv() {
            return new PropertyName<String>(this, "pozishonDv");
        }

        /**
         * torokuDtのプロパティ名を返します。
         *
         * @return torokuDtのプロパティ名
         */
        public PropertyName<Date> torokuDt() {
            return new PropertyName<Date>(this, "torokuDt");
        }
    }
}