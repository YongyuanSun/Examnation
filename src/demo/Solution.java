package demo;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

class Solution {
	public int[] asteroidCollision(int[] asteroids) {
		if(asteroids==null||asteroids.length<2){
			return asteroids;
		}
		Stack<Integer> stack = new Stack<>();
		for(int i=0;i<asteroids.length;i++){
			//栈空直接放入
			if(stack.isEmpty()){
				stack.push(asteroids[i]);
				continue;
			}
			Integer cur = stack.peek();
			if(cur*asteroids[i]<0){
				//方向相反；
				if(cur<0){
					stack.push(asteroids[i]);
				}else {
					//方向相向
					while(Math.abs(cur)<Math.abs(asteroids[i])&&cur*asteroids[i]<0){
						stack.pop();
						if(!stack.isEmpty()){
							cur=stack.peek();
							continue;
						}
						stack.push(asteroids[i]);
						break;
					}
					if(cur*asteroids[i]>0){
						stack.push(asteroids[i]);
					}else if(Math.abs(cur)==Math.abs(asteroids[i])){
						stack.pop();
					}
				}
				//当前重量大就丢弃下一个
			}else {
				//方向相同
				stack.push(asteroids[i]);
			}


		}
		if(stack.isEmpty()){
			return new int[0];
		}
		int[] res=new int[stack.size()];
		int i=stack.size()-1;
		while (!stack.isEmpty()){
			res[i--]=stack.pop();
		}
		return res;
	}

	public static void main(String[] args) {
		int[] arr= new int[]{1,-2,-2,-2};
		Solution s=new Solution();
		System.out.println(Arrays.toString(s.asteroidCollision(arr)));

	}
}