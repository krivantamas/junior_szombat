package foto_kollekcio;


public class Main {

    public static void main(String[] args) {

        PhotoCollection.addPhoto(new Photo("valami", Quality.NO_STAR));
        PhotoCollection.addPhoto(new Photo("Kirandulas", Quality.NO_STAR));
        PhotoCollection.addPhoto(new Photo("este", Quality.NO_STAR));
        PhotoCollection.addPhoto(new Photo("grill"));
        PhotoCollection.addPhoto(new Photo("szulinap", Quality.NO_STAR));


        try {
            PhotoCollection.starPhoto("iskola", Quality.TWO_STAR);
        } catch (PhotoNotFoundException e) {
            System.out.println("There is no photo with this name!");
        }

        System.out.println();

        try {
            PhotoCollection.listPhotos();
        } catch (NullPointerException e) {
            System.out.println("Some of the photos has no quality!");
        }

        System.out.println();


        try {
            PhotoCollection.starPhoto("grill", Quality.ONE_STAR);
        } catch (PhotoNotFoundException e) {
            System.out.println("There is no photo with this name!");
        }



        try {
            PhotoCollection.starPhoto("este", Quality.TWO_STAR);
        } catch (PhotoNotFoundException e) {
            System.out.println("There is no photo with this name!");
        }

        System.out.println();

        try {
            PhotoCollection.listPhotos();
        } catch (NullPointerException e) {
            System.out.println("Some of the photos has no quality!");
        }


    }

}
