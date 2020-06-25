package patterns;

// this pattern create a wrapper when we have a concurrence with some interface methods
public class AdapterMain{
	public static void main(String[] args){
		CarWash washer = new CarWash();
		carWash.washCar(new Tesla()); // <- here we have no problems, we can include in class CarWash classes, that implements interface Car (sygnature of method washCar(Car car)
		// carWash.washCar(new Track()); // incorrect, ok ? 
		carWash.washCar(new TrackWrap(new TrackBig()); // problem solved
	}
}

class TrackWrap implements Car { // here we have a solutiuon of upper problem
	Track track;
	
	public TrackWrap(Track track) {
			this.track = track;
	}
	
	@Override
	public void wash(){
		track.clean();
	}
	
}

interface Track { // but with truck we have a problem! Becouse cant wash it, only clean! 
	void clean();
}

class TrackBig implements Track {
	@Override
	public void clean(){
		System.out.println("TrackBig is clean!");
	}
}

 
interface Car {
	void wash();
}

class Tesla implements Car {
	@Override
	public void wash(){
		System.out.println("wash car");
	}
}

class CarWash {
	public void washCar(Car car){
		car.wash();
	}
}