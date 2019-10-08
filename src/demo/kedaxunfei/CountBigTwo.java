package demo.kedaxunfei;

import java.util.Scanner;

public class CountBigTwo{
	public static String solute(String strA,String strB){
		if(strA==null||strA.length()==0){
			return strB;
		}
		if(strB==null||strB.length()==0){
			return strA;
		}
		int minLen = Math.min(strA.length(),strB.length());
		int maxLen = Math.max(strA.length(),strB.length());
		int flag = 0;
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<minLen;i++){
			char a = strA.charAt(strA.length()-1-i);
			char b = strB.charAt(strB.length()-1-i);
			int count = new Integer(a-'0')+new Integer(b-'0');

			sb.append(count%10+flag);
			flag = count/10;
		}
		String str;
		if(strA.length()>strB.length()){
			str=strA;
		}else {
			str=strB;
		}
		for(int i=minLen;i<maxLen;i++){
			Integer a = new Integer(str.charAt(str.length() - 1 - i)-'0');
			int count = a+flag;
			sb.append(count%10);
			flag=count/10;
		}
		if(flag==1){
			sb.append(flag);
		}
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String strA = in.next();
			String strB = in.next();
			String res = solute(strA, strB);
			System.out.println(res);
		}
	}
}
