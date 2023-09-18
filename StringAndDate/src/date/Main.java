package date;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Set;


public class Main {

    public static void main(String[] args) {


        LocalDate localDate = LocalDate.now(); //
        localDate = LocalDate.of(2015, 2, 20); //
        localDate = LocalDate.parse("2015-02-20"); //

        LocalDate tomorrow = LocalDate.now().plusDays(1);
        LocalDate yesterday = LocalDate.now().minusDays(1);

        LocalDate of1900 = LocalDate.of(1900, 1, 1);
        for (int i = 0; i <= 100; i++) {
            System.out.println((1900 + i) + " : " + of1900.plusYears(i).isLeapYear());
        }

        System.out.println(tomorrow.isAfter(LocalDate.now()));
        System.out.println(tomorrow.isBefore(LocalDate.now()));


        System.out.println();

        LocalTime now = LocalTime.now(); //
        now = LocalTime.of(6, 30); //
        now = LocalTime.parse("06:30"); //

        LocalDateTime localDateTime=LocalDateTime.now();  //
        LocalDateTime.of(2015, Month.FEBRUARY,20,06,30);  //
        LocalDateTime.parse("2015-02-20T06:30:00");  //

        Set<String> allZoneIds= ZoneId.getAvailableZoneIds();

        for (String s : allZoneIds){
            ZoneId zoneId=ZoneId.of(s);
            ZonedDateTime zonedDateTime=ZonedDateTime.of(localDateTime,ZoneId.systemDefault());

            System.out.println(zonedDateTime + " - " + zonedDateTime.withZoneSameInstant(zoneId));
        }

        LocalDate initialDate=LocalDate.parse("2023-09-16");
        LocalDate finalDate=LocalDate.parse("1996-11-27");

        System.out.println(initialDate.getDayOfMonth());

        Period between = Period.between(initialDate, finalDate);
        System.out.println(between.get(ChronoUnit.DAYS));


        int daysBetween=Period.between(initialDate,finalDate).getDays();


    }
}
