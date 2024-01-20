package jelado;

import java.io.*;
import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

public class Main {

    static class CoordAtTime {

        int hour;
        int minute;
        int seconds;
        int x;
        int y;

        public CoordAtTime(int hour, int minute, int seconds, int x, int y) {
            this.hour = hour;
            this.minute = minute;
            this.seconds = seconds;
            this.x = x;
            this.y = y;
        }

        public double getAsMinutes() {
            return hour * 60.0 + minute + seconds / 60.0;
        }

        @Override
        public String toString() {
            return "CoordAtTime{" +
                    "hour=" + hour +
                    ", minute=" + minute +
                    ", seconds=" + seconds +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File("W:\\Webler\\Materials\\Git\\junior_szombat\\ProjektGyakorloFeladatok\\src\\jelado\\jel.txt"));
        List<CoordAtTime> coords = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            int[] values = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();

            coords.add(new CoordAtTime(values[0], values[1], values[2], values[3], values[4]));
        }

        System.out.println();

        Scanner scanner_ = new Scanner(System.in);
        System.out.print("2. feladat\n" + "Adja meg a jel sorszámát! ");
        int rowIndex = scanner_.nextInt();
        CoordAtTime coord = coords.get(rowIndex - 1);
        System.out.println("x=" + coord.x + " y=" + coord.y);

        CoordAtTime fistCoord = coords.get(0);
        CoordAtTime lastCoord = coords.get(coords.size() - 1);

        LocalTime fTime = LocalTime.of(fistCoord.hour, fistCoord.minute, fistCoord.seconds);
        LocalTime lTime = LocalTime.of(lastCoord.hour, lastCoord.minute, lastCoord.seconds);
        Duration between = Duration.between(fTime, lTime);

        System.out.println(between.toHoursPart());
        System.out.println(between.toMinutesPart());
        System.out.println(between.toSecondsPart());
        System.out.println();

        System.out.println("4. feladat\nIdőtartam: " + between.toHoursPart() + ":" + between.toMinutesPart() + ":" + between.toSecondsPart());


        IntSummaryStatistics xStat = coords.stream().mapToInt(c -> c.x).summaryStatistics();
        IntSummaryStatistics yStat = coords.stream().mapToInt(c -> c.y).summaryStatistics();

        System.out.println("5. feladat\n" +
                "Bal alsó: " + xStat.getMin() + " " + yStat.getMin() + ", jobb felső:" + xStat.getMax() + " " + yStat.getMax());

        System.out.println();

        double distance = 0;
        for (int i = 0; i < coords.size() - 1; i++) {

            distance += distance(coords.get(i), coords.get(i + 1));

        }

        System.out.printf("6. feladat\n" + "Elmozdulás: %.3f egység\n", distance);

        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("kimaradt.txt")));

        for (int i = 0; i < coords.size() - 1; i++) {

            int timeDiff = 0;
            int moveDiff = 0;

            if (move(coords.get(i), coords.get(i + 1))) {
                //System.out.println("Move: " + coords.get(i) + " - " + coords.get(i + 1));

                int xDiff = Math.abs(coords.get(i).x - coords.get(i + 1).x) / 10;
                int yDiff = Math.abs(coords.get(i).y - coords.get(i + 1).y) / 10;

                moveDiff = (xDiff + yDiff - 1);

            }
            if (time(coords.get(i), coords.get(i + 1))) {
                //System.out.println("Time: " + coords.get(i) + " - " + coords.get(i + 1));
                timeDiff = (int) (Math.abs(coords.get(i).getAsMinutes() - coords.get(i + 1).getAsMinutes()) / 5 - 1);
            }

            if (timeDiff + moveDiff > 0) {

                CoordAtTime coord1 = coords.get(i + 1);
                if (timeDiff > moveDiff) {

                    System.out.println(coord1.hour + " " + coord1.minute + " " + coord1.seconds + " időeltérés " + timeDiff);
                    writer.write(coord1.hour + " " + coord1.minute + " " + coord1.seconds + " időeltérés " + timeDiff+"\n");
                } else {
                    System.out.println(coord1.hour + " " + coord1.minute + " " + coord1.seconds + " koordináta-eltérés " + moveDiff);
                    writer.write(coord1.hour + " " + coord1.minute + " " + coord1.seconds + " koordináta-eltérés " + moveDiff+"\n");
                }
            }


        }
        writer.close();

    }

    public static double distance(CoordAtTime a, CoordAtTime b) {
        double x1 = a.x;
        double y1 = a.y;
        double x2 = b.x;
        double y2 = b.y;

        return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
    }

    public static boolean move(CoordAtTime a, CoordAtTime b) {
        double x1 = a.x;
        double y1 = a.y;
        double x2 = b.x;
        double y2 = b.y;

        return Math.abs(x1 - x2) > 10 || Math.abs(y1 - y2) > 10;
    }

    public static boolean time(CoordAtTime a, CoordAtTime b) {


        return Math.abs(a.getAsMinutes() - b.getAsMinutes()) > 5;
    }
}