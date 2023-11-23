package emission_info;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		
		List<CarEmissionInfo> carEmissionInfos = readCarEmissionData(new File("src/emission.csv"));
		
		
		EmissionView view = new EmissionView(carEmissionInfos);
		view.setVisible(true);

	}

	private static List<CarEmissionInfo> readCarEmissionData(File file) {
		List<CarEmissionInfo> carEmissionInfos = new ArrayList<>();
		try {
			Scanner scanner = new Scanner(file);
			
			if(scanner.hasNextLine()) {
				scanner.nextLine(); // Skip headers
			}
			while(scanner.hasNextLine()) {
				String[] values = scanner.nextLine().split(",");
				
				String manufacturer = values[0];
			    String model = values[1];
			    double engineSize = Double.parseDouble(values[3]);
			    FuelType fuelType = FuelType.parseFueltype(values[6]);
			    int co2Emission = Integer.parseInt(values[11]);
				
			    carEmissionInfos.add(new CarEmissionInfo(manufacturer, model, engineSize, fuelType, co2Emission));	
			}
			
		} catch (FileNotFoundException e) {
			System.err.println("Fájl nem található!");
		}finally {
			return carEmissionInfos;
		}
	}

}
