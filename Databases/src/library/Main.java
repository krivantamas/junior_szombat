package library;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        initDatabase();
    }

    private static void initDatabase() {

        try {
            Scanner scanner = new Scanner(new File("W:\\Webler\\Materials\\Git\\junior_szombat\\Databases\\src\\library\\books.csv"));
            scanner.nextLine();
            while (scanner.hasNextLine()) {

                String[] values = scanner.nextLine().split(";");
                String isbn = values[0];
                String title = values[1];
                String author = values[2];
                String genre = values[3];
                boolean available = values[4].equalsIgnoreCase("yes");

                System.out.println(new Book(isbn, title, author, genre, available));


            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

}
