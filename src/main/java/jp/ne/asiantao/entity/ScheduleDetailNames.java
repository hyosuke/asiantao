package jp.ne.asiantao.entity;

import javax.annotation.Generated;
import org.seasar.extension.jdbc.name.PropertyName;

/**
 * {@link ScheduleDetail}のプロパティ名の集合です。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.NamesModelFactoryImpl"}, date = "2015/09/19 17:01:17")
public class ScheduleDetailNames {

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
     * kakuteiScheduleDvのプロパティ名を返します。
     * 
     * @return kakuteiScheduleDvのプロパティ名
     */
    public static PropertyName<String> kakuteiScheduleDv() {
        return new PropertyName<String>("kakuteiScheduleDv");
    }

    /**
     * kakuteiBikouのプロパティ名を返します。
     * 
     * @return kakuteiBikouのプロパティ名
     */
    public static PropertyName<String> kakuteiBikou() {
        return new PropertyName<String>("kakuteiBikou");
    }

    /**
     * kakuteiPozishonDvのプロパティ名を返します。
     * 
     * @return kakuteiPozishonDvのプロパティ名
     */
    public static PropertyName<String> kakuteiPozishonDv() {
        return new PropertyName<String>("kakuteiPozishonDv");
    }

    /**
     * @author S2JDBC-Gen
     */
    public static class _ScheduleDetailNames extends PropertyName<ScheduleDetail> {

        /**
         * インスタンスを構築します。
         */
        public _ScheduleDetailNames() {
        }

        /**
         * インスタンスを構築します。
         * 
         * @param name
         *            名前
         */
        public _ScheduleDetailNames(final String name) {
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
        public _ScheduleDetailNames(final PropertyName<?> parent, final String name) {
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
         * kakuteiScheduleDvのプロパティ名を返します。
         *
         * @return kakuteiScheduleDvのプロパティ名
         */
        public PropertyName<String> kakuteiScheduleDv() {
            return new PropertyName<String>(this, "kakuteiScheduleDv");
        }

        /**
         * kakuteiBikouのプロパティ名を返します。
         *
         * @return kakuteiBikouのプロパティ名
         */
        public PropertyName<String> kakuteiBikou() {
            return new PropertyName<String>(this, "kakuteiBikou");
        }

        /**
         * kakuteiPozishonDvのプロパティ名を返します。
         *
         * @return kakuteiPozishonDvのプロパティ名
         */
        public PropertyName<String> kakuteiPozishonDv() {
            return new PropertyName<String>(this, "kakuteiPozishonDv");
        }
    }
}