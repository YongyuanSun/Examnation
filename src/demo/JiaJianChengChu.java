package demo;

import java.util.Stack;

public class JiaJianChengChu {
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		for(int i=0;i<tokens.length;i++){
			if(tokens[i].equals("+")||tokens[i].equals("-")||tokens[i].equals("*")||tokens[i].equals("/")){
				int a = stack.pop();
				int b = stack.pop();
				stack.push(solute(b,a,tokens[i]));
			}else {
				stack.push(new Integer(tokens[i]));
			}
		}
		return stack.pop();
	}

	private Integer solute(int b, int a, String token) {
		int res=-1;
		switch (token){
			case "+": res=b+a;
				break;
			case "-" :res=b-a;
				break;
			case "*" :res=b*a;
				break;
			case "/":res=b/a;
				break;
		}
		return res;
	}
}