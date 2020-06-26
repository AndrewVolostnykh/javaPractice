public class MediatorMain {
	public static void main(String[] args){
		ConcreteMediator mediator = new ConcreteMediator();
		mediator.add(new ConcreteCollegue(mediator));
		mediator.add(new ConcreteCollegue(mediator));
		ConcreteCollegue collegue = new ConcreteCollegue(mediator);
		mediator.add(collegue);
		collegue.changeStatus();
	}
	
}

interface Mediator {
	void requestAll(Collegue collegue);
}

class ConcreteMediator implements Mediator {
	List<Collegue> collegues = new ArrayList<>();
	
	void add(Collegue collegue){
		collegues.add(collegue);
	}
	
	@Override
	public void requestAll(Collegue collegue) {
		collegue.setTrue();
		for(Collegue collegue : collegues){
			if(collegue != null){
				collegue.setFalse();
			}
		}
	}
}

interface Collegue {
	void setFalse();
	void setTrue();
	void changeStatus();
}

class ConcreteCollegue implements Collegue {
	
	boolean state;
	
	public ConcreteCollegue(Mediator mediator){
		this.mediator = mediator;
	}
	
	@Override
	public void setTrue() {
		this.statue = true;
	}
	
	@Override
	public void setFalse() {
		this.statue = false;
	}
	
	@Override
	public void changeStatus() {
		mediator.requestAll(this);
	}
}