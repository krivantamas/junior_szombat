package emission_info;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmissionInfoFormDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField makeInputField;
	private JTextField modelInputField;
	private JTextField engineSizeInputField;
	private JComboBox fuelTypeComboBox;
	private JSpinner co2EmissionInputField;

	
	public EmissionInfoFormDialog(EmissionView emissionView) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("Make");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			makeInputField = new JTextField();
			GridBagConstraints gbc_makeInputField = new GridBagConstraints();
			gbc_makeInputField.insets = new Insets(0, 0, 5, 0);
			gbc_makeInputField.fill = GridBagConstraints.HORIZONTAL;
			gbc_makeInputField.gridx = 1;
			gbc_makeInputField.gridy = 0;
			contentPanel.add(makeInputField, gbc_makeInputField);
			makeInputField.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Model");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 1;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			modelInputField = new JTextField();
			GridBagConstraints gbc_modelInputField = new GridBagConstraints();
			gbc_modelInputField.insets = new Insets(0, 0, 5, 0);
			gbc_modelInputField.fill = GridBagConstraints.HORIZONTAL;
			gbc_modelInputField.gridx = 1;
			gbc_modelInputField.gridy = 1;
			contentPanel.add(modelInputField, gbc_modelInputField);
			modelInputField.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Engine Size(L)");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 0;
			gbc_lblNewLabel_2.gridy = 2;
			contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			engineSizeInputField = new JTextField();
			GridBagConstraints gbc_engineSizeInputField = new GridBagConstraints();
			gbc_engineSizeInputField.insets = new Insets(0, 0, 5, 0);
			gbc_engineSizeInputField.fill = GridBagConstraints.HORIZONTAL;
			gbc_engineSizeInputField.gridx = 1;
			gbc_engineSizeInputField.gridy = 2;
			contentPanel.add(engineSizeInputField, gbc_engineSizeInputField);
			engineSizeInputField.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Fuel Type");
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3.gridx = 0;
			gbc_lblNewLabel_3.gridy = 3;
			contentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		}
		{
			fuelTypeComboBox = new JComboBox();
			fuelTypeComboBox.setModel(new DefaultComboBoxModel(FuelType.values()));
			GridBagConstraints gbc_fuelTypeComboBox = new GridBagConstraints();
			gbc_fuelTypeComboBox.insets = new Insets(0, 0, 5, 0);
			gbc_fuelTypeComboBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_fuelTypeComboBox.gridx = 1;
			gbc_fuelTypeComboBox.gridy = 3;
			contentPanel.add(fuelTypeComboBox, gbc_fuelTypeComboBox);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("CO2 Emissions(g/km)");
			GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
			gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_4.gridx = 0;
			gbc_lblNewLabel_4.gridy = 4;
			contentPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		}
		{
			co2EmissionInputField = new JSpinner();
			GridBagConstraints gbc_co2EmissionInputField = new GridBagConstraints();
			gbc_co2EmissionInputField.fill = GridBagConstraints.HORIZONTAL;
			gbc_co2EmissionInputField.gridx = 1;
			gbc_co2EmissionInputField.gridy = 4;
			contentPanel.add(co2EmissionInputField, gbc_co2EmissionInputField);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String manufacturer = makeInputField.getText();
					    String model = modelInputField.getText();
					    double engineSize = Double.parseDouble(engineSizeInputField.getText());
					    FuelType fuelType = (FuelType) fuelTypeComboBox.getSelectedItem();
					    int co2Emission = (int) co2EmissionInputField.getValue();
						
						emissionView.addCarEmissionInfo(new CarEmissionInfo(manufacturer, model, engineSize, fuelType, co2Emission));
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
