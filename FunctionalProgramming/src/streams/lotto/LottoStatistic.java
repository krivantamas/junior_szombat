package streams.lotto;

import java.util.Set;

public class LottoStatistic {

    private final int year;
    private final int week;
    private final long maxPayout;

    private final Set<Integer> numbers;


    public LottoStatistic(int year, int week, long maxPayout, Set<Integer> numbers) {
        this.year = year;
        this.week = week;
        this.maxPayout = maxPayout;
        this.numbers = numbers;
    }

    public int getYear() {
        return year;
    }

    public int getWeek() {
        return week;
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    public long getMaxPayout() {
        return maxPayout;
    }

    @Override
    public String toString() {
        return "LottoStatistic{" +
                "year=" + year +
                ", week=" + week +
                ", maxPayout=" + maxPayout +
                ", numbers=" + numbers +
                '}';
    }
}
