public class Channel implements Subject {
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	private String channelName;
	private String status;

	public Channel(String channelName, String status) {
		this.channelName = channelName;
		this.status = status;
	}
	
	public String getChannelName() {
		return channelName;
	}
	
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	
	public string getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
		notifyObservers();
	}

	@Override
	public void notifyAllObservers() {
		for (Observer obs : observers) {
			obs.update(this.status);
		}
	}
	
	@Override
	public void registration(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void remove(Observer observer) {
		observers.remove(observer);
	}
}