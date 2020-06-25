package patterns;

public class FactoryMain {
	public static void main(String[] args){
		Factory carDealer = new Factory();
		
		// here we go to create some cars
		Car newToyota = carDealer.create("Toyota");
		newToyota.drive();
		var newAudi = carDealer.create("Audi");
		newAudi.drive();
	}
	
}

interface Car {
	void drive();
}

class Toyota implements Car{
	
	@Override
	public void drive(){
		System.out.println("This is TOYOTA driving");
	}
}

class Audi implements Car {
	
	@Override
	public void drive(){
		System.out.println("This is AUDI driving");
	}
	
}

class Factory {
	public Car create(String typeOfCar){
		switch(typeOfCar){
			case "Toyota": return new Toyota();
			case "Audi": return new Audi();
			default: return null;
		}
	}
}