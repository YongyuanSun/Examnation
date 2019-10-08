package demo.kedaxunfei;
import java.util.Scanner;

public class zipAlpha {
	private static String solute(String str){
		if(str==null||str.length()==0){
			return "";
		}
		StringBuffer sb = new StringBuffer();
		char pre = str.charAt(0);
		int count =1;
		for(int i=1;i<str.length();i++){
			char cur = str.charAt(i);
			if(cur==pre){
				count++;
			}else {
				sb.append(count);
				sb.append(pre);
				pre=cur;
				count=1;
			}
		}
		sb.append(count);
		sb.append(pre);
		return sb.toString();
	}
	public static void main(String[] args){
		Scanner in =new Scanner(System.in);
		while(true){
			System.out.println(solute(in.nextLine()));
		}
	}
}
