package com.shopping.cloud.common.exception;


import com.shopping.cloud.common.source.AKResult;

/**
 * <p>类的详细说明</p>
 *
 * @author 朱文彬
 * @version 1.00
 * @dateTime 2017/11/20 12:35
 */
public interface StatusAkResult {

    /**
     * 返回错误状态
     *
     * @return
     */
    String getErrCode();

    /**
     * 返回错误信息
     *
     * @return
     */
    String getErrMsg();

    /**
     * <p>默认方法 error信息</p>
     *
     * @return
     * @dateTime 2017/6/1 12:35
     * @author 朱文彬
     * <p>
     * <p>修改内容说明</p>
     * @dateTime 2017/11/20 12:35
     * @modifyAuthor 朱文彬
     */
    default <T> AKResult info() {
        return new AKResult();
    }
    default <T> AKResult info(String msg) {
        return new AKResult(this, msg);
    }
    default <T> AKResult info(Exception exception) {
        return new AKResult(this, exception.getMessage(),  null);
    }

    default <T> AKResult info(String msg, T data) {
        return new AKResult(this, msg, data);
    }

    default <T> AKResult info(T data) {
        return new AKResult(this, data);
    }
}
