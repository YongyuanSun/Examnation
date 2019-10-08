package demo.vivo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MinSkipNum {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = br.readLine();
		int input[] = parseInts(inputStr.split(" "));
		int output = solution(input);
		System.out.println(output);
	}

	private static int[] parseInts(String[] strArr) {
		if (strArr == null || strArr.length == 0) {
			return new int[0];
		}
		int[] intArr = new int[strArr.length];
		for (int i = 0; i < intArr.length; i++) {
			intArr[i] = Integer.parseInt(strArr[i]);
		}
		return intArr;
	}

	private static int solution(int[] input) {
		if(input==null||input.length==0){
			return -1;
		}
		int Num=input.length-1;
		int n=input[0];
		int index=0;
		int max=0;
		int newindex=0;
		int count=1;
		while (n<Num){
			for(int i=index+1;i<index+n+1;i++){
				if(i>input.length-1){
					break;
				}
				if(input[i]+i>max){
					max=input[i]+i-index;
					newindex=i;
				}
			}
			max=0;
			Num-=newindex;
			index=newindex;
			n=input[newindex];
			count++;
		}
		return count;
	}
}