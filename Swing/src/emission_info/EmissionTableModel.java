package emission_info;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import quiz.User;

public class EmissionTableModel extends AbstractTableModel {

	private static final String[] EMISSION_TABLE_HEADERS = new String[] { "Make", "Model", "Engine Size(L)",
			"Fuel Type", "CO2 Emissions(g/km)" };
	private final List<CarEmissionInfo> carEmissionInfos;
	
	

	public EmissionTableModel(List<CarEmissionInfo> carEmissionInfos) {
		super();
		this.carEmissionInfos = carEmissionInfos;
	}

	@Override
	public int getRowCount() {
		return carEmissionInfos.size();
	}

	@Override
	public int getColumnCount() {
		return EMISSION_TABLE_HEADERS.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		if(columnIndex == 0) {
			return carEmissionInfos.get(rowIndex).getManufacturer();
		}
		if(columnIndex == 1) {
			return carEmissionInfos.get(rowIndex).getModel();
		}
		if(columnIndex == 2) {
			return carEmissionInfos.get(rowIndex).getEngineSize();
		}
		if(columnIndex == 3) {
			return carEmissionInfos.get(rowIndex).getFuelType();
		}
		if(columnIndex == 4) {
			return carEmissionInfos.get(rowIndex).getCo2Emission();
		}
		
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
		return EMISSION_TABLE_HEADERS[column];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

}
