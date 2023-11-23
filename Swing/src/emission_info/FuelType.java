package emission_info;

public enum FuelType {

	REGULAR_GASOLINE, // X
	PREMIUM_GASOLINE, // Z
	DIESEL, // D
	E85, // E
	NATURAL_GAS, // N
	UNKNOWN;

	public static FuelType parseFueltype(String s) {
		switch (s.toUpperCase()) {
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
