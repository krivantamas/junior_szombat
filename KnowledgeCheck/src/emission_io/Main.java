package emission_io;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        EmissionReader.readEmissionFromCSV(new File("src\\emission_io\\emission.csv"));

    }
}
