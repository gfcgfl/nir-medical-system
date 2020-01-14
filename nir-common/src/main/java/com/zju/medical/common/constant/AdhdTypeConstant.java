package com.zju.medical.common.constant;

/**
 * @author xiaoguo
 */
public class AdhdTypeConstant {

    /**
     * adhd共有多少个类型
     */
    public static final Integer ADHD_TYPE_TOTAL_COUNT = 4;

    /**
     * 描述adhd类型的枚举类
     */
    public enum AdhdTypeEnum {

        //正常
        ADHD_NORMAL(4, "NORMAL", "正常"),

        //注意缺陷型
        ADHD_I(1, "ADHD_I", "注意缺陷型"),

        //多动冲动型
        ADHD_HI(2, "ADHD_HI", "多动冲动型"),

        //混合型
        ADHD_C(3, "ADHD_C", "混合型");



        /**
         * 类型的标签（用数字表示）
         */
        private Integer label;

        /**
         * 类型的缩写
         */
        private String abbreviation;

        /**
         * 类型的中文名称
         */
        private String chineseName;

        AdhdTypeEnum(Integer label, String abbreviation, String chineseName) {
            this.label = label;
            this.abbreviation = abbreviation;
            this.chineseName = chineseName;
        }

        public Integer getLabel() {
            return label;
        }

        public String getAbbreviation() {
            return abbreviation;
        }

        public String getChineseName() {
            return chineseName;
        }
    }

}
