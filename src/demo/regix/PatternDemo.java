package demo.regix;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternDemo {
	public static void main(String[] args) {
		String s = "Hello 123 4567 World_This is a Regex Demo";

		Pattern p1=Pattern.compile("\\w+");
		Matcher matcher = p1.matcher(s);
		if(matcher.find()){
			System.out.println(matcher.group());
		}
		System.out.println(s.matches("^[\\w\\s]*"));
		System.out.println(s.replaceAll("\\s","-"));
	}
}
