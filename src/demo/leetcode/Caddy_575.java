package demo.leetcode;

import java.util.HashSet;
import java.util.Set;

class Caddy_575 {
	public int distributeCandies(int[] candies) {
		if(candies==null||candies.length==0){
			return 0;
		}
		Set<Integer> set=new HashSet<>();
		for(int i=0;i<candies.length;i++){
			set.add(candies[i]);
		}
		int sum=candies.length/2;
		int res=0;
		return Math.min(sum,set.size());
	}

	public static void main(String[] args) {

	}

}
