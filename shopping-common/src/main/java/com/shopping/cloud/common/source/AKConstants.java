package com.shopping.cloud.common.source;

/**
 * Created by linyue on 17/11/9.
 */
public class AKConstants {

    /**
     * 每页10条
     */
    public static final int PAGE_SIZE = 10;

    /**
     * 本地IP地址
     */
    public static final String LOCAL_HOST = "127.0.0.1";


    /**
     * 正常
     */
    public static final String STATUS_OK = "1";

    /**
     * 异常
     */
    public static final String STATUS_EX = "0";

    /**
     * success字符串
     */
    public static final String SUCCESS = "success";

    /**
     * 消息关键字
     */
    public final static String MSG_KEY = "message";

    /**
     * 请求成功通用码
     */
    public final static String ERR_OK = "00";

    /**
     * 请求失败通用码
     */
    public final static String ERR_FAIL = "01";

    /**
     * 请求成功通用返回信息
     */
    public final static String ERR_OK_MSG = "执行成功";

    /**
     * 请求失败通用返回信息
     */
    public final static String ERR_FAIL_MSG = "系统繁忙";

    /**
     * 空字符串
     */
    public final static String EMPTY_STRING = "";

    /**
     * redis中存储token的key
     */
    public final static String ACCESS_TOKEN_KEY = "wx.token.";

}
