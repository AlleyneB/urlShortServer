package com.alleyne.utils;

public class NumConverter {
	public static String tableString = "*abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	public static char[] table = tableString.toCharArray();
	/**
	 * 十进制int至62进制字符串
	 * @param 十进制num
	 * @return
	 */
	public static  String _10To62(int num){
		StringBuilder sb = new StringBuilder();
		int rest = num;
		int quotient;//商
		while(rest != 0){
			quotient = (int) (rest%62);
			rest = rest/62;
			sb.append(table[quotient]);
		}
		return sb.toString();
	}
	/**
	 * 62进制字符串至10进制int
	 * @param 62进制str
	 * @return
	 */
	public static int _62To10(String str){
		int value = 0;
		char[] chars = str.toCharArray();
		for(int i=0; i<chars.length; i++){
 			value += tableString.indexOf(String.valueOf(chars[i]))*Math.pow(62, i);
		}
		return value;
	}
}
