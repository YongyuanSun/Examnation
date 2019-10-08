package demo.interfaces;

public interface Iface {
	public void sayHell0();
	default void sayHello(){
		System.out.println("hello");
	}
	default void saySorry(){
		System.out.println("sorry");
	}
}
