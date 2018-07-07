package com.shopping.cloud.common.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *<p>正则表达式验证工具类</p>
 *<p>验证电话号码,邮编,QQ,E-mail,手机号码,URL,是否为数字,是否为中文,身份证,域名和IP等正则表达式</p>
 * @dateTime 2017/4/17 17:38
 * @author 朱文彬 zhuwb@lovego.com
 * @version 1.00
 */
public class RegexUtils {

    /**
     * <p>验证Email </p>
     * @dateTime 2017/4/17 18:14
     * @author 朱文彬 zhuwb@lovego.com
     * @param email
     * @return
     */
    public static boolean checkEmail(String email) {
        String regex = "\\w+@\\w+\\.[a-z]+(\\.[a-z]+)?";
        return Pattern.matches(regex, email);
    }

    /**
     * <p>验证身份证号码</p>
     * @dateTime 2017/4/17 18:14
     * @author 朱文彬 zhuwb@lovego.com
     * @param idCard
     * @return
     */
    public static boolean checkIdCard(String idCard) {
        String regex = "[1-9]\\d{13,16}[a-zA-Z0-9]{1}";
        return Pattern.matches(regex,idCard);
    }

    /**
     * <p>验证手机号码（支持国际格式，+86135xxxx...（中国内地），+00852137xxxx...（中国香港））</p>
     *<p>移动的号段：134(0-8)、135、136、137、138、139、147（预计用于TD上网卡）、150、151、152、157（TD专用）、158、159、187（未启用）、188（TD专用）</p>
     *<p>联通的号段：130、131、132、155、156（世界风专用）、185（未启用）、186（3g）</p>
     *<p>电信的号段：133、153、180（未启用）、189</p>
     * @dateTime 2017/4/17 18:15
     * @author 朱文彬 zhuwb@lovego.com
     * @param mobile
     * @return
     */
    public static boolean checkMobile(String mobile) {
        String regex = "(\\+\\d+)?1[34578]\\d{9}$";
        return Pattern.matches(regex,mobile);
    }

    /**
     * <p>验证固定电话号码</p>
     * @dateTime 2017/4/17 18:16
     * @author 朱文彬 zhuwb@lovego.com
     * @param phone
     * @return
     */
    public static boolean checkPhone(String phone) {
        String regex = "(\\+\\d+)?(\\d{3,4}\\-?)?\\d{7,8}$";
        return Pattern.matches(regex, phone);
    }

    /**
     * <p>验证整数（正整数和负整数）</p>
     * @dateTime 2017/4/17 18:17
     * @author 朱文彬 zhuwb@lovego.com
     * @param digit
     * @return
     */
    public static boolean checkDigit(String digit) {
        String regex = "\\-?[1-9]\\d+";
        return Pattern.matches(regex,digit);
    }

    /**
     * <p>验证整数和浮点数（正负整数和正负浮点数）</p>
     * @dateTime 2017/4/17 18:17
     * @author 朱文彬 zhuwb@lovego.com
     * @param decimals
     * @return
     */
    public static boolean checkDecimals(String decimals) {
        String regex = "\\-?[1-9]\\d+(\\.\\d+)?";
        return Pattern.matches(regex,decimals);
    }

    /**
     * <p>验证空白字符</p>
     * @dateTime 2017/4/17 18:17
     * @author 朱文彬 zhuwb@lovego.com
     * @param blankSpace
     * @return
     */
    public static boolean checkBlankSpace(String blankSpace) {
        String regex = "\\s+";
        return Pattern.matches(regex,blankSpace);
    }

    /**
     * <p>验证中文</p>
     * @dateTime 2017/4/17 18:17
     * @author 朱文彬 zhuwb@lovego.com
     * @param chinese
     * @return
     */
    public static boolean checkChinese(String chinese) {
        String regex = "^[\u4E00-\u9FA5]+$";
        return Pattern.matches(regex,chinese);
    }

    /**
     * <p>验证日期（年月日）</p>
     * @dateTime 2017/4/17 18:17
     * @author 朱文彬 zhuwb@lovego.com
     * @param birthday
     * @return
     */
    public static boolean checkBirthday(String birthday) {
        String regex = "[1-9]{4}([-./])\\d{1,2}\\1\\d{1,2}";
        return Pattern.matches(regex,birthday);
    }

    /**
     * <p>验证URL地址</p>
     * @dateTime 2017/4/17 18:18
     * @author 朱文彬 zhuwb@lovego.com
     * @param url
     * @return
     */
    public static boolean checkURL(String url) {
        String regex = "(https?://(w{3}\\.)?)?\\w+\\.\\w+(\\.[a-zA-Z]+)*(:\\d{1,5})?(/\\w*)*(\\??(.+=.*)?(&.+=.*)?)?";
        return Pattern.matches(regex, url);
    }

    /**
     * <p>获取网址 URL 的一级域名</p>
     * @dateTime 2017/4/17 18:18
     * @author 朱文彬 zhuwb@lovego.com
     * @param url
     * @return
     */
    public static String getDomain(String url) {
        Pattern p = Pattern.compile("(?<=http://|\\.)[^.]*?\\.(com|cn|net|org|biz|info|cc|tv)", Pattern.CASE_INSENSITIVE);
        // 获取完整的域名
        // Pattern p=Pattern.compile("[^//]*?\\.(com|cn|net|org|biz|info|cc|tv)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(url);
        matcher.find();
        return matcher.group();
    }

    /**
     * <p>匹配中国邮政编码</p>
     * @dateTime 2017/4/17 18:18
     * @author 朱文彬 zhuwb@lovego.com
     * @param postcode
     * @return
     */
    public static boolean checkPostcode(String postcode) {
        String regex = "[1-9]\\d{5}";
        return Pattern.matches(regex, postcode);
    }

    /**
     * <p>匹配IP地址(简单匹配，格式，如：192.168.1.1，127.0.0.1，没有匹配IP段的大小)</p>
     * @dateTime 2017/4/17 18:18
     * @author 朱文彬 zhuwb@lovego.com
     * @param ipAddress
     * @return
     */
    public static boolean checkIpAddress(String ipAddress) {
        String regex = "[1-9](\\d{1,2})?\\.(0|([1-9](\\d{1,2})?))\\.(0|([1-9](\\d{1,2})?))\\.(0|([1-9](\\d{1,2})?))";
        return Pattern.matches(regex, ipAddress);
    }
    
    /**
     * <p>校验密码只能是6到20位的字符、数字、子母</p>
     * @dateTime 2017/6/22 15:08
     * @author zhuwb zhuwb@lovego.com
     * @param passWord
     * @return
     */
    public static boolean checkPassWord(String passWord){
    	 String regex = "^([A-Z]|[a-z]|[0-9]|[`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“'。，、？]){6,20}$";
    	 return Pattern.matches(regex,passWord);
    }

}
