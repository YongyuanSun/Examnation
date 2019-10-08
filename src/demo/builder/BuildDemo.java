package demo.builder;

/**
 * 演示builder模式，使用到的类：Person、PersonBuilder
 */
public class BuildDemo {
	public static void main(String[] args) {
		Person p = new PersonBuilder().buildName("zhangsan").buildAge(23).build();
		System.out.println(p.getName());
		System.out.println(p.getAddr());
	}
}
