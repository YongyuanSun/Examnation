package demo.huawei;

import java.util.Scanner;

public class ReverseAndReplace{
	public static String solute(String str) {
		if(str.length()==0){
			return "";
		}
		return new StringBuffer(str.replaceAll(" ","0").toLowerCase()).reverse().toString();
	}
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);

		while (in.hasNextLine()){
			System.out.println(solute(in.nextLine()));
		}
	}
}
