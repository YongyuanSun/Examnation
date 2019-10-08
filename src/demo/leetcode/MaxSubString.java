package demo.leetcode;

import java.util.Scanner;

public class MaxSubString {
	private static int solute(String str1,String str2){
		if(str1==null||str1.length()==0||str2==null||str2.length()==0){
			return 0;
		}
		int[][] count = new int[str1.length()][str2.length()];
		int[] res = new int[str1.length()];
		int max;
		for(int i=0;i<str1.length();i++){
			max = 0;
			for(int j=0;j<str2.length();j++){
				//两条边初始化
				if(i==0||j==0){
					count[i][j]=str1.charAt(i)==str2.charAt(j)?1:0;
				}else{
					//当前的最大长度为前一个元素的最大长度加当前元素相等
					count[i][j]=str1.charAt(i)==str2.charAt(j)?count[i-1][j-1]+1:0;
				}
				//记录当前行的最大长度
				if(count[i][j]>max){
					max=count[i][j];
				}
			}
			res[i]=max;
		}
		max=0;
		//比较每行的最大值
		for(int i:res){
			if(i>max){
				max=i;
			}
		}
		return max;
	}
	public static void main(String[] args){
		System.out.println(solute("abcabc",""));;
	}
}