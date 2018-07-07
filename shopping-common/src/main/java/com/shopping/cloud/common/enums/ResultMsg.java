package com.shopping.cloud.common.enums;


import com.shopping.cloud.common.exception.StatusAkResult;

/**
 * <p>基本状态信息</p>
 * @dateTime 2017/6/1 11:49
 * @author lcc
 * @version 1.00
 */
public enum ResultMsg implements StatusAkResult {
	SUCCESS("1","成功"),
	FAIL("0","失败"),
	EXCEPTION("-1","异常"),
	LOGIN_ERROR("-2","请重新登录"),

	/**
	 * 系统错误  01000
	 */
	HTTP_PARAM_ERROR("1000","参数错误"),
	HTTP_ACCOUNT_EXCEPTION("1001","调用账户积分异常"),
	BUSINESS_PARAM_ASSERT_ERROR("1002","业务逻辑验证参数错误"),
	REDIS_KEY_NORMATIVE_ERROR("1003","redis的key规范错误,"),
	COMMON_FILE_FOLDER_RE_NAME("1004","文件夹重名"),
	COMMON_FILE_FOLDER_PARENT_INEXISTENCE("1004","父文件夹不存在"),
	COMMON_FILE_FOLDER_MOST_LEVEL("1005","最多只能创建5级文件夹"),
	COMMON_FILE_FOLDER_INEXISTENCE("1006","文件夹不存在"),
	COMMON_FILE_UPLOAD_IO_EXCEPTION("1007","IO异常"),
	COMMON_FILE_INEXISTENCE("1008","文件不存在"),
	INDEX_UPDATE_ERROR("1100","索引更新错误"),
	INDEX_QUERY_ERROR("1101","索引查询错误"),

	/**
	 * HTTP STATUS CODE
	 */
	HTTP_STATUS_CODE_400("400","Bad Request"),
	HTTP_STATUS_CODE_405("405","Method Not Allowed"),
	HTTP_STATUS_CODE_415("415","Unsupported Media Type"),
	HTTP_STATUS_CODE_500("500","Internal Server Error"),


	/**
	 * 订单中心20000-29999
	 */
	ORDER_WXCHATPAYH5_ERROR("20000","获取微信H5预支付信息失败"),
	ORDER_WXCHATPAYAPP_ERROR("20001","获取微信APP预支付信息失败"),
	ORDER_GETOPENID_ERROR("20002","获取微信OPENID失败"),
	ORDER_GETCODE_ERROR("20003","获取微信CODE失败"),
	ORDER_VERIFYSIGN_ERROR("20004","验证签名失败"),
	ORDER_DOXML_ERROR("20005","解析xml数据失败"),
	ORDER_ORDERNO_NULL("20006","订单编号为空"),
	ORDER_ORDERINFO_NULL("20007","未查询到订单信息"),
	ORDER_CONSIGNADDRESSID_NULL("20008","收货地址不能为空"),
	ORDER_PRODUCT_NULL("20009","产品不存在"),
	ORDER_INVENTORY_NULL("20011","无法取得库存信息"),
	ORDER_INVENTORY_NO_EN("20010","库存不足"),
	ORDER_NO_FREIGHT_TEMPLATE("20013","无法找到运费模版"),
	ORDER_NO_USER("20014","无法获得用户信息"),




	/**
	 * 用户中心30000-39999
	 */
	USER_PHONE_ISNULL("30000","手机号为空") ,
	USER_PHONE_FORMAT_ERROR("30001","手机格式错误"),
	USER_EXIST("30002","手机已被注册，直接去登录吧"),
	USER_NO_PASSWORD("30003","请输入密码"),
	USER_PASSWORD_FORMAT_ERROR("30004","密码由6-20位字母、数字或下划线组成！"),
	USER_REGISTER_ERROR("30005","注册失败"),
	USER_NO_EXIST("30006","用户不存在"),
    USER_APPLYF_ORDISTRIBUTOR_ERROR("30007","用户申请渠道商失败"),
    USER_AUTHCODE("30008","短信验证码不正确"),
	USER_ACCOUNT_PASSWORD_ERROR("30009","密码错误"),
	USER_ISLOCKED("30010","您已输错5次密码。账号已被锁定。解锁剩余时间"),
	USER_WILL_LOCKED("30011","密码输错5次将会锁定账号30分钟\n您还有") ,
    USER_PICTURECODE("30012","图片验证码不正确"),
	USER_NOT_LOGIN("30013","您暂未登录"),
	USER_MODIFY_ERROR("30014","用户修改失败"),
	USER_EMAIL_EXIST("30015","邮箱已被注册,直接登录吧"),
	USER_EMAIL_ISNULL("30016","邮箱为空"),
	USER_EMAIL_FORMAT_ERROR("30017","邮箱格式错误"),
	USER_EMAIL_OLD_PASSWORD("30018","老密码错误"),
	USER_EMAIL_OLD_NEW_PASSWORD("30019","老密码或新密码为空"),
	USER_EMAIL_PASSWORD("30020","密码为空"),
	USER_EMAIL_AUTHCODE("30021","邮件验证码不正确"),
	USER_BACK_BROKERAGE_TRANSACTION_ERROR("30022","退还佣金失败"),
	USER_LOGISTICINFO("30023","快递单号不能为空"),
	USER_APPLY_DISTRIBUTOR_REPEAT("30024","请不要重复申请"),
	USER_GET_REDIS_MESSAGE_FAIL("30025","从redis中获取用户信息失败"),
	USER_MESSAGE_NOT_COMPLETE("30026","申请失败资料填写不完整"),
	USER_ID_CARD_FORMAT_FAIL("30027","身份证格式不正确"),
	USER_AUTH_CHECKING("30028","用户正在实名认证中，请勿重复提交"),
	USER_AUTH_SUCCESS("30029","您已实名认证成功，请勿重复提交"),
	USER_STATE_FREEZE("30030","该账户已被冻结"),
	USER_STATE_LOCK("30031","该账户已被锁定"),
	USER_AUTH_STATE("30032","请不要重复申请"),
	USER_AGENT_INFO("30033","您已经是代理商了，请不要重复提交"),
	USER_LOGISTICS("30034","物流信息已存在"),
	USER_NOT_AGENT("30035","该用户不是代理商"),
	USER_NOT_DISTRIBUTOR("30036","该用户不是渠道商");


	/**
	 * 状态
	 */
	private   String errCode;
	/**
	 * 状态描述
	 */
	private String errMsg;

	 ResultMsg(String errCode, String errMsg) {
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	public ResultMsg setMsg(String msg) {
		this.errMsg = msg;
		return this;
	}

	public String getErrCode() {
		return this.errCode;
	}

	public String getErrMsg() {
		return this.errMsg;
	}
}
