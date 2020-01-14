package com.zju.medical.common.pojo.bo;

import lombok.Data;

/**
 * 用于记录  type：count  （记录某种adhd类型的用户数量）
 * @author xiaoguo
 */
@Data
public class AdhdTypeAndCountBO {

    /**
     * type是每种类型的 数字标记
     */
    private Integer type;

    /**
     * type类型 用户的数量
     */
    private Integer count;
}
