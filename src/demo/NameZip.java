package demo;

import java.util.Scanner;


public class NameZip{
	public static String solute(String name){
		if(!check(name)){
			return "unknown name";
		}
		String[] s = name.trim().split(" ");
		if(s.length<=2){
			StringBuffer sb=new StringBuffer();
			for(String str:s){
				sb.append(str);
			}
			return sb.toString().toLowerCase();
		}else {
			StringBuffer sb=new StringBuffer();
			for(String str:s){
				sb.append(str.charAt(0));
			}
			return sb.toString().toLowerCase();
		}
	}

	private static boolean check(String name) {
		String[] s = name.split(" ");
		if(s.length==0){
			return false;
		}
		for(int i=0;i<s.length;i++){
			String str=s[i];
			for (int j=0;j<str.length();i++){
				char c=str.charAt(j);
				if(!((c>='a'&&c<='z')||(c>='A'&&c<='Z'))){
					return false;
				}
			}

		}
		return true;
	}

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		while (in.hasNextLine()){
			System.out.println(solute(in.nextLine()));
		}
	}
}
