package patterns;

// This pattern create Factories to project some classes
public class AbstractFactoryMain {
	public static void main(String[] args){
		Factory carFact = new AbstractFactory().createFactory("Car");
		Factory tankFact = new AbstractFactory().createFactory("Tank");
		var newT = carFact.createCar("Toyota");
		newT.drive();
		var newJag = tankFact.createTank("JagPanz");
		newJag.drive();
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

class CarFactory implements Factory{
	public Car createCar(String typeOfCar){
		switch(typeOfCar){
			case "Toyota": return new Toyota();
			case "Audi": return new Audi();
			default: return null;
		}
	}
	
	public Tank createTank(String typeOfTank){
		return null;
	}
}

interface Tank {
	void drive();
}

class T34 implements Tank{
	
	@Override
	public void drive(){
		System.out.println("Thats a T34");
	}
}

class JagPanz implements Tank{
	
	@Override
	public void drive(){
		System.out.println("Thats a JagPanzerE100");
	}
	
}

class TankFactory implements Factory{
	public Tank createTank(String typeOfTank){
		switch(typeOfTank){
			case "T34": return new T34();
			case "JagPanz": return new JagPanz();
			default: return null;
		}
	}
	
	public Car createCar(String typeOfCar){
		return null;
	}
}

interface Factory{
	Car createCar(String typeOfCar);
	Tank createTank(String typeOfTank);
}

class AbstractFactory {
	public Factory createFactory(String typeOfFactory){
		switch(typeOfFactory){
			case "Car": return new CarFactory();
			case "Tank": return new TankFactory();
			default: return null;
		}
	}
}