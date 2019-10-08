package demo;

import java.util.Scanner;


public class TwoBigIntMergeIntoOneSmall{
	public static String solute(String str1, String str2) {
		if(str1==null||str1.length()==0){
			return str2;
		}
		if(str2==null||str2.length()==0){
			return str1;
		}
		if(str1.equals("0")){
			return str2;
		}
		if(str2.equals("0")){
			return str1;
		}
		StringBuffer sb=new StringBuffer();
		int a=str1.length()-1;
		int b=str2.length()-1;
		while (a>=0&&b>=0){
			char c1=str1.charAt(a);
			char c2=str2.charAt(b);
			if(c1>c2){
				sb.append(c1);
				a--;
			}else if(c1<c2){
				sb.append(c2);
				b--;
			}else {
				if(isABigger(str1,str2,a-1,b-1)){
					sb.append(c1);
					a--;
				}else {
					sb.append(c2);
					b--;
				}
			}
		}
		while (a>=0){
			sb.append(str1.charAt(a--));
		}
		while (b>=0){
			sb.append(str2.charAt(b--));
		}
		return sb.reverse().toString();
	}

	private static boolean isABigger(String str1, String str2, int a, int b) {
		if(a<0&&b<0){
			return true;
		}
		if(a<0){
			return isABigger(str1,str2,a,b-1);
		}
		if(b<0){
			return isABigger(str1,str2,a-1,b);
		}
		if(str1.charAt(a)==str2.charAt(b)){
			return isABigger(str1,str2,a-1,b-1);
		}
		return str1.charAt(a)>str2.charAt(b);
	}

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);

		while (in.hasNext()){
			System.out.println(solute(in.next(),in.next()));
		}
	}
}
