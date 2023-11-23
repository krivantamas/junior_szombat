package streams;

import java.util.Optional;

public class OptionalDemo {

    private static String createString(){
        System.out.println("createString() was called!");
        return "New String";

    }

    public static void main(String... args) {

        Optional<String> emptyOptional=Optional.empty(); //
        Optional<String> nonEmptyOptional=Optional.of("Hello, Optional!"); //
        Optional<String> nullOptional=Optional.ofNullable(null); //
        Optional<String> nullOptional_=Optional.ofNullable("Hello, Optional!"); //



        Optional<String> optional = nonEmptyOptional;


        optional.ifPresent(s -> System.out.println("Az érték: " + s));


        String value = optional.orElse(createString());
        System.out.println("====");
        String value_2 = optional.orElseGet(() -> createString());

    }
}
