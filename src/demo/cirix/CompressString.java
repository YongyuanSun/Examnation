package demo.cirix;


public class CompressString {
	public static String solution(String str) {
		int[] arr = new int[26];
		int i = 0;
		while (i < str.length()) {
			char c = str.charAt(i);
			if (c >= 'a' && c <= 'z') {
				i++;
				int cNum = str.charAt(i)-'0';
				while (i+1<str.length()&&str.charAt(i + 1) >= '0' && str.charAt(i + 1) <= '9') {
					cNum = cNum * 10 + str.charAt(++i)-'0';

				}
				i++;
				arr[c - 'a']+= cNum;
			}
		}
		StringBuffer sb=new StringBuffer();
		for(int j=0;j<arr.length;j++){
			if(arr[j]!=0){
				sb.append((char)(j-0+'a')+""+arr[j]);
			}
		}
		return sb.toString();
	}


	public static void main(String[] args) {
		System.out.println(solution("a12c56a1b5"));
		System.out.println((char)(10-0+'a')+10);

	}
}
