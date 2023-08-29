package photo_collection;

import java.util.ArrayList;
import java.util.List;

public class PhotoCollection {

    List<Photo> photos = new ArrayList<>();

    public boolean addPhoto(Photo photo) {
        return photos.add(photo);
    }

    public void listPhotos() {

        for (Photo photo : photos) {

            String photoString = photo.getName() + " ";

            if (photo.getQuality() == Quality.ONE_STAR) {
                photoString += "*";
            } else if (photo.getQuality() == Quality.TWO_STAR) {
                photoString += "**";
            }

            System.out.println(photoString);

        }

    }

    public void starPhoto(String photoName, Quality quality) {

        for (Photo photo : photos) {
            if (photo.getName().equals(photoName)) {
                photo.setQuality(quality);
                return;
            }
        }
        throw new PhotoNotFoundException();
    }


    public int numberOfStars() {
        int numberOfStars = 0;
        for (Photo photo : photos) {
            numberOfStars += mapQualityToInt(photo.getQuality());
        }
        return numberOfStars;
    }

    public int numberOfStarsV2() {
        return photos.stream().mapToInt(photo -> mapQualityToInt(photo.getQuality())).sum();
    }

    private static int mapQualityToInt(Quality quality) {
        return switch (quality) {
            case NO_STAR -> 0;
            case ONE_STAR -> 1;
            case TWO_STAR -> 2;
        };


    }


}
