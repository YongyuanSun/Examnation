package demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		if (nums.length < 3) {
			return new ArrayList<>();
		}
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < nums.length - 2; i++) {
			//去重
			while (i > 0 && i < nums.length && nums[i] == nums[i - 1]) {
				i++;
			}
			int cur = i;
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				//left右移
				while (left < right && (nums[cur] + nums[left] + nums[right]) < 0) {
					left++;
				}
				while (left < right && (nums[cur] + nums[left] + nums[right]) == 0) {
					ArrayList<Integer> list = new ArrayList<>();
					list.add(nums[cur]);
					list.add(nums[left]);
					list.add(nums[right]);
					res.add(list);
					left++;
					while (left < nums.length && nums[left] == nums[left - 1]) {
						left++;
					}
				}
				//right左移
				while (left < right && (nums[cur] + nums[left] + nums[right]) > 0) {
					right--;
				}
			}

		}
		return res;
	}

	public static void main(String[] args) {
		ThreeSum s = new ThreeSum();
		List<List<Integer>> lists = s.threeSum(new int[]{-1, 0, 2, 1, -1, -4});
		for (List l : lists) {
			System.out.println(Arrays.toString(l.toArray()));
			;
		}

	}
}
