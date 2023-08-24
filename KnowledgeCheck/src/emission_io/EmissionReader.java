package emission_io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmissionReader {


    public static List<CarEmissionInfo> readEmissionFromCSV(File file) throws FileNotFoundException {

        List<CarEmissionInfo> carEmissionInfoList = new ArrayList<>();
        Scanner scanner = new Scanner(file);

        scanner.nextLine(); // Skip csv headers

        while (scanner.hasNextLine()) {
            String[] values = scanner.nextLine().split(",");
            String manufacturer = values[0];
            String model = values[1];
            double engineSize = Double.parseDouble(values[3]);
            FuelType fuelType = convertToFuelType(values[6]);
            int co2Emission = Integer.parseInt(values[11]);

            carEmissionInfoList.add(new CarEmissionInfo(
                    manufacturer,
                    model,
                    engineSize,
                    fuelType,
                    co2Emission
            ));
        }


        return carEmissionInfoList;
    }

    private static FuelType convertToFuelType(String fuelTypeAsString) { //Java 17+
        return switch (fuelTypeAsString) {
            case "X" -> FuelType.REGULAR_GASOLINE;
            case "Z" -> FuelType.PREMIUM_GASOLINE;
            case "D" -> FuelType.DIESEL;
            case "E" -> FuelType.E85;
            case "N" -> FuelType.NATURAL_GAS;
            default -> FuelType.UNKNOWN;
        };

    }

    private static FuelType convertToFuelTypeV2(String fuelTypeAsString) { //Java 13+
        return switch (fuelTypeAsString) {
            case "X":
                yield FuelType.REGULAR_GASOLINE;
            case "Z":
                yield FuelType.PREMIUM_GASOLINE;
            case "D":
                yield FuelType.DIESEL;
            case "E":
                yield FuelType.E85;
            case "N":
                yield FuelType.NATURAL_GAS;
            default:
                yield FuelType.UNKNOWN;
        };


    }

    private static FuelType convertToFuelTypeV3(String fuelTypeAsString) { //Java 8+
        switch (fuelTypeAsString) {
            case "X":
                return FuelType.REGULAR_GASOLINE;
            case "Z":
                return FuelType.PREMIUM_GASOLINE;
            case "D":
                return FuelType.DIESEL;
            case "E":
                return FuelType.E85;
            case "N":
                return FuelType.NATURAL_GAS;
            default:
                return FuelType.UNKNOWN;
        }
    }


}
