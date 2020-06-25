public class CommandMain {
	public static void main(String[] args){
		//Command command = new MouseClick(); // bad idea... when we will have much objects like MouseClick it will be a problem
		//command.execute();
		
		Receiver receiver = new Receiver();
		receiver.addComand(new HotkeyClick());
		receiver.addComand(new MouseClick());
		
		receiver.runCommand();
	}
}

interface Command {
	void execute();
}

class KeyboardClick implements Command {
	@Override
	public void execute() {
		System.out.println("keyboard command"); 
	}
}

class HotkeyClick implements Command {
	@Override
	public void execute() {
		System.out.println("Hotkey command"); 
	}
}

class MouseClick implements Command {
	@Override
	public void execute() {
		System.out.println("Click command"); 
	}
}

class Receiver {
	List<Command> commands = new ArrayList<>();
	
	void addComand(Command command) {
		commands.add(command);
	}
	
	void runCommand() { // for example, or we can execute command that will inputed in method... idk
		for (Command command : commands){
			command.execute();
		}
	}
}



