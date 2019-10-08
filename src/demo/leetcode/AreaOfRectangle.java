package demo.leetcode;

import java.util.Scanner;



public class AreaOfRectangle {



	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		AreaOfRectangle s=new AreaOfRectangle();
		String[] split = in.nextLine().trim().split(",");
		s.computeArea(new Integer(split[0]),new Integer(split[1]),new Integer(split[2]),new Integer(split[3]),
				new Integer(split[4]),new Integer(split[5]),new Integer(split[6]),new Integer(split[7]));
	}
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		if(A==C||B==D){
			return Area(E,F,G,H);
		}
		if(E==G||F==H){
			return Area(A,B,C,D);
		}
		int a=Area(A,B,C,D)+Area(E,F,G,H)-coverArea(A,B,C,D,E,F,G,H);
		return a;
	}

	private int coverArea(int a, int b, int c, int d, int e, int f, int g, int h) {
		long l_x=Math.max(a,e);
		long d_y=Math.max(b,f);
		long r_x=Math.min(c,g);
		long u_y=Math.min(d,h);
		long dx=r_x-l_x;
		long dy=u_y-d_y;
		if(dx>0&&dy>0){
			int x=(int)dx;
			int y=(int)dy;
			return x*y;
		}
		return 0;
	}

	private int Area(int e, int f, int g, int h) {

		return Math.abs((g-e)*(h-f));
	}
}

