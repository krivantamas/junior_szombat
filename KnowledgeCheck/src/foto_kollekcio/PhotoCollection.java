package foto_kollekcio;

import java.util.ArrayList;
import java.util.List;

public class PhotoCollection{

    static List<Photo> photoList = new ArrayList<>();

    public static void addPhoto(Photo photo){
        photoList.add(photo);
    }

    public static void listPhotos(){
        for (Photo photo:photoList) {
            System.out.println(photo.getName() + " " + numberOfStars(photo));
        }
    }

    public static String numberOfStars(Photo photo){
        String stars;
        return switch (photo.getQuality()){
            case NO_STAR -> stars = "";
            case ONE_STAR -> stars = "*";
            case TWO_STAR -> stars = "**";
        };
    }

    public static void starPhoto(String photoName, Quality quality) {

        boolean isInTheList = false;
        for (Photo photo:photoList){
            if (photo.getName().equals(photoName)){

                photo.setQuality(quality);
                isInTheList = true;
                break;
            }
        }
        if(isInTheList == false){
            throw new PhotoNotFoundException();
        }


    }

}
