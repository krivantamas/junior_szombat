import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        SongDao songDao = new SongDao(database.getConnection());

        //initDatabase(songDao);
        System.out.println(songDao.getAll());


    }

    private static void initDatabase(SongDao songDao) {
        try {
            Scanner scanner = new Scanner(new File("W:\\Webler\\Materials\\Git\\junior_szombat\\FunctionalProgramming\\src\\streams\\radio\\musor.txt"));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(" ", 4);
                String[] singerAndTitle = values[3].split(":");

                int radioId = Integer.parseInt(values[0]);
                int min = Integer.parseInt(values[1]);
                int sec = Integer.parseInt(values[2]);
                String singer = singerAndTitle[0];
                String title = singerAndTitle[1];

                songDao.save(new Song(radioId, min * 60L + sec, singer, title));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}