package patterns;

public class TemplateMethodMain {
	public static void main(String[] args){
		Template temp = new Job();
		temp.run();
	}
}

abstract class Template {
	abstract void stepOne();
	abstract void stepTwo();
	abstract void stepThree();
	
	void run(){
		stepOne();
		stepTwo();
		stepThree();
	}
}

class Job extends Template {
	@Override
	void stepOne(){
		System.out.println("First step");
	}
	
	@Override
	void stepTwo(){
		System.out.println("Second step");
	}
	
	@Override
	void stepThree(){
		System.out.println("Third step");
	}
}