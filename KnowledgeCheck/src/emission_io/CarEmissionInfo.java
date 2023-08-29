package emission_io;

import java.util.Objects;

public class CarEmissionInfo {

    private final String manufacturer;
    private final String model;
    private final double engineSize;
    private final FuelType fuelType;
    private final int co2Emission;


    public CarEmissionInfo(String manufacturer, String model, double engineSize, FuelType fuelType, int co2Emission) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.engineSize = engineSize;
        this.fuelType = fuelType;
        this.co2Emission = co2Emission;
    }


    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public double getEngineSize() {
        return engineSize;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public int getCo2Emission() {
        return co2Emission;
    }

    @Override
    public String toString() {
        return "CarEmissionInfo{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", engineSize=" + engineSize +
                ", fuelType=" + fuelType +
                ", co2Emission=" + co2Emission +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarEmissionInfo that = (CarEmissionInfo) o;
        return Double.compare(that.engineSize, engineSize) == 0 && co2Emission == that.co2Emission && Objects.equals(manufacturer, that.manufacturer) && Objects.equals(model, that.model) && fuelType == that.fuelType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturer, model, engineSize, fuelType, co2Emission);
    }
}
