package jp.ne.asiantao.entity;

import java.util.Date;
import javax.annotation.Generated;
import org.seasar.extension.jdbc.name.PropertyName;

/**
 * {@link ScheduleKanri}のプロパティ名の集合です。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.NamesModelFactoryImpl"}, date = "2015/09/19 17:01:17")
public class ScheduleKanriNames {

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
     * kakuteiDtのプロパティ名を返します。
     * 
     * @return kakuteiDtのプロパティ名
     */
    public static PropertyName<Date> kakuteiDt() {
        return new PropertyName<Date>("kakuteiDt");
    }

    /**
     * @author S2JDBC-Gen
     */
    public static class _ScheduleKanriNames extends PropertyName<ScheduleKanri> {

        /**
         * インスタンスを構築します。
         */
        public _ScheduleKanriNames() {
        }

        /**
         * インスタンスを構築します。
         * 
         * @param name
         *            名前
         */
        public _ScheduleKanriNames(final String name) {
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
        public _ScheduleKanriNames(final PropertyName<?> parent, final String name) {
            super(parent, name);
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
         * kakuteiDtのプロパティ名を返します。
         *
         * @return kakuteiDtのプロパティ名
         */
        public PropertyName<Date> kakuteiDt() {
            return new PropertyName<Date>(this, "kakuteiDt");
        }
    }
}