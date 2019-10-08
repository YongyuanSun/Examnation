package demo.leetcode;

import java.util.ArrayList;
import java.util.List;

class ABCDEFullArray {
	public static List<String> letterCombinations(String  str) {
		if(str==null||str.length()==0){
			return new ArrayList<String>();
		}
		List<String> list= statistics(str,0);
		return list;
	}

	private static List<String> statistics(String str, int index) {
		if(index>str.length()-1){
			return null;
		}
		char c=str.charAt(index);
		List<String> list = new ArrayList<>();
		List<String> statistics = statistics(str, index + 1);
		for(int i=1;i<4;i++){
			if(statistics!=null){
				for(int j=0;j<statistics.size();j++){
					list.add(Character.toString(c)+i+statistics.get(j));
				}
			}else {
				list.add(Character.toString(c)+i);
			}

		}
		return list;
	}

	public static void main(String[] args) {

		List<String> res = letterCombinations("ABC");
		for(int i=0;i<res.size()-1;i++){
			System.out.print(res.get(i)+" ");
		}
		System.out.println(res.get(res.size()-1));
	}
}


