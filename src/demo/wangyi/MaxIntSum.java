package demo.wangyi;

import java.util.Scanner;


public class MaxIntSum{


	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int T=in.nextInt();
		for(int i=0;i<T;i++){
			System.out.println(solute(in.nextInt()));
		}
	}

	private static String solute(int x) {
		if(x<=0){
			return 0+"";
		}
		StringBuffer sb=new StringBuffer();
		while (x>0){
			if(x>9){

				sb.append(9);
			}else {
				sb.append(x);
			}
			x-=9;
		}
		return sb.reverse().toString();
	}
}
