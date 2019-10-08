package demo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxSubArraySumEqualsK_325 {
	public static int getMaxLength(int[] arr,int tar){
		if(arr==null||arr.length==0){
			return 0;
		}
		//记录前i个数的和
		int sum=0;
		//记录最大长度
		int maxLen=0;
		//记录最大和和下标位置的映射
		Map<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<arr.length;i++){
			sum+=arr[i];
			//是否在map中找到结果
			if(map.get(sum-tar)!=null){
				maxLen=Math.max(i-map.get(sum-tar),maxLen);
			}
			//map中不存在sum
			if(map.get(sum)==null){
				map.put(sum,i);
			}
		}
		return maxLen;
	}

	public static void main(String[] args) {
		int i = getMaxLength(new  int[]{3, 4, 1, 7, 8}, 115);
		System.out.println(i);
	}
}

