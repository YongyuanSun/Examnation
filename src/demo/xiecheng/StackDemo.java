package demo.xiecheng;

import java.util.*;

public class StackDemo {


	/*请完成下面这个函数，实现题目要求的功能
	当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
	******************************开始写代码******************************/
	static String resolve(String expr) {
		if(expr==null||"".equals(expr)){
			return expr;
		}
		int pre=0;
		int post=0;
		for(int i=0;i<expr.length();i++){
			Character cc = expr.charAt(i);

			if(cc.equals('(')){
				pre++;
			}
			if(cc.equals(')')){
				post++;
			}
		}
		if(pre!=post){
			return "";
		}
		//System.out.println(expr);
		Stack<Character> stack = new Stack<>();
		List<Character> list = new ArrayList<>();
		for(int i=0;i<expr.length();i++){
			Character c=expr.charAt(i);
			//System.out.println(c);
			if(!c.equals(')')){
				stack.push(c);
			}
			if(c.equals(')')){
				Character ch = stack.pop();
				//System.out.println("dd"+ch);
				while (!ch.equals('(')){
					list.add(ch);
					ch=stack.pop();
				}
				while (!list.isEmpty()){
					stack.push(list.remove(0));
				}
			}
		}
		StringBuffer sb = new StringBuffer();
		Stack<Character> resst = new Stack<>();
		while (!stack.empty()){
			resst.push(stack.pop());
		}
		while (!resst.empty()){
			sb.append(resst.pop());
		}
		String s = sb.toString();

		return s;
	}
	/******************************结束写代码******************************/


	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String res;

		String _expr;
		try {
			_expr = in.nextLine();
		} catch (Exception e) {
			_expr = null;
		}

		res = resolve(_expr);
		System.out.println(res);
		Character c = '(';
		//System.out.println(c.equals('('));
	}
}
