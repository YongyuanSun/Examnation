package demo.zhaohang;


public class BBBCC {
	private static int[][] arr;

	/******************************结束写代码******************************/
	private static int solute(int n){
		arr=new int[n][4];
		arr[0][0] = 1;
		arr[0][1] = 1;
		arr[0][2] = 0;
		arr[0][3] = 1;
		for(int i=1;i<n;i++){
			arr[i][0] = arr[i-1][0]+arr[i-1][1]+arr[i-1][2]+arr[i-1][3];
			arr[i][1] = arr[i-1][0]+arr[i-1][3];
			arr[i][2] = arr[i-1][1];
			arr[i][3] = arr[i-1][0]+arr[i-1][1]+arr[i-1][2];
		}
		return arr[n-1][0]+arr[n-1][1]+arr[n-1][2]+arr[n-1][3];
	}

	public static void main(String[] args){
		int n=10;
		System.out.println(solute(4));
	}
}
