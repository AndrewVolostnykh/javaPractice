package patterns;

public class FacadeMain {
	public static void main (String[] args){
		// imagine that here we have very hard realisation of something. Its not a normal to write in main method some logic. 
		// so, go to create new Class that will store this realisation of buisness logic
		var realis = new FacadeRealisation()
		System.out.println(realis.hardLogic());
	}
	
}

class FacadeRealisation {
	String hardLogic(){
		for(int i = 0; i < 100; i++){
			System.out.println("Attempt to complete very hard logic: " + i + "%");
		}
		return "This is realy hard logic realisation (Completed)";
	}
	
}