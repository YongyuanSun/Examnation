package demo.leetcode;

import java.util.ArrayList;
import java.util.List;


class PhoneNum_17 {
	private static String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	public static List<String> letterCombinations(String  str) {
		if(str==null||str.length()==0){
			return new ArrayList<String>();
		}
		List<String> list= statistics(str,0);
//		if(list==null||list.size()==0){
//			return new ArrayList<String>();
//		}else {
//			for(int i=0;i<list.size();i++){
//				list.add(i,"\""+list.remove(i)+"\"");
//			}
//		}
		return list;
	}

	private static List<String> statistics(String str, int index) {
		if(index>str.length()-1){
			return null;
		}
		String s=map[new Integer(str.charAt(index)-'0')];
		List<String> list = new ArrayList<>();
		List<String> statistics = statistics(str, index + 1);
		for(int i=0;i<s.length();i++){
			if(statistics!=null){
				for(int j=0;j<statistics.size();j++){
					list.add(new String(s.charAt(i)+statistics.get(j)));
				}
			}else {
				list.add(Character.toString(s.charAt(i)));
			}

		}
		return list;
	}

	public static void main(String[] args) {
		System.out.println(letterCombinations("23"));
	}
}

