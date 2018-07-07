package com.shopping.cloud.common.helper;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 短信工具类
 *
 * @author 34861
 * @create 2017-11-13 16:03
 */
public class SMSUtil {

    /**
     *  发送短信验证码
     * @param url
     * @param account
     * @param pswd
     * @param mobile
     * @param content
     * @return
     */
    public static String send(String url,String account,String pswd,String mobile,String content){
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("account", account));
        params.add(new BasicNameValuePair("pswd", pswd));
        params.add(new BasicNameValuePair("mobile", mobile));
        params.add(new BasicNameValuePair("msg", content));
        params.add(new BasicNameValuePair("needstatus", "false"));


        return HttpHelper.post(url,params);
    }
}
