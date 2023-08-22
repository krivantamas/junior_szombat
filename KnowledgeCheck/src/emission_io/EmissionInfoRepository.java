package emission_io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class EmissionInfoRepository {

    private final List<CarEmissionInfo> carEmissionInfoList = EmissionReader.readEmissionFromCSV(new File("src\\emission_io\\emission.csv"));

    public EmissionInfoRepository() throws FileNotFoundException {

    }


    public int getMinCo2Emission() {
        //TODO
        return 0;
    }

    public int getMaxCo2Emission() {
        //TODO
        return 0;
    }

    public int getUniqueEngineSizeCount() {
        //TODO
        return 0;
    }

    public List<String> getAllManufacturer() {
        //TODO
        return null;
    }

    public List<CarEmissionInfo> getAllEmissionInfoByEngineSize(double engineSize) {
        //TODO
        return null;
    }
}
