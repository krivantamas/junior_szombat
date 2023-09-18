package emission_info;

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
		return "CarEmissionInfo [manufacturer=" + manufacturer + ", model=" + model + ", engineSize=" + engineSize
				+ ", fuelType=" + fuelType + ", co2Emission=" + co2Emission + "]";
	}

    
    
}
