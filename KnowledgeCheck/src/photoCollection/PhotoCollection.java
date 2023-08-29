package photoCollection;

import java.util.List;
import java.util.ArrayList;

public class PhotoCollection {
	private List<Photo> photos;
	
	public PhotoCollection() {
		photos = new ArrayList<>();
	}
	
	public void addPhoto(Photo photo) {
		photos.add(photo);
	}
	
	public void listPhotos(){
		for(Photo photo : photos) {
			System.out.println(photo.getName() + " " + String.valueOf(photo.numberOfStars()));
		}
	}
	
	public void starPhoto(String name, Quality quality) throws PhotoNotFoundException{
		for(Photo photo : photos) {
			if(photo.getName().equals(name)) {
				photo.setQuality(quality);				
				return;
			}
		}
		throw new PhotoNotFoundException("Photo not found!");
	}
	
	public int numberOfStars() {
		int numberOfStars = 0;
		for(Photo photo: photos) {
			numberOfStars += photo.numberOfStars();
		}
		return numberOfStars;
	}
	
}
