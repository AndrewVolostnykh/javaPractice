public class Playlist implements IComponent {

	public String playlistName;
	public ArrayList<IComponent> playlist = new ArrayList();

	public Playlist(String playlistName) {
		this.playlistName = playlistName;
	}
	
	public void add(IComponent component){ // first tool that contract of IComponent have no but important in realisation for Composite
		playlist.add(component);
	}
	
	public void remove(IComponent component){ // second tool
		playlist.remove(component);
	}

	@Override
	public void play(){
		for(IComponent component : playlist){
			System.out.println("Now playing: " + component.getName());
			component.play();
		}
	}

	@Override
	public void setPlaybackSpeed(float speed){
		for(IComponent component : playlist){
			component.setPlaybackSpeed(speed);
		}
	}
	
	@Override
	public String getName(){
		return this.playlistName
	}
}