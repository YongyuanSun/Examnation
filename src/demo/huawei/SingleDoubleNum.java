package huawei;

import java.util.Scanner;


public class SingleDoubleNum{
	public static boolean solute(String[] arr) {
		//只有0个或一个数
		if(arr.length<=1){
			return true;
		}
		//只有两个数，应该位数不同
		if(arr.length==2){
			return arr[0].length()!=arr[1].length();
		}
		//不止两个数
		int leftLen= arr[0].length();
		int rightLen=arr[arr.length-1].length();
		//最左和最右是两位，中间应该都是一位
		if(leftLen==2&&rightLen==2){
			for (int i=1;i<arr.length-1;i++){
				if (arr[i].length()!=1){
					return false;
				}
			}
			return true;
		}
		//最左和最右是一位，中间应该都是两位
		if(leftLen==1&&rightLen==1){
			for (int i=1;i<arr.length-1;i++){
				if (arr[i].length()!=2){
					return false;
				}
			}
			return true;
		}
		//交替出现
		for(int i=0;i<arr.length-1;i++){
			if(arr[i].length()==arr[i+1].length()){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String[] s = in.nextLine().trim().split(" ");
		System.out.print(solute(s));
		while (in.hasNextLine()){
			s = in.nextLine().trim().split(" ");
			System.out.print(" "+solute(s));
		}
	}
}
