package demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Jospher {
	private static StringBuffer sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = br.readLine();
		int input[] = parseInts(inputStr.split(" "));
		String output = solution(input);
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

	private static String solution(int[] input) {
		if(input==null||input.length!=2){
			return "";
		}
		sb=new StringBuffer();
		josphon(input[0],input[1]);

		return sb.delete(sb.length()-1,sb.length()).toString();
	}

	private static void josphon(int n, int m) {
		int[] b=new int[n];
		for(int i=0;i<n;i++){
			b[i]=1;
		}
		int num=n;
		int sum=0;
		for(int i=0;;i=(i+1)%n){
			if(b[i]==1){
				sum++;
			}
			if(b[i]==0){
				continue;
			}
			if(sum==m){
				b[i]=0;
				sb.append(i+1+" ");
				num--;
				sum=0;
			}
			if(num==0){
				break;
			}
		}
	}

}
