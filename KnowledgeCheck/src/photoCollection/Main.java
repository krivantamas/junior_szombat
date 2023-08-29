package photoCollection;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		PhotoCollection collection = new PhotoCollection();
		
		collection.addPhoto(new Photo("Photo 1"));
        collection.addPhoto(new Photo("Photo 2", Quality.ONE_STAR));
        collection.addPhoto(new Photo("Photo 3", Quality.TWO_STARS));
        
        System.out.println("Photos in the collection:");
        collection.listPhotos();
        
        collection.starPhoto("Photo 1", Quality.ONE_STAR);

        System.out.println("\nPhotos after starring:");
        collection.listPhotos();

        int totalStars = collection.numberOfStars();
        System.out.println("\nTotal stars in the collection: " + totalStars);

	}

}
