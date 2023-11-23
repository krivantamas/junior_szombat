package demo_frame;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class RandomEvent implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("almafa");

    }

}

public class ElsoFrame extends JFrame {



    private JPanel contentPane;
    private JTextField textField;
    private JComboBox comboBox;
    private JCheckBox chckbxNewCheckBox;
    private JPanel panel;
    private JRadioButton rdbtnNewRadioButton;
    private JRadioButton rdbtnNewRadioButton_1;
    private JRadioButton rdbtnNewRadioButton_2;
    private JSpinner spinner;
    private JButton btnNewButton;
    private final ButtonGroup buttonGroup = new ButtonGroup();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {

        ElsoFrame frame = new ElsoFrame();
        frame.setVisible(true);

    }

    /**
     * Create the frame.
     */
    public ElsoFrame() {
        setTitle("TesztFrame");
        setBackground(Color.RED);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{80, 0, 0};
        gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
        gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);

        JLabel lblNewLabel = new JLabel("New label asdasd");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 0;
        contentPane.add(lblNewLabel, gbc_lblNewLabel);

        textField = new JTextField();
        textField.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void removeUpdate(DocumentEvent e) {
                printText();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                printText();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                printText();
            }

            private void printText() {
                System.out.println(textField.getText());
            }
        });


        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.insets = new Insets(0, 0, 5, 0);
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 1;
        gbc_textField.gridy = 0;
        contentPane.add(textField, gbc_textField);
        textField.setColumns(10);

        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Alma","Körte","Szilva"}));


        GridBagConstraints gbc_comboBox = new GridBagConstraints();
        gbc_comboBox.insets = new Insets(0, 0, 5, 0);
        gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBox.gridx = 1;
        gbc_comboBox.gridy = 1;
        contentPane.add(comboBox, gbc_comboBox);

        chckbxNewCheckBox = new JCheckBox("New check box");
        chckbxNewCheckBox.setSelected(true);
        GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
        gbc_chckbxNewCheckBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 0);
        gbc_chckbxNewCheckBox.gridx = 1;
        gbc_chckbxNewCheckBox.gridy = 2;
        contentPane.add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);



        panel = new JPanel();
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.fill = GridBagConstraints.HORIZONTAL;
        gbc_panel.insets = new Insets(0, 0, 5, 0);
        gbc_panel.gridx = 1;
        gbc_panel.gridy = 3;
        contentPane.add(panel, gbc_panel);

        rdbtnNewRadioButton_1 = new JRadioButton("1");
        rdbtnNewRadioButton_1.setActionCommand("1 Command");
        rdbtnNewRadioButton_1.setSelected(true);
        buttonGroup.add(rdbtnNewRadioButton_1);
        panel.add(rdbtnNewRadioButton_1);

        rdbtnNewRadioButton = new JRadioButton("2");
        rdbtnNewRadioButton.setActionCommand("2 Command");
        buttonGroup.add(rdbtnNewRadioButton);
        panel.add(rdbtnNewRadioButton);

        rdbtnNewRadioButton_2 = new JRadioButton("3");
        buttonGroup.add(rdbtnNewRadioButton_2);
        rdbtnNewRadioButton_2.setActionCommand("3 Command");
        panel.add(rdbtnNewRadioButton_2);


        spinner = new JSpinner();
        spinner.setModel(new SpinnerNumberModel(Integer.valueOf(100), Integer.valueOf(0), null, Integer.valueOf(1)));
        GridBagConstraints gbc_spinner = new GridBagConstraints();
        gbc_spinner.fill = GridBagConstraints.HORIZONTAL;
        gbc_spinner.insets = new Insets(0, 0, 5, 0);
        gbc_spinner.gridx = 1;
        gbc_spinner.gridy = 4;
        contentPane.add(spinner, gbc_spinner);


        btnNewButton = new JButton("New button");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                System.out.println("Katt");
                System.out.println(buttonGroup.getSelection().getActionCommand());
                System.out.println(comboBox.getSelectedItem());
                System.out.println(chckbxNewCheckBox.isSelected());
                System.out.println(textField.getText());
                System.out.println(spinner.getModel().getValue());;



            }
        });
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.anchor = GridBagConstraints.SOUTHEAST;
        gbc_btnNewButton.gridheight = 2;
        gbc_btnNewButton.gridwidth = 2;
        gbc_btnNewButton.gridx = 0;
        gbc_btnNewButton.gridy = 7;
        contentPane.add(btnNewButton, gbc_btnNewButton);

    }

}
