/**
 * 
 */
package com.shopping.cloud.common.userTab;

import java.math.BigDecimal;

/**
 * <p>常量类</p>
 * @dateTime 2017年11月9日 上午9:43:56
 * @author 朱文彬
 * @version 1.00
 */


public class Constant {
	/**
	 * @标识
	 */
	public static String EMAIL_LOGO = "@";

	/**
	 * session的登录过期时间
	 */
	public static Integer SESSION_TIME = 60*60*24*30;

	/**
	 * 成功
	 */
	public static String SUCCESS = "成功";

	/**
	 * 用户状态 正常
	 */
	public static Integer USERSTATUS_U = 1;

	/**
	 * 用户认证状态
	 */
	public static Integer AUTH_INITIAL_SATE = 0;

	/**
	 * 登陆锁定前缀key
	 */
	public static String USER_LOGIN_KEY = "userLogin";

	/**
	 * 短信调用次数初始值
	 */
	public static String MESSAGE_INITIAL_VALUE = "1";

	/**
	 * 短信调用错误次数过期时间
	 */
	public static Integer MESSAGE_TIME = 60*60*60;

	/**
	 * 图形验证码过期时间
	 */
	public static Integer PICTURE_OVER_TIME = 60;
	public static String REGIS_RED_PACKET = "REGIS_RED_PACKET";
	public static String REFERRER_RED_PACKET = "REFERRER_RED_PACKET";
	public static Integer REGIS_RED_COUNT = 100;

	public static Integer PHONE_TIME = 1;

	public static String DATE_TYPE = "yyyy-MM-dd";

	public static String IOS_TYPE = "IOS";

	public static String WEB_TYPE = "web";

	public static String ANDROID_TYPE = "android";

	public static Integer REG_SOURCE_ANDROID = 1;

	public static Integer REG_SOURCE_IOS = 2;

	public static Integer REG_SOURCE_WEIXIN = 3;

	public static Integer REG_SOURCE_OTHER = 4;
	public static final String COMMONS_EMAIL_CODE = "您的验证码是${code}，请勿向任何人提供您收到的邮件验证码，并在5分钟内完成验证。【乐富购】";
	public static final String CODE_PREFIX = "VC:";

	public static final String BACK_SESSION_ID="backSessionId";
	public static final String EMAILURL="members/email";

	public static final Integer IS_DELETE=1;


	public static final BigDecimal CHANNEL_PROPORTION = BigDecimal.valueOf(0.4);//渠道商比例
	public static final BigDecimal CHANNEL_CENTRE_PROPORTION = BigDecimal.valueOf(0.05);//渠道局间比例

	public static final BigDecimal CATY_PROPORRTION = BigDecimal.valueOf(0.25);//市代理
	public static final BigDecimal DISTRICT_PROPORRTION = BigDecimal.valueOf(0.20);//区代理
	public static final BigDecimal CATY_CENTRE_PROPORTION = BigDecimal.valueOf(0.05);//市代理居间比例
	public static final BigDecimal COUNTRY_CENTRE_PROPORTION = BigDecimal.valueOf(0.03);//区代理居间比例



	public static final Integer FREEZE = 0;//冻结
	public static final Integer UNFREEZE = 1;//解冻

	public static final Integer PAGESIZE = 100;//分页
	public static final Integer STATUS_EFFECT = 1;//分页
	public static final Integer FREEZE_PROPORTION = 1;//冻结佣金
	public static final Integer UNFREEZE_PROPORTION = 2;//解冻佣金

	public static final Integer AFTER_SALES_CANCEL = 2;//售后取消

	public static final Integer AFTER_SALES_BACK = 3;//售后退回

	public static final Integer EMAIL_VERIFICATION_CODE_OVER_TIME = 60*5;//邮箱验证码过期时间

	public static final Integer USER_POINT_DETAIL_STATUS=1; //积分或乐福油明细状态 可用
	public static final Integer USER_LOVEU=100; //积分或乐福油明细状态 可用

	public static final Integer SINGLE_TYPE = 1;//商品类型
}
