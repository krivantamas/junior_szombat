import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class PrimeChecker {

    private static boolean isPrime() {
        return true;
    }

    public static void assertPrime(int number) {
        System.out.println(number + " - is prime: " + isPrime());
    }


    public static void main(String... args) {

        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        numbers.forEach(PrimeChecker::assertPrime);
        numbers.forEach(word -> assertPrime(word));
        numbers.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {

            }
        });

    }
}
