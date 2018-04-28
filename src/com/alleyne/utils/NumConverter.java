package com.alleyne.utils;

public class NumConverter {
	public static String tableString = "*abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	public static char[] table = tableString.toCharArray();
	/**
	 * ʮ����int��62�����ַ���
	 * @param ʮ����num
	 * @return
	 */
	public static  String _10To62(int num){
		StringBuilder sb = new StringBuilder();
		int rest = num;
		int quotient;//��
		while(rest != 0){
			quotient = (int) (rest%62);
			rest = rest/62;
			sb.append(table[quotient]);
		}
		return sb.toString();
	}
	/**
	 * 62�����ַ�����10����int
	 * @param 62����str
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
