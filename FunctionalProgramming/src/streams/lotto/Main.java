package streams.lotto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    private static LottoStatistic parseLottoStatistic(String line) {
        String[] values = line.strip().split(";");

        int year = Integer.parseInt(values[0]);
        int week = Integer.parseInt(values[1]);
        long maxPayout = Stream.of(values[4], values[6], values[8], values[10]).mapToLong(Main::parseFieldToLong).max().orElse(0);
        Set<Integer> numbers = Stream.of(values[11], values[12], values[13], values[14], values[15]).map(Integer::parseInt).collect(Collectors.toSet());

        return new LottoStatistic(year, week, maxPayout, numbers);
    }

    private static long parseFieldToLong(String str) {
        return Long.parseLong(str.replaceAll(" ", "").replaceAll("Ft", ""));
    }

    public static void main(String... args) {

        List<LottoStatistic> lottoStatisticList = new ArrayList<>();

        try {
            File file = new File("W:\\Webler\\Materials\\Git\\junior_szombat\\FunctionalProgramming\\src\\streams\\lotto\\otos.csv");
            Scanner scanner = new Scanner(file);

            scanner.nextLine(); // Skip headers
            lottoStatisticList = scanner.useDelimiter("\n").tokens().map(Main::parseLottoStatistic).toList();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        System.out.println(getNumbers(lottoStatisticList, 2030, 25));
        highestPrize(lottoStatisticList);
        System.out.println("==");
        highestPrizes(lottoStatisticList);
        System.out.println("==");
        System.out.println(myNumbers(lottoStatisticList, Set.of(64, 33, 50, 20, 39)));
        System.out.println("==");
        System.out.println("mostFrequentNumber: " + mostFrequentNumber(lottoStatisticList));
        System.out.println("leastFrequentNumber: " + leastFrequentNumber(lottoStatisticList));
        numberStatistics_2(lottoStatisticList);
    }

    private static Set<Integer> getNumbers(List<LottoStatistic> lottoStatisticList, int year, int week) {

        return lottoStatisticList.stream()
                .filter(lottoStatistic -> lottoStatistic.getYear() == year && lottoStatistic.getWeek() == week)
                .findFirst()
                .orElse(new LottoStatistic(0, 0, 0, Collections.emptySet()))
                .getNumbers();

        /* Stream nélkül
        for (LottoStatistic lottoStatistic : lottoStatisticList) {
            if (lottoStatistic.getYear() == year && lottoStatistic.getWeek() == week) {
                return lottoStatistic.getNumbers();
            }
        }

        return Collections.emptySet();

        */
    }

    private static void highestPrize(List<LottoStatistic> lottoStatisticList) {

        LottoStatistic max = lottoStatisticList
                .stream()
                .max(Comparator.comparingLong(LottoStatistic::getMaxPayout))
                .orElseThrow(NoSuchElementException::new);

        System.out.println("Legnagyobb kifizetés: " + max);

        /*
        LottoStatistic maxPayoutLottoStatistic = null;
        long maxValue = Long.MIN_VALUE;
        for (LottoStatistic lottoStatistic:lottoStatisticList){

            if(lottoStatistic.getMaxPayout() > maxValue){
                maxValue = lottoStatistic.getMaxPayout();
                maxPayoutLottoStatistic = lottoStatistic;
            }

        }
        */
    }

    private static void highestPrizes(List<LottoStatistic> lottoStatisticList) {
        lottoStatisticList
                .stream()
                .sorted(Comparator.comparingLong(LottoStatistic::getMaxPayout).reversed())
                .limit(5)
                .forEach(System.out::println);

    }

    private static long myNumbers(List<LottoStatistic> lottoStatisticList, Set<Integer> numbers) {

        return lottoStatisticList
                .stream()
                .filter(lottoStatistic -> lottoStatistic.getNumbers().equals(numbers))
                .count();
    }

    private static int mostFrequentNumber(List<LottoStatistic> lottoStatisticList) {

        return numberStatistics(lottoStatisticList)
                .entrySet()
                .stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .orElse(Map.entry(-1, 0L))
                .getKey();

    /*
    int[] numbers = new int[90];

        for (LottoStatistic lottoStatistic: lottoStatisticList){
            for(Integer number: lottoStatistic.getNumbers()){

                numbers[number-1]++;

            }
        }
    */

    }

    private static int leastFrequentNumber(List<LottoStatistic> lottoStatisticList) {
        return numberStatistics(lottoStatisticList)
                .entrySet()
                .stream()
                .min(Comparator.comparingLong(Map.Entry::getValue))
                .orElse(Map.entry(-1, 0L))
                .getKey();

    }

    private static Map<Integer, Long> numberStatistics(List<LottoStatistic> lottoStatisticList) {
        return lottoStatisticList
                .stream()
                .flatMap(lottoStatistic -> lottoStatistic.getNumbers().stream())
                .collect(Collectors.groupingBy(number -> number, Collectors.counting()));

    }

    private static Map<Integer, String> numberStatistics_2(List<LottoStatistic> lottoStatisticList) {

        Map<Integer, List<String>> collect = lottoStatisticList
                .stream()
                .collect(Collectors.toMap(key -> key.getYear() + " " + key.getWeek(), asd -> asd.getNumbers())).entrySet().stream()
                .map(stringSetEntry -> {
                    Set<Map.Entry<String, Integer>> asd = new HashSet();
                    for (Integer num : stringSetEntry.getValue()) {

                        asd.add(Map.entry(stringSetEntry.getKey(), num));
                    }
                    return asd;

                })
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(o -> o.getValue(), Collectors.toList()))
                .entrySet()
                .stream()
                .map(integerListEntry -> {
                    return Map.entry(integerListEntry.getKey(), integerListEntry.getValue().stream().map(valami -> valami.getKey()).toList());
                }).collect(Collectors.toMap(asd -> asd.getKey(), asd -> asd.getValue()));


        return null;
    }
}
