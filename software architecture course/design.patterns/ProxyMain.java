package patterns;

public class ProxyMain {
	public static void main(String[] args){
		var car = new CarProxy();
		car.drive(); // this will be to messages: This is a proxy code and Drive reno!
	}
	
}

interface Car {
	void drive();
}

class CarProxy implements Car {
	Car car = new Renault();
	
	@Override
	public void drive(){
		System.out.println("This is a proxy code");
		car.drive();
	}
}

class Renault implements Car {
	@Override
	void drive(){
		System.out.println("Drive reno!");
	}
}