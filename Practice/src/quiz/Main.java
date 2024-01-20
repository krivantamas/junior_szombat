package quiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<QuizItem> quizItems = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File("W:\\Webler\\Materials\\Git\\junior_szombat\\Practice\\kerdesek.txt"));

            while (scanner.hasNextLine()) {

                String question = scanner.nextLine();
                String[] values = scanner.nextLine().split(" ");

                quizItems.add(new QuizItem(question, values[0], Integer.parseInt(values[1]), values[2]));
            }

        } catch (FileNotFoundException e) {
            System.err.println("Hiba!");
        }

        //System.out.println("Matek kérdések: " + questionsByTheme(quizItems, "matematika"));
        //System.out.println("Kérdések témakörönként: " + questionsGroupedByTheme(quizItems));
        //System.out.println("Legtöbb pontot érő téma: " + bestTheme(questionsGroupedByTheme(quizItems)));

        asd(quizItems,5);

    }


    private static List<String> questionsByTheme(List<QuizItem> quizItems, String theme) {

        return quizItems
                .stream()
                .filter(quizItem -> quizItem.getTheme().equals(theme))
                .map(QuizItem::getQuestion)
                .toList();


    }

    private static List<QuizItem> asd (List<QuizItem> quizItems, int n){
        if (n >= quizItems.size()) {
            return quizItems;
        }

        Random random = new Random();
        return random.ints(0, quizItems.size())
                .distinct()
                .limit(n)
                .mapToObj(quizItems::get)
                .collect(Collectors.toList());
    }

    private static Map<String, List<QuizItem>> questionsGroupedByTheme(List<QuizItem> quizItems) {


        Map<String, List<QuizItem>> map = quizItems
                .stream()
                .collect(Collectors.groupingBy(QuizItem::getTheme));
        return map;


    }

    private static String  bestTheme(Map<String, List<QuizItem>> map) {
        return map.entrySet()
                .stream()
                .max((o1, o2) -> {

                    int o1_sum = o1.getValue().stream().mapToInt(QuizItem::getScore).sum();
                    int o2_sum = o2.getValue().stream().mapToInt(QuizItem::getScore).sum();

                    return Integer.compare(o1_sum, o2_sum);

                }).orElseThrow().getKey();

    }

    private static String mostWorthyTopic(List<QuizItem> quizItems){
        return quizItems.stream()
                .collect(Collectors.groupingBy(QuizItem::getTheme, Collectors.summingInt(QuizItem::getScore)))
                .entrySet()
                .stream()
//                .peek(System.out::println)
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();
    }
}