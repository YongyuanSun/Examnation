package demo.leetcode;

import java.util.Arrays;

class FullArrange{
	private static int[] nums;
	public void solute(int num){
		if(num<=0||num>9){
			throw new RuntimeException("参数错误");
		}
		initNums(num);
		sortAndPrint(0);
	}

	private void sortAndPrint(int num) {
		if(num==nums.length-1){
			System.out.println(Arrays.toString(nums));
		}
		for (int i = num; i < nums.length; i++) {
			reverse(num,i);
			sortAndPrint(num+1);
			reverse(i,num);
		}
	}

	private void reverse(int x, int y) {
		int tmp = nums[x];
		nums[x]=nums[y];
		nums[y]=tmp;
	}

	private void initNums(int num) {
		nums = new int[num];
		for(int i = 0;i<num;i++){
			nums[i] = i;
		}
	}

	public static void main(String[] args) {
		FullArrange s = new FullArrange();
		s.solute(4);
	}
}
