public class OldCoffeeMachine {
	
	OldCoffeeMachine uniqueInstance;
	
	private OldCoffeeMachine (){} // singeltone pattern because we have only one old coffee machine :)
	
	OldCoffeeMachine getInstance(){
		if (uniqueInstance == null) {
			uniqueInstance = new OldCoffeeMachine();
			
			return uniqueInstance;
		}
	}
	
	
	void selectA(){
		System.out.println("Selected A in old coffee machine");
	}
	
	void selectB(){
		System.out.println("Selected B in old coffee machine");
	}
}