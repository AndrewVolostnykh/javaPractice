public class CoffeeTouchscreenAdapter implements CoffeeMachineInterface {
	
	OldCoffeemachine oldCoffeeMachine = OldCoffeeMachine.getInstance();
	
	@Override
	public void chooseFirstSelection(){
		System.out.println("In new interface adapter: ");
		oldCoffeeMachine.selectA();
	}
	
	@Override
	public void chooseSecondSelection(){
		System.out.println("In new interface adapter: ");
		oldCoffeeMachine.selectB();
	}
	
}