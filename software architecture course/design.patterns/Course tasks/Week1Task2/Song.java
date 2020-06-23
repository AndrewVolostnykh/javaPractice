public class Song implements IComponent {
	public String songName;
	public String artist;
	public float speed = 1; // Default playback speed

	public Song(String songName, String artist ) {
		this.songName = songName;
		this.artist = artist; 
	}	
	
	public String getArtist() {
		return this.artist;
	}
	
	@Override
	public void play(){
		System.out.println(this.getName() + " playing now, with speed: " + this.speed);
	}
	
	@Override
	public void setPlaybackSpeed(float speed){
		this.speed = speed;
	}
	
	@Override
	public String getName() {
		return this.songName;
	}

}