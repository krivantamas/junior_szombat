package library;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Dao<Book, String> bookdao = new BookDao(new Database().getConnection());
        System.out.println(bookdao.getAll());
        System.out.println("====");
        System.out.println(bookdao.getById("978-0316769544"));
        System.out.println(bookdao.update(bookdao.getById("978-0316769544").get(), new Book("","The Hobbit Adventure 2","J.R.R. Tolkien","Fantasy",false)));
        System.out.println("====");
        bookdao.delete(bookdao.getById("978-0316769544").get());
        System.out.println(bookdao.getAll());
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
