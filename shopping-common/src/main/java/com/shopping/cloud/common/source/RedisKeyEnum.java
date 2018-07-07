package com.shopping.cloud.common.source;

import org.apache.commons.lang.StringUtils;

/**
 *<p>redis key 规范定义
 * 中心:模块:业务
 * </p>
 * @dateTime 2017/7/3 12:33
 * @author 朱文彬 zhuwb@lovego.com
 * @version 1.00
 */
public enum RedisKeyEnum {
    /**
     * 代理商开头
     */
    AGENT("agent:"),
    /**
     * ERP用户
     */
    USER_ERP_SESSION("user:erp:session:"),
    /**
     * 前端用户
     */
    USER_FRONT_SESSION("user:front:session:"),
    /**
     * 商品
     */
    PRODUCT("product:"),
    /**
     * 分类
     */
    CATEGORY("category:"),
    /**
     * 品牌
     */
    BRAND("brand:"),
    /**
     * 运费模板
     */
    FREIGHT_TEMPLATE("FreightTemplate"),
    /**
     * 标签
     */
    LABEL("label"),
    /**
     * 购物车
     */
    SHOPPRINGCAR("SHOPPING_CAR_NEW:"),
    /**
     * 订单
     */
    ORDER("order:"),
    /**
     * 验证码
     */
    CODE("code:")
    ;

    private final String  prefix;

    RedisKeyEnum(String prefix) {
        this.prefix = prefix;
    }

    public String key(String suffix){
       return this.prefix+suffix;
    }

    /**
     * 验证前缀
     * @param vaildPrefixStr
     * @return
     */
    public boolean validPrefix(String vaildPrefixStr){
        return StringUtils.equals(this.prefix,vaildPrefixStr);
    }

}
