package jp.ne.asiantao.entity;

import java.util.Date;
import javax.annotation.Generated;
import org.seasar.extension.jdbc.name.PropertyName;

/**
 * {@link Schedule}のプロパティ名の集合です。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.NamesModelFactoryImpl"}, date = "2015/09/19 17:01:17")
public class ScheduleNames {

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
    public static class _ScheduleNames extends PropertyName<Schedule> {

        /**
         * インスタンスを構築します。
         */
        public _ScheduleNames() {
        }

        /**
         * インスタンスを構築します。
         * 
         * @param name
         *            名前
         */
        public _ScheduleNames(final String name) {
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
        public _ScheduleNames(final PropertyName<?> parent, final String name) {
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
         * torokuDtのプロパティ名を返します。
         *
         * @return torokuDtのプロパティ名
         */
        public PropertyName<Date> torokuDt() {
            return new PropertyName<Date>(this, "torokuDt");
        }
    }
}