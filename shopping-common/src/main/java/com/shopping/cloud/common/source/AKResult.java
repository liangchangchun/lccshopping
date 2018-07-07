package com.shopping.cloud.common.source;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;
import com.shopping.cloud.common.exception.StatusAkResult;
import com.shopping.cloud.common.helper.StringHelper;
import com.shopping.cloud.common.utils.JsonUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang.StringUtils;

import java.util.Collection;

@ApiModel("返回结果")
public class AKResult {

	/**
	 * 00 代表成功
	 * 01 代表失败
	 */
	@ApiModelProperty("失败时的失败码")
	private String errCode; //失败时的失败码（只有在失败的时候才会设置）

    @ApiModelProperty("错误原因")
	private String errMsg; //错误原因

    @ApiModelProperty("附加数据")
	private Object data; //附加数据

	public AKResult() {
	}

	public AKResult(StatusAkResult statusResult){
		this(statusResult, null, null);
	}

	public AKResult(StatusAkResult statusResult, String msg){
		this(statusResult, msg, null);
	}

	public AKResult(StatusAkResult statusResult, Object data){
		this(statusResult, null, data);
	}

	public AKResult(StatusAkResult statusResult, String msg,  Object data){
		this.errCode= statusResult.getErrCode();
		this.errMsg= StringUtils.defaultIfBlank(msg, statusResult.getErrMsg());
		this.data=data;
	}

	public static AKResult builder(){ 
		return new AKResult();
	}
	
	
	public AKResult successResult() {
		this.errCode = AKConstants.ERR_OK;
		this.errMsg = AKConstants.ERR_OK_MSG;
		return this;
	}
	
	public AKResult successResult(Object d) {
		this.errCode = AKConstants.ERR_OK;
		this.errMsg = AKConstants.ERR_OK_MSG;
		this.data = d;
		return this;
	}
	
	public AKResult failResult() {
		this.errCode = AKConstants.ERR_FAIL;
		this.errMsg = "执行失败";
		return this;
	}
	
	public AKResult failResult(String msg) {
		this.errCode = AKConstants.ERR_FAIL;
		this.errMsg = msg;
		return this;
	}

	/**
	 * 设置返回码
	 * @return
	 */
	public AKResult ok(){
		this.errCode = AKConstants.ERR_OK;
		return this;
	}

	/**
	 * 设置返回码
	 * @return
	 */
	public AKResult fail(){
		this.errCode = AKConstants.ERR_FAIL;
		return this;
	}

	/**
	 * 设置返回码
	 * @param errCode
	 * @return
	 */
	public AKResult fail(String errCode){
		this.errCode = errCode;
		return this;
	}


	/**
	 * 设置返回结果
	 * @param errMsg
	 * @return
	 */
	public AKResult errMsg(String errMsg){
		this.errMsg = errMsg;
		return this;
	}

	/**
	 * 设置返回数据
	 * @return
	 */
	public AKResult data(Object data){
		this.data = data;
		return this;
	}

	/**
	 * 构建返回值 (ID不会过滤)
	 * @return
	 */
	public String build2(){
		if (Strings.isNullOrEmpty(this.errCode)){
			this.errCode = AKConstants.ERR_FAIL;
		}
		if (Strings.isNullOrEmpty(this.errMsg)){
			if (this.errCode == AKConstants.ERR_OK){
				this.errMsg = AKConstants.ERR_OK_MSG;
			}
			if (this.errCode == AKConstants.ERR_FAIL){
				this.errMsg = AKConstants.ERR_FAIL_MSG;
			}
		}
		if (this.data == null){
			this.data = new JSONObject();
		}
		return JSONObject.toJSONString(this);
	}


	/**
	 * 构建返回值
	 * @return
	 */
	public String build(){
		if (Strings.isNullOrEmpty(this.errCode)){
			this.errCode = AKConstants.ERR_FAIL;
		}
		if (Strings.isNullOrEmpty(this.errMsg)){
			if (this.errCode == AKConstants.ERR_OK){
				this.errMsg = AKConstants.ERR_OK_MSG;
			}
			if (this.errCode == AKConstants.ERR_FAIL){
				this.errMsg = AKConstants.ERR_FAIL_MSG;
			}
		}
		if (this.data == null){
			this.data = new JSONObject();
		}
		return StringHelper.toJSONString(this);
	}

	/**
	 * 获取映射的对应
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	public <T> T  getObj(Class<T> clazz){
		if (data != null){
			return JsonUtils.fromJson(JsonUtils.toJson(data),clazz);
		}
		return null;
	}

	/**
	 * 获取映射后的对象集合
	 * @param collectionClass
	 * @param elementClass
	 * @param <L>
	 * @param <E>
	 * @return
	 */
	public  <L extends Collection<E>, E> L getListObj(Class<L> collectionClass, Class<E> elementClass){
		if (data != null){
			return JsonUtils.fromJson(JsonUtils.toJson(data),collectionClass,elementClass);
		}
		return null;
	}



	public String getErrCode() {
		return errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public Object getData() {
		return data;
	}

	public boolean success(){
		return this.errCode!=null&&this.errCode.equals("00");
	}
}
