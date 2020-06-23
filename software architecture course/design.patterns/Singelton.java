package design;

public class SingeltoneMain {
	public static void main (String[] args){
		Singeltone newInstance = Singeltone.getInstance();
	}
}


class Singeltone{
	Singeltone singeltone;
	private Singeltone(){}
	
	public static Singeltone getInstance(){
		if(this.singeltone == null){
			this.singeltone = new Singeltone();
		}
		
		return singeltone;
	}
}