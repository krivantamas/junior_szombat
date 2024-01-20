package pizza_futar;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Order> orders = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File("W:\\Webler\\Materials\\Git\\junior_szombat\\Practice\\orders.txt"));

            LocalDate actualDate = null;

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
                if (!isPostmanId(line)) {
                    actualDate = LocalDate.parse(line.replace(".", "-"));
                } else {
                    String addressAndArrivalTime = scanner.nextLine();
                    String[] s = addressAndArrivalTime.split(" ");
                    Order order = new Order(actualDate, line, s[0] + " " + s[1] + " " + s[2], LocalTime.parse(s[3]));
                    orders.add(order);
                }


            }

        } catch (FileNotFoundException e) {
            System.err.println("Hiba!");
        }
        System.out.println("Legkevesebb rendelés - " + leastOrder(orders));
        ;
        System.out.println("Futár stat - " + postmanStat(orders));
        System.out.println("Legjobb lakás - " + mostOrderAddress(orders));
        System.out.println("Rendelések  2020-12-03:  " + ordersByDate(orders, LocalDate.parse("2020-12-03"), LocalTime.parse("12:30")));

    }


    private static LocalDate leastOrder(List<Order> orders) {


        LocalDate key = orders
                .stream()
                .collect(Collectors.groupingBy(Order::getOrderDate, Collectors.counting()))
                .entrySet()
                .stream()
                .min(Comparator.comparingLong(Map.Entry::getValue)).orElseThrow().getKey();

        return key;

    }

    private static List<Order> ordersByDate(List<Order> orders, LocalDate date, LocalTime time) {

        List<Order> ordersByDate = orders
                .stream()
                .filter(order -> order.getOrderDate().equals(date))
                .filter(order -> order.getArrivalTime().equals(time))
                .toList();

        if (ordersByDate.isEmpty()) {
            throw new NoSuchElementException();
        }

        return ordersByDate;

    }

    private static Map<String, Long> postmanStat(List<Order> orders) {

        Map<String, Long> collect = orders.stream().collect(Collectors.groupingBy(Order::getPostmanId, Collectors.counting()));
        System.out.println();

        return collect;
    }

    private static String mostOrderAddress(List<Order> orders) {

        String address = orders
                .stream()
                .collect(Collectors.groupingBy(Order::getAddress, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparingLong(Map.Entry::getValue)).orElseThrow().getKey();

        return address;
    }


    private static boolean isDate(String possibleDate) {

            try {
                LocalDate parse = LocalDate.parse(possibleDate.replace(".", "-"));
                return true;
            } catch (DateTimeParseException exception) {
            return false;
        }
    }

    private static boolean isPostmanId(String possiblePostmanId) {

        return possiblePostmanId.startsWith("FUT_");

    }
}