package demo.builder;

public class PersonBuilder {
	private Person person;
	public PersonBuilder(){
		person=new Person();
	}
	public PersonBuilder buildName(String name){
		person.setName(name);
		return this;
	}

	public PersonBuilder buildAge(int age){
		person.setAge(age);
		return this;
	}
	public PersonBuilder buildId(int id){
		person.setId(id);
		return this;
	}
	public PersonBuilder buildAddr(String addr){
		person.setAddr(addr);
		return this;
	}
	public Person build(){
		return person;
	}

}
