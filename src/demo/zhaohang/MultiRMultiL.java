package demo.zhaohang;

import java.util.Scanner;
class MultiRMultiL{
	public static String solute(String str){
		if(str==null||str.length()==0){
			return"";
		}
		int[] nums = new int[str.length()];
		for(int i=0;i<str.length();i++){
			Character c=str.charAt(i);
			if(c.equals('R')){
				int index = findFirstL(str,i);
				if((index-i)%2==0){
					nums[index]++;
				}else {
					nums[index-1]++;
				}
			}else if(c.equals('L')) {
				int index = findFirstR(str,i);
				if((i-index)%2==0){
					nums[index]++;
				}else {
					nums[index+1]++;
				}
			}
		}
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<nums.length-1;i++){
			sb.append(nums[i]+" ");
		}
		sb.append(nums[nums.length-1]);
		return sb.toString();
	}

	private static int findFirstR(String str, int i) {
		while (str.charAt(i)!='R'){
			i--;
		}
		return i;
	}

	private static int findFirstL(String str,int i) {
		while (str.charAt(i)!='L'){
			i++;
		}
		return i;
	}


	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		while (in.hasNextLine()){
			System.out.println(solute(in.nextLine()));
		}

	}
}
