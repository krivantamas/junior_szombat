package photo_collection;


public class Main {
    public static void main(String[] args) {

        Photo p1 = new Photo("Teszt_1");
        Photo p2 = new Photo("Teszt_2", Quality.TWO_STAR);
        Photo p3 = new Photo("Teszt_3", Quality.ONE_STAR);

        PhotoCollection photoCollection = new PhotoCollection();
        photoCollection.addPhoto(p1);
        photoCollection.addPhoto(p2);
        photoCollection.addPhoto(p3);

        photoCollection.listPhotos();
        System.out.println(photoCollection.numberOfStars());

        photoCollection.starPhoto("Teszt_1",Quality.TWO_STAR);
        System.out.println(photoCollection.numberOfStars());

        photoCollection.starPhoto("Teszt_4",Quality.TWO_STAR);





    }
}
