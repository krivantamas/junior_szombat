package emission_io;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        EmissionInfoRepository repository = new EmissionInfoRepository();

        System.out.println(repository.getMinCo2Emission());
        System.out.println(repository.getMaxCo2Emission());
        System.out.println(repository.getUniqueEngineSizeCount());
        System.out.println(repository.getUniqueEngineSizeCountV2());
        System.out.println(repository.getAllManufacturer());
        System.out.println(repository.getAllEmissionInfoByEngineSize(2.0));

    }
}
