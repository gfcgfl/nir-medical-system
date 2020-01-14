package com.zju.medical.common.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaoguo
 */
public class UserDataCacheConstant {

    /**
     * 这个用于缓存的map不知道往哪里写了，就先写在这里吧
     * 外层map的key用于区分是哪个用户id
     * 内层map存储了这个用户的缓存信息（包括task和clinical信息）
     */
    public static final Map<String, Map<String, Object>> USER_DATA_CACHE_MAP = new HashMap<>(8, 1);


    /**
     * 缓存两个用户信息  task 和 clinical
     */
    public static final Integer USER_DATA_CACHE_NUM = 2;

    /**
     * 向session中缓存用户数据（task数据和临床数据）时的key （prefix+userId），value为map 存放这用户的task和临床信息
     *
     */
    public static final String CACHE_KEY_PREFIX = "USER_DATA_CACHE:";

    /**
     * map中存放task信息的key
     */
    public static final String CACHE_MAP_KEY_TASK = "task";
    /**
     * map中存放临床信息的key
     */
    public static final String CACHE_MAP_KEY_CLINICAL = "clinical";
}
