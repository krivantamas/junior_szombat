package library;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        BookDao bookdao = new BookDao(new Database().getConnection());
        System.out.println(bookdao.getAllAuthor());
        System.out.println(bookdao.booksByAuthor("Paulo Coelho"));
        System.out.println(bookdao.availableBooks());
        System.out.println(bookdao.getAllAuthorMoreThanOneBook());
        //initDatabase(bookdao);
    }

    private static void initDatabase(Dao<Book, String> bookdao) {

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

                bookdao.save(new Book(isbn, title, author, genre, available));


            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

}
