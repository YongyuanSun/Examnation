package demo.leetcode;

import java.util.Stack;

public class ValidatBrackets_20{
	public boolean isValid(String s) {
		if(s==null||s.length()==0){
			return true;
		}
		Stack<Character> stack = new Stack<>();
		for(int i=0;i<s.length();i++){
			char c=s.charAt(i);
			if(c=='('||c=='['||c=='{'){
				stack.push(c);
			}
			if(c==')'){
				if(stack.isEmpty()){
					return false;
				}
				char c1 =stack.pop();
				if(c1!='('){
					return false;
				}
			}
			if(c==']'){
				if(stack.isEmpty()){
					return false;
				}
				char c1 =stack.pop();
				if(c1!='['){
					return false;
				}
			}
			if(c=='}'){
				if(stack.isEmpty()){
					return false;
				}
				char c1 =stack.pop();
				if(c1!='{'){
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
}
