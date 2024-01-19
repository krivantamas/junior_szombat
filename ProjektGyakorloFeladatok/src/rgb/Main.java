package rgb;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static class Pixel {

        int r;
        int g;
        int b;

        public Pixel(int r, int g, int b) {
            this.r = r;
            this.g = g;
            this.b = b;
        }

        public int getIntensity() {
            return r + g + b;
        }

        public boolean isLight() {
            return (r + g + b) > 600;
        }

        @Override
        public String toString() {
            return "RGB(" + r + "," + g + "," + b + ")";
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Hello world!");

        List<List<Pixel>> image = new ArrayList<>();

        Scanner scanner = new Scanner(new File("W:\\Webler\\Materials\\Git\\junior_szombat\\ProjektGyakorloFeladatok\\src\\rgb\\kep.txt"));

        List<Pixel> row = null;
        while (scanner.hasNextLine()) {
            row = new ArrayList<>();
            String line = scanner.nextLine();
            int[] values = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int i = 0; i < 640; i++) {

                row.add(new Pixel(values[i * 3], values[i * 3 + 1], values[i * 3 + 2]));
            }

            image.add(row);
        }

        System.out.println("2. feladat:\n" +
                "Kérem egy képpont adatait!");

        Scanner scanner_ = new Scanner(System.in);
        System.out.print("Sor:");
        int rowIndex = scanner_.nextInt();
        System.out.print("Oszlop:");
        int colIndex = scanner_.nextInt();

        Pixel selectedPixel = image.get(rowIndex - 1).get(colIndex - 1);
        System.out.println("A képpont színe RGB(" + selectedPixel.r + "," + selectedPixel.g + "," + selectedPixel.b + ")");


        long lightPixelCount = image.stream().flatMap(Collection::stream).filter(Pixel::isLight).count();

        System.out.println("3. feladat:\n" +
                "A világos képpontok száma: " + lightPixelCount);


        Integer lowestIntensity = image.stream().flatMap(Collection::stream).map(Pixel::getIntensity).min(Integer::compareTo).get();
        System.out.println("4. feladat:\n" +
                "A legsötétebb pont RGB összege: " + lowestIntensity + "\n" +
                "A legsötétebb pixelek színe:");
        image.stream().flatMap(Collection::stream).filter(pixel -> pixel.getIntensity() == lowestIntensity).forEach(System.out::println);

        int minIntensity = Integer.MAX_VALUE;
        for (int i = 0; i < image.size(); i++) {
            for (int j = 0; j < image.get(i).size(); j++) {

                int intensity = image.get(i).get(j).getIntensity();
                if (intensity < minIntensity) {
                    minIntensity = intensity;
                }
            }
        }

        for (int i = 0; i < image.size(); i++) {
            for (int j = 0; j < image.get(i).size(); j++) {

                Pixel pixel = image.get(i).get(j);
                if (pixel.getIntensity() == minIntensity) {
                    System.out.println(pixel);
                }
            }
        }

        hasBorder(image.get(10), 10);


        IntSummaryStatistics intSummaryStatistics = IntStream.range(0, image.size())
                .filter(rowIndex_ -> hasBorder(image.get(rowIndex_), 10))
                .summaryStatistics();

        System.out.println("6. feladat:\n" +
                "A felhő legfelső sora: " + (intSummaryStatistics.getMin() + 1) + "\n" +
                "A felhő legalsó sora: " + (intSummaryStatistics.getMax() + 1) + " ");


        List<Integer> rowsWithBorder = new ArrayList<>();

        for (int i = 0; i < image.size(); i++) {
            if (hasBorder(image.get(i), 10)) {
                rowsWithBorder.add(i);
            }
        }

        System.out.println(rowsWithBorder.get(0) + 1);
        System.out.println(rowsWithBorder.get(rowsWithBorder.size() - 1) + 1);


    }

    public static boolean hasBorder(List<Pixel> row, int maxDifference) {
        for (int i = 0; i < row.size() - 1; i++) {
            int diff = Math.abs(row.get(i).b - row.get(i + 1).b);
            if (diff > maxDifference) {
                return true;
            }
        }
        return false;
    }
}