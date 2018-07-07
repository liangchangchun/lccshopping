package com.shopping.cloud.common.helper;

import java.util.Random;
import java.util.regex.Pattern;


/**
 * 
 * <p>公共工具类</p>
 * @dateTime 2017年6月21日 下午6:38:06 
 * @author 蒋磊  jiangl@lovego.com 
 * @version 1.00
 */
/**
 * 
 * <p>CommonUtil<p>
 * @dateTime 2017年6月27日 下午2:23:46
 * @author Administrator
 * @param 
 * @return
 */
public class CommonUtil {
	
	/**
	 * 
	 * <p>获取随机字符串</p>
	 * @dateTime 2017年6月21日 下午6:32:08 
	 * @author 蒋磊  jiangl@lovego.com
	 *
	 * <p>修改内容说明</p>
	 * @modifyAuthor 蒋磊  jiangl@lovego.com
	 * @dateTime 2017年6月21日 下午6:32:08 
	 * @param length
	 * @return
	 */
	public static String getRandomStr(int length){
		
		String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	    Random random = new Random();
	    StringBuffer sb = new StringBuffer();
	    for (int i = 0; i < length; i++) {
	        int number = random.nextInt(base.length());
	        sb.append(base.charAt(number));
	    }
	    return sb.toString();
	}
	
	/**
	 * <p>生成双层加密密码</p>
	 * @dateTime 2017年6月22日 下午19:20:08 
	 * @author zhuwb zhuwb@lovego.com
	 * @param passWord
	 * @return
	 */
	public static String getEncryptPassWord(String passWord,Long sort){
		String md5PassWord = MD5.encode(passWord);
		String sortPassWord = MD5.encode(sort+md5PassWord);
		return sortPassWord;
	}

	public static String getEncryptPassWord(String passWord){
		String sortPassWord = MD5.encode(passWord);
		return sortPassWord;
	}
	
	
	/**
	 * 生成6位随机数字
	 * @author zhuwb
	 * @return
	 */
	public static Long getSixRandomNum(){
		StringBuilder str=new StringBuilder();//定义变长字符串
		Random random=new Random();
		//随机生成数字，并添加到字符串
		for(int i=0;i<6;i++){
		    str.append(random.nextInt(10));
		}
		//将字符串转换为数字并输出
		Long num=Long.parseLong(str.toString());
	    return num;
	}
	
	/**
     * <p>校验密码只能是6到20位的字符、数字、子母</p>
     * @dateTime 2017/6/22 15:08
     * @author zhuwb zhuwb@lovego.com
     * @param passWord
     * @return
     */
    public static boolean checkPassWord(String passWord){
    	 String regex = "^([A-Z]|[a-z]|[0-9]|[_]){6,20}$";
    	 return Pattern.matches(regex,passWord);
    }
    
	/**
	 * *描述：6到16位字母、数字、下划线任意组合
	 * @date 2017/8/18
	 * @author 农崇卫  nongcw@lovego.com 
	 * @version 0.1.0
	 * @param passWord
	 * @return
	 */
	public static boolean checkPassWordFormat(String passWord){
		String regex = "^[_0-9a-z]{6,16}$";
		return Pattern.matches(regex,passWord);
	}

	/**
	 * *描述：9位随机数拼接字符串
	 * @date 2017/8/16
	 * @author 农崇卫  nongcw@lovego.com 
	 * @version 0.1.0
	 * @return
	 */
	public static String get9Num(){
		int r1=(int)(Math.random()*(10));
		int r2=(int)(Math.random()*(10));
		int r3=(int)(Math.random()*(10));
		int r4=(int)(Math.random()*(10));
		int r5=(int)(Math.random()*(10));
		int r6=(int)(Math.random()*(10));
		int r7=(int)(Math.random()*(10));
		int r8=(int)(Math.random()*(10));
		int r9=(int)(Math.random()*(10));
		return String.valueOf(r1)+String.valueOf(r2) +
				String.valueOf(r3)+String.valueOf(r4) +
				String.valueOf(r5)+String.valueOf(r6) +
				String.valueOf(r7)+String.valueOf(r8) + String.valueOf(r9);
	}

	/**
	 * *描述：生成随机数字和字母
	 * @date 2017/8/16
	 * @author 农崇卫  nongcw@lovego.com 
	 * @version 0.1.0
	 * @param length
	 * @return
	 */
	public static String getStringRandom(int length) {
		String val = "";
		Random random = new Random();
		//参数length，表示生成几位随机数
		for(int i = 0; i < length; i++) {
			String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
			//输出字母还是数字
			if( "char".equalsIgnoreCase(charOrNum) ) {
				//输出是大写字母还是小写字母
				int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
				val += (char)(random.nextInt(26) + temp);
			} else if( "num".equalsIgnoreCase(charOrNum) ) {
				val += String.valueOf(random.nextInt(10));
			}
		}
		return val;
	}
	
}
