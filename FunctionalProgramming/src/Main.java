import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Bicycle {

    private String brand;
    private Integer frameSize;

    public Bicycle(String brand, Integer frameSize) {
        this.brand = brand;
        this.frameSize = frameSize;
    }

    public Bicycle(String brand) {
        this.brand = brand;
        this.frameSize = 0;
    }

    public Integer getFrameSize() {
        return frameSize;
    }
}

class BicycleComparator implements Comparator<Bicycle> {

    @Override
    public int compare(Bicycle a, Bicycle b) {
        return a.getFrameSize().compareTo(b.getFrameSize());
    }

}

public class Main {
    public static void main (String... args){
        List<String> messages = Arrays.asList("hello", "backend", "csoport!");
        messages.forEach(System.out::println);

        BicycleComparator bikeFrameSizeComparator = new BicycleComparator();
        List<Bicycle> bicycleList = Arrays.asList(
                new Bicycle("MTK", 28),
                new Bicycle("TREK", 26),
                new Bicycle("FUJI", 28),
                new Bicycle("KONA", 26)
        );

        bicycleList.stream().sorted(bikeFrameSizeComparator::compare);

        List<Integer> numbers = Arrays.asList(5, 3, 50, 24, 40, 2, 9, 18);
        numbers.stream().sorted(Integer::compareTo);



        List<String> bikeBrands = Arrays.asList("Giant", "Scott", "Trek", "GT");
        bikeBrands.stream().map(Bicycle::new).toList();


    }
}
