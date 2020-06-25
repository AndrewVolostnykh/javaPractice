package patterns;

class FactoryMethodMain{
	public static void main(String[] args){
		Person person = Person.create();
	}
}

class Person {
	private Person(){}
	
	public static Person create(){
		return new Person();
	}
}