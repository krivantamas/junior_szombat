package sorozat;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Main {

    static class Series {

        String onAirDate;
        String title;
        int season;
        int episode;
        int length;
        boolean isSeen;


        public Series(String onAirDate, String title, int season, int episode, int length, boolean isSeen) {
            this.onAirDate = onAirDate;
            this.title = title;
            this.season = season;
            this.episode = episode;
            this.length = length;
            this.isSeen = isSeen;
        }

        @Override
        public String toString() {
            return "Series{" +
                    "onAirDate='" + onAirDate + '\'' +
                    ", title='" + title + '\'' +
                    ", season=" + season +
                    ", episode=" + episode +
                    ", length=" + length +
                    ", isSeen=" + isSeen +
                    '}';
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("W:\\Webler\\Materials\\Git\\junior_szombat\\ProjektGyakorloFeladatok\\src\\sorozat\\lista.txt"));

        List<Series> seriesList = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String onAir = scanner.nextLine();
            String title = scanner.nextLine();
            int[] values = Arrays.stream(scanner.nextLine().split("x")).mapToInt(Integer::parseInt).toArray();
            int length = Integer.parseInt(scanner.nextLine());
            boolean seen = scanner.nextLine().equals("1");

            seriesList.add(new Series(onAir, title, values[0], values[1], length, seen));
        }

        System.out.println("2. feladat\n\tA listában " + seriesList.stream().filter(series -> !series.onAirDate.equals("NI")).count() + " db vetítési dátummal rendelkező epizód van.");

        double seen = (seriesList.stream().filter(series -> series.isSeen).count() * 100.0) / seriesList.size();

        System.out.printf("3. feladat\n\tA listában lévő epizódok %.2f-át látta.", seen);

        Duration duration = Duration.ofMinutes(seriesList.stream().filter(series -> series.isSeen).mapToInt(series -> series.length).sum());

        System.out.println("4. feladat\n\tSorozatnézéssel: " + duration.toDaysPart() + " napot " + duration.toHoursPart() + " órát és " + duration.toMinutesPart() + " percet töltött.");


        System.out.print("5. feladat\n\tAdjon meg egy dátumot! Dátum= ");
        Scanner sc = new Scanner(System.in);
        LocalDate parse = LocalDate.parse(sc.nextLine().replaceAll("\\.", "-"));



       seriesList.stream().filter(s -> {
            if(!s.onAirDate.equals("NI")){
                LocalDate airDate = LocalDate.parse(s.onAirDate.replaceAll("\\.", "-"));
                return parse.isAfter(airDate);
            }
            return false;


        }).filter(series -> !series.isSeen).toList().forEach(
                series -> {
                    System.out.printf(series.season+"x%02d " + series.title+"\n",series.episode);
                }
       );


    }
}