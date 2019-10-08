package demo.cirix;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxPathSum{
//	public static int solute(String str, String pattern) {
//		//转成array
//		char[] sArr = str.toCharArray();
//		char[] pArr = pattern.toCharArray();
//		//求next数组
//		int[] next = getNext(pArr);
//		//两个变量指向两个数组
//		int i=0;
//		int j=0;
//		while (i<sArr.length&&j<pArr.length){
//			//当前匹配就往后移
//			if (j==-1||sArr[i]==pArr[j]){
//				i++;
//				j++;
//			}else {
//				//j往后移动
//				j=next[j];
//			}
//		}
//		//找到
//		if(j==pArr.length){
//			//字符开头
//			return i-j;
//		}
//		return -1;
//				}
//
//private static int[] getNext(char[] pArr) {
//		return new int[0];
//		}
//
//	public static int maxLength(int[] arr, int k) {
//		if (arr == null || arr.length == 0) {
//			return 0;
//		}
//		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//		map.put(0, -1); // 注意，初始值
//		int len = 0;
//		int sum = 0;
//		for (int i = 0; i < arr.length; i++) {
//			sum += arr[i];
//			if (map.containsKey(sum - k)) {
//				len = Math.max(i - map.get(sum - k), len);
//			}
//			if (!map.containsKey(sum)) {
//				map.put(sum, i);
//			}
//		}
//		return len;
//	}
//
//	public static int getMaxLength(int[] arr,int tar){
//		if(arr==null||arr.length==0){
//			return 0;
//		}
//		//记录前i个数的和
//		int sum=0;
//		//记录最大长度
//		int maxLen=0;
//		//记录最大和和下标位置的映射
//		Map<Integer,Integer> map=new HashMap<>();
//		for(int i=0;i<arr.length;i++){
//			sum+=arr[i];
//			//是否在map中找到结果
//			if(map.get(sum-tar)!=null){
//				maxLen=Math.max(i-map.get(sum-tar),maxLen);
//			}
//			//map中不存在sum
//			if(map.get(sum)==null){
//				map.put(sum,i);
//			}
//		}
//		return maxLen;
//	}

	private static int[][] g;
	private static int[][] d={{1,-1},{1,0},{1,1}};
	static int x;
	static int y;
	public static int maxPathSum(List<List<Integer>> board, int p, int q) {
		// Write your code here
		x=board.size();
		y=board.get(0).size();
		if(p!=0){
			antiInitG(board);
			p=0;
		}else {
			initG(board);
		}
		int max=DFS(p,q);
		return max;
	}

	private static int DFS(int p, int q) {
		if(p>x-1||q>y-1||q<0){
			return 0;
		}
		int val=g[p][q];
		int max=0;
		for(int i=0;i<d.length;i++){
			int dfs = DFS(p + d[i][0], q + d[i][1]);
			if(dfs>max){
				max=dfs;
			}
		}
		//System.out.println(max+val);
		return max+val;
	}

	private static void antiInitG(List<List<Integer>> board) {
		g=new int[board.size()][board.get(0).size()];
		for(int i=0;i<board.size();i++){
			for(int j=0;j<board.get(0).size();j++){
				g[i][j]=board.get(board.size()-1-i).get(j);
			}
		}
	}

	private static void initG(List<List<Integer>> board) {
		g=new int[board.size()][board.get(0).size()];
		for(int i=0;i<board.size();i++){
			for(int j=0;j<board.get(0).size();j++){
				g[i][j]=board.get(i).get(j);
			}
		}
	}

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int m=in.nextInt();
		int n=in.nextInt();

		List<List<Integer>> list = new ArrayList<>();
		for(int i=0;i<m;i++){
			List<Integer> a=new ArrayList<>();
			for (int j = 0; j < n; j++) {
				a.add(in.nextInt());
			}
			list.add(a);
		}
		int p=in.nextInt();
		int q=in.nextInt();
		int sum = maxPathSum(list, p, q);
		System.out.println(sum);
	}
}
