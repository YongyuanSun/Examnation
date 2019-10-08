package xiecheng;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MinTime {


	/*请完成下面这个函数，实现题目要求的功能
	当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
	******************************开始写代码******************************/
	static int schedule(int m,int[] array) {
		int count = 0;
		int avg = 0;
		for(int i:array){
			count+=i;
		}
		avg = count/m;
		System.out.println(avg);
		int res=-1;
		for(int i=avg;i<count;i++){
			if(solute(m,array,i)){
				res=i;
				break;
			}
		}

		return res;
	}

	private static boolean solute(int m, int[] array, int n) {
		int count =0;
		int res=0;
		for(int i=0;i<array.length;i++){
			res+=array[i];
			if(res>n){
				count++;
				res=0;
				i--;
			}
		}
		return count<=m;
	}

	/******************************结束写代码******************************/


	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int size  = in.nextInt();
		int[] array = new int[size];
		for(int i = 0; i < size; i++) {
			array[i] = in.nextInt();
		}
		int res = schedule(m,array);
		System.out.println(String.valueOf(res));
	}
}

