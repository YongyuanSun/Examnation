package demo.wangyi;

import java.util.Scanner;

public class MaxPerfectArray{


	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int T=in.nextInt();
		for(int i=0;i<T;i++){
			int n=in.nextInt();
			int[] arr=new int[n];
			for (int j = 0; j < n; j++) {
				arr[j]=in.nextInt();

			}
			System.out.println(solute(arr));
		}
	}

	private static int solute(int[] arr) {
		if(arr==null||arr.length==0){
			return 0;
		}
		int max=-1;
		int sum=0;
		int count=1;
		for(int i=1;i<arr.length;i++){
			sum+=arr[i-1];
			if(sum<=arr[i]){
				count++;
			}else {
				if(count>max){
					max=count;
				}
				count=1;
				sum=0;
			}
		}
		return max;
	}

}
