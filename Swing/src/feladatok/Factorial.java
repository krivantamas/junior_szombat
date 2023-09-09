package feladatok;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Factorial extends JFrame {

	private JPanel contentPane;
	private JTextField inputField;
	private JLabel outputLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Factorial frame = new Factorial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Factorial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblNewLabel = new JLabel("Adj meg egy pozit\u00EDv eg\u00E9sz sz\u00E1mot");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		inputField = new JTextField();
		inputField.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				update();

			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				update();

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				update();

			}

			private void update() {
				showFactorial();
			}
		});
		GridBagConstraints gbc_inputField = new GridBagConstraints();
		gbc_inputField.insets = new Insets(0, 0, 5, 0);
		gbc_inputField.fill = GridBagConstraints.HORIZONTAL;
		gbc_inputField.gridx = 1;
		gbc_inputField.gridy = 0;
		contentPane.add(inputField, gbc_inputField);
		inputField.setColumns(10);

		outputLabel = new JLabel("A szám faktoriálisa: -");
		GridBagConstraints gbc_outputLabel = new GridBagConstraints();
		gbc_outputLabel.insets = new Insets(0, 0, 5, 0);
		gbc_outputLabel.gridwidth = 2;
		gbc_outputLabel.gridx = 0;
		gbc_outputLabel.gridy = 1;
		contentPane.add(outputLabel, gbc_outputLabel);

		JButton btnNewButton = new JButton("Calculate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String inputString = inputField.getText();
				try {

					int number = Integer.parseInt(inputString);
					assertPositive(number);
					
					outputLabel.setText("A szám faktoriálisa: *" + factorialUsingForLoop(number)+"*");

				} catch (Exception ex) {
					outputLabel.setText("A szám faktoriálisa: -");
					JOptionPane.showMessageDialog(Factorial.this, "Kérem adjon meg valid inputot!","",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.SOUTH;
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 2;
		contentPane.add(btnNewButton, gbc_btnNewButton);
	}

	private void showFactorial() {
		String inputString = inputField.getText();
		try {

			int number = Integer.parseInt(inputString);
			assertPositive(number);
			
			outputLabel.setText("A szám faktoriálisa: " + factorialUsingForLoop(number));

		} catch (Exception e) {
			outputLabel.setText("A szám faktoriálisa: -");
		}
	}

	public long factorialUsingForLoop(int n) {
		long fact = 1;
		for (int i = 2; i <= n; i++) {
			fact = fact * i;
		}
		return fact;
	}
	
	private void assertPositive(int number) {
		
		if(number<1) {
			throw new IllegalArgumentException("Input number must be positive!");
		}
		
	}

}
