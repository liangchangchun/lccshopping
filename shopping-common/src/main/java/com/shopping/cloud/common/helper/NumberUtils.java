package com.shopping.cloud.common.helper;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Random;
import java.util.UUID;

public class NumberUtils {
	/**
	 * 获取9个随机数组成的字符串
	 *
	 * @return
	 * @Title: get9Num
	 * @Description: TODO
	 * @return: String
	 */
	public static String get9Num() {
		int r1 = (int) (Math.random() * (10));
		int r2 = (int) (Math.random() * (10));
		int r3 = (int) (Math.random() * (10));
		int r4 = (int) (Math.random() * (10));
		int r5 = (int) (Math.random() * (10));
		int r6 = (int) (Math.random() * (10));
		int r7 = (int) (Math.random() * (10));
		int r8 = (int) (Math.random() * (10));
		int r9 = (int) (Math.random() * (10));
		return String.valueOf(r1) + String.valueOf(r2) +
				String.valueOf(r3) + String.valueOf(r4) +
				String.valueOf(r5) + String.valueOf(r6) +
				String.valueOf(r7) + String.valueOf(r8) + String.valueOf(r9);
	}
	
	public static String getRandomNum(int min, int max) {
        return String.valueOf(new Random().nextInt(max - min + 1) + min);
	}
	
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}

	public static String getRandomNum() {
		Double r = Math.random() * 100000;
		return System.nanoTime() + r.longValue() + "";
	}
	
	/**
	 * 是否数字
	 * @param str
	 * @return
	 */
	public static boolean isNum(String str){ 
		return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$"); 
	} 
	
	/**
	 * 对double数据进行取精度.
	 * 
	 * @param value
	 *            double数据.
	 * @param scale
	 *            精度位数(保留的小数位数).
	 * @return 精度计算后的数据.
	 */
	public static double formatNumber(double value, int scale) {
		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(scale, BigDecimal.ROUND_HALF_UP);
		return bd.doubleValue();
	}

	public static void main(String[] args) {
		System.out.println(multiply(1.11,2.69,2));
	}

	/**
	 * 数字转字母
	 * 
	 * @return
	 */
	public static String toLetterString(int number) {
		if (number < 1) {// 出错了
			return null;
		}
		if (number < 27) {
			return String.valueOf((char) ('A' + number - 1));
		}
		if (number % 26 == 0) {
			return toLetterString(number / 26 - 1) + "Z";
		}
		return toLetterString(number / 26)
				+ String.valueOf((char) ('A' + number % 26 - 1));
	}

	/**
	 * 判断是否是数字
	 */
	public static boolean isNumeric(String str) {
		if (str.contains("-") || str.contains("(") || str.contains(")")) {
			str = str.replace("-", "").replace("(", "").replace(")", "");
		}
		String value = "";
		boolean b = true;
		if (str.contains("src/main")) {
			return false;
		} else if (str.substring(str.length() - 1).equals(".")) {
			return false;
		}
		for (int i = 0; i < str.length(); i++) {
			value = str.substring(i, i + 1);
			if (!value.equals(".")) {
				java.text.DecimalFormat nf = new java.text.DecimalFormat(
						"00.00");
				try {
					nf.parse(value);
				} catch (ParseException e1) {
					b = false;
					return b;
				}
			}
		}
		return b;
	}

	/*
	 * 将字符串转为整数
	 */
	public static int toNum_new(String str) {
		char[] ch = str.toCharArray();
		int ret = 0;
		for (int i = 0; i < ch.length; i++) {
			ret *= 26;
			ret += ch2int(ch[i]);
		}
		return ret;
	}
	
	/**
	 * 转换为long
	 * @param obj
	 * @return
	 */
	public static Long toLongNum(Object obj){
		if(obj == null || "".equals(obj.toString())){
			return null;
		}
		return Long.parseLong(obj.toString());
	}
	
	/**
	 * 转换为Double
	 * @param obj
	 * @return
	 */
	public static Double toDouble(Object obj){
		if(obj == null || "".equals(obj.toString())){
			return null;
		}
		return Double.parseDouble(obj.toString());
	}
	
	public static Integer toInteger(Object obj){
		if(obj == null || "".equals(obj.toString())){
			return null;
		}
		return Integer.parseInt(obj.toString());
	}

	/*
	 * A~Z/a~z 转为1~26
	 */
	public static int ch2int(char ch) {
		if (ch >= 'a' && ch <= 'z')
			return ch - 'a' + 1;
		if (ch >= 'A' && ch <= 'Z')
			return ch - 'A' + 1;
		throw new IllegalArgumentException();
	}
	
	/**
	 * null 返回 0 
	 * @param dou
	 * @return
	 */
	public static double getDouble(Double dou){
		return dou == null ? 0 : dou.doubleValue();
	}
	
	/**
	 * null 返回 0 
	 * @param dou
	 * @return
	 */
	public static double getDouble(Object obj){
		return obj == null ? 0 : Double.valueOf(obj.toString());
	}
	
	/**
	 * null 返回 "0" 
	 * @param dou
	 * @return
	 */
	public static String getString(Object dou){
		return dou == null ? "0" : dou.toString();
	}
	
	/**
	 * null 返回 0 
	 * @param dou
	 * @return
	 */
	public static int getInt(Object obj){
		return obj == null ? 0 : Integer.valueOf(obj.toString());
	}
	
	/**
	 * 金额精确计算
	 * 加法
	 */
	public static double add(double v1,double v2){
		BigDecimal b1 = BigDecimal.valueOf(v1);
		BigDecimal b2 = BigDecimal.valueOf(v2);
		return b1.add(b2).doubleValue();
	}
	
	/**
	 * 金额精确计算
	 * 加法
	 */
	public static String add(String v1,String v2){
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.add(b2).toString();
	}
	
	/**
	 * 金额精确计算
	 * 连续加法
	 */
	public static double add(double... v1){
		double res = 0.00d; 
		if(v1 !=null && v1.length > 0){
			BigDecimal b1 = new BigDecimal(v1[0]);
			for (int i = 1; i < v1.length; i++) {
				if(!"".equals(v1[i])){
					b1 = b1.add(new BigDecimal(v1[i]));
				}
			}
			res = b1.doubleValue();
		}
		return res;
	}
	
	/**
	 * 金额精确计算
	 * 连续加法
	 */
	public static String add(String... v1){
		String res = "0.00"; 
		if(v1 !=null && v1.length > 0){
			BigDecimal b1 = new BigDecimal(v1[0]);
			for (int i = 1; i < v1.length; i++) {
				if(!"".equals(v1[i].trim())){
					b1 = b1.add(new BigDecimal(v1[i]));
				}
			}
			res = b1.toString();
		}
		return res;
	}
	
	/**
	 * 金额精确计算
	 * 减法
	 */
	public static double subtract(double v1,double v2){
		BigDecimal b1 = BigDecimal.valueOf(v1);
		BigDecimal b2 = BigDecimal.valueOf(v2);
		return b1.subtract(b2).doubleValue();
	}
	
	/**
	 * 金额精确计算
	 * 减法
	 */
	public static BigDecimal subtractbd(double v1,double v2){
		BigDecimal b1 = BigDecimal.valueOf(v1);
		BigDecimal b2 = BigDecimal.valueOf(v2);
		return b1.subtract(b2);
	}
	
	/**
	 * 金额精确计算
	 * 连续减法,第一个必须为被减数,否则不准
	 */
	public static double subtract(double... v1){
		double res = 0.00d; 
		if(v1 !=null && v1.length > 0){
			BigDecimal b1 = new BigDecimal(v1[0]);
			for (int i = 1; i < v1.length; i++) {
				if(!"".equals(v1[i])){
					b1 = b1.subtract(new BigDecimal(v1[i]));
				}
			}
			res = b1.doubleValue();
		}
		return res;
	}
	
	/**
	 * 金额精确计算
	 * 连续减法,第一个必须为被减数,否则不准
	 */
	public static String subtract(String... v1){
		String res = "0.00"; 
		if(v1 !=null && v1.length > 0){
			BigDecimal b1 = new BigDecimal(v1[0]);
			for (int i = 1; i < v1.length; i++) {
				if(!"".equals(v1[i].trim())){
					b1 = b1.subtract(new BigDecimal(v1[i]));
				}
			}
			res = b1.toString();
		}
		return res;
	}
	
	/**
	 * 金额精确计算
	 * 减法
	 */
	public static String subtract(String v1,String v2){
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.subtract(b2).toString();
	}
	
	/**
	 * 金额精确计算
	 * 乘法
	 */
	public static double multiply(double v1,double v2){
		return multiply(v1,v2,-1);
	}
	
	/**
	 * 金额精确计算
	 * 乘法
	 */
	public static String multiply(String v1,String v2){
		return multiply(v1,v2,-1);
	}
	
	/**
	 * 金额精确计算
	 * 乘法
	 */
	public static String multiply(String v1,String v2,int scale){
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		BigDecimal bd = b1.multiply(b2);
		if(scale >= 0){
			bd = bd.setScale(scale, BigDecimal.ROUND_HALF_UP);
		}
		return bd.toString();
	}
	
	
	/**
	 * 金额精确计算
	 * 乘法
	 */
	public static double multiply(double v1,double v2,int scale){
		BigDecimal b1 = BigDecimal.valueOf(v1);
		BigDecimal b2 = BigDecimal.valueOf(v2);
		BigDecimal bd = b1.multiply(b2);
		if(scale >= 0){
			bd = bd.setScale(scale, BigDecimal.ROUND_HALF_UP);
		}
		return bd.doubleValue();
	}
	
	/**
	 * 金额精确计算
	 * 除法
	 */
	public static double divide(double v1,double v2,int scale){
		if (scale < BigDecimal.ROUND_UP)
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
		BigDecimal b1 = BigDecimal.valueOf(v1);
		BigDecimal b2 = BigDecimal.valueOf(v2);
		return b1.divide(b2,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	/**
	 * 金额精确计算
	 * 除法
	 */
	public static String divide(String v1,String v2,int scale){
		if (scale < BigDecimal.ROUND_UP)
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.divide(b2,scale,BigDecimal.ROUND_HALF_UP).toString();
	}

	
	
	
	public static BigDecimal getBigDecimal(String v1){
		return new BigDecimal(v1);
	}
	
	public static BigDecimal getBigDecimal(Double v1){
		return new BigDecimal(v1);
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
	 *
	 * @param point
	 * @param rate
	 * @return
	 */
	public static long multiplyScaleLong(BigDecimal point, BigDecimal rate) {
		BigDecimal multiply = point.multiply(rate);
		if(multiply.compareTo(BigDecimal.valueOf(1L)) == 1) {
			return multiply.setScale(2, BigDecimal.ROUND_DOWN).longValue();
		} else {
			return 1L;
		}
	}

	public static BigDecimal divideScale(BigDecimal v1, BigDecimal v2, int scale) {
		return v1.divide(v2, scale, BigDecimal.ROUND_DOWN);
	}



	/**
	 * 获取9个随机数组成的字符串
	 *
	 * @return
	 * @Title: get4Num
	 * @Description: TODO
	 * @return: String
	 */
	public static String get4Num() {
		int r1 = (int) (Math.random() * (10));
		int r2 = (int) (Math.random() * (10));
		int r3 = (int) (Math.random() * (10));
		int r4 = (int) (Math.random() * (10));
		return String.valueOf(r1) + String.valueOf(r2) +
				String.valueOf(r3) + String.valueOf(r4) ;
	}

	/**
	 * 补充弄型1 为001
	 * @param number
	 * @return
	 */
	public static String makeFullLength(Integer number,int numberLength){
		String returnNumber = "";
		int zeroNumber = numberLength - number.toString().length();
		for (int i=0 ; i< zeroNumber ; i++) {
			returnNumber += 0;
		}
		return returnNumber + number.toString();
	}


}
