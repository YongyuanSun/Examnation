package demo;

import java.util.Scanner;

/**
 * 找到长度大于m的和最小的一组数，返回最小和
 */

public class MinSumLenMoreM{
	public static int solute(int[] arr,int m) {
		if(arr==null||arr.length==0||arr.length<m){
			return 0;
		}
		int[] sum=new int[arr.length+1];
		sum[0]=0;

		for (int i = 1; i < arr.length+1; i++) {
			sum[i]=sum[i-1]+arr[i-1];
		}
		int min=Integer.MAX_VALUE;
		int sumMax=Integer.MIN_VALUE;
		for(int i=0;i<arr.length+1-m;i++){
			sumMax=Math.max(sumMax,sum[i]);
			if(sum[i+m]-sumMax<min){
				min=sum[i+m]-sumMax;
			}
		}
		return min;
	}

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		while (in.hasNextInt()){
			int n=in.nextInt();
			int m=in.nextInt();
			int[] arr=new int[n];
			for (int i = 0; i < n; i++) {
				arr[i]=in.nextInt();
			}
			System.out.println(solute(arr,m));
		}
	}
}
