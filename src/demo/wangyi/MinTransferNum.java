package demo.wangyi;

import java.util.Scanner;

/**
 * A<B,每次可以使A=A+p,或p=p*q,使用最少次数使得A>=B.
 */
public class MinTransferNum {



	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		for (int i = 0; i < t; i++) {
			long A=in.nextInt();
			long B=in.nextInt();
			long p=in.nextInt();
			int q=in.nextInt();
			System.out.println(solute(A,B,p,q));
		}
	}

	private static int solute(long a, long b, long p, int q){
		if(a>=b){
			return 0;
		}
		return soluteAB(a,b,p,q);
	}
	private static int soluteAB(long a, long b, long p, int q) {
		if(a+p>=b){
			return 1;
		}
		return 1+Math.min(solute(a+p,b,p,q),solute(a,b,p*q,q));
	}
}

