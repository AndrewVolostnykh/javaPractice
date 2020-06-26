public interface Subject {
	public void registration(Observer observer);
	public void remove(Observer observer);
	public void notifyAllObservers(Observer observer);
}