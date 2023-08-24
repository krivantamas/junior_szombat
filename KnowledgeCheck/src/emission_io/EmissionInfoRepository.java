package emission_io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class EmissionInfoRepository {

    private final List<CarEmissionInfo> carEmissionInfoList = EmissionReader.readEmissionFromCSV(new File("src\\emission_io\\emission.csv"));

    public EmissionInfoRepository() throws FileNotFoundException {

    }


    public int getMinCo2Emission() {

        int MIN_VALUE = Integer.MAX_VALUE;
        for (CarEmissionInfo carEmissionInfo : carEmissionInfoList) {

            if (carEmissionInfo.getCo2Emission() < MIN_VALUE) {
                MIN_VALUE = carEmissionInfo.getCo2Emission();
            }

        }

        return MIN_VALUE;
    }

    public int getMaxCo2Emission() {
        return carEmissionInfoList.stream().mapToInt(CarEmissionInfo::getCo2Emission).max().getAsInt();
    }

    public int getUniqueEngineSizeCount() {

        List<Double> engineSizes = new ArrayList<>();

        for (CarEmissionInfo carEmissionInfo : carEmissionInfoList) {
            if (!engineSizes.contains(carEmissionInfo.getEngineSize())) {
                engineSizes.add(carEmissionInfo.getEngineSize());
            }
        }

        return engineSizes.size();
    }

    public int getUniqueEngineSizeCountV2() {

        Set<Double> engineSizes = new HashSet<>();

        for (CarEmissionInfo carEmissionInfo : carEmissionInfoList) {
            engineSizes.add(carEmissionInfo.getEngineSize());
        }

        return engineSizes.size();
    }

    public List<String> getAllManufacturer() {
        Set<String> manufacturers = new TreeSet<>();

        for (CarEmissionInfo carEmissionInfo : carEmissionInfoList) {
            manufacturers.add(carEmissionInfo.getManufacturer());
        }

        return new ArrayList<>(manufacturers);
    }

    public List<CarEmissionInfo> getAllEmissionInfoByEngineSize(double engineSize) {
        List<CarEmissionInfo> emissionInfosByEngineSize = new ArrayList<>();
        for (CarEmissionInfo carEmissionInfo : carEmissionInfoList) {
            if(carEmissionInfo.getEngineSize() == engineSize){
                emissionInfosByEngineSize.add(carEmissionInfo);
            }
        }
        return emissionInfosByEngineSize;
    }
}
