package feladatok;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class Dice extends JFrame {

    private JPanel contentPane;
    private JComboBox diceComboBox;
    private JSpinner diceCount;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Dice frame = new Dice();
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
    public Dice() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[] { 0, 0, 0 };
        gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0 };
        gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
        gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
        contentPane.setLayout(gbl_contentPane);

        JLabel lblNewLabel = new JLabel("Kock\u00E1k t\u00EDpusa");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 0;
        contentPane.add(lblNewLabel, gbc_lblNewLabel);

        diceComboBox = new JComboBox();
        diceComboBox.setModel(new DefaultComboBoxModel(new String[] { "D4", "D6", "D8", "D12" }));
        GridBagConstraints gbc_diceComboBox = new GridBagConstraints();
        gbc_diceComboBox.insets = new Insets(0, 0, 5, 0);
        gbc_diceComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_diceComboBox.gridx = 1;
        gbc_diceComboBox.gridy = 0;
        contentPane.add(diceComboBox, gbc_diceComboBox);

        JLabel lblNewLabel_1 = new JLabel("Kock\u00E1k sz\u00E1ma");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 0;
        gbc_lblNewLabel_1.gridy = 1;
        contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);

        diceCount = new JSpinner();
        diceCount.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        GridBagConstraints gbc_diceCount = new GridBagConstraints();
        gbc_diceCount.fill = GridBagConstraints.HORIZONTAL;
        gbc_diceCount.insets = new Insets(0, 0, 5, 0);
        gbc_diceCount.gridx = 1;
        gbc_diceCount.gridy = 1;
        contentPane.add(diceCount, gbc_diceCount);

        JButton btnNewButton = new JButton("Dob\u00E1s");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rolldice();
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

    private void rolldice() {

        int diceType = 0;
        switch (diceComboBox.getSelectedItem().toString()){
            case "D4":
                diceType =  4;
                break;
            case "D6":
                diceType =  6;
                break;
            case "D8":
                diceType =  8;
                break;
            case "D12":
                diceType =  12;
                break;
            default:
                throw new IllegalArgumentException("Unexpected value: " + diceComboBox.getSelectedItem().toString());
        };

        int _diceCount = (int) diceCount.getValue();

        JOptionPane.showMessageDialog(this, "A kapott érték: " + calculateDiceValue(diceType, _diceCount));

    }

    private int calculateDiceValue(int dType, int dCount) {

        Random random = new Random();
        int diceSum = 0;
        for(int i = 0; i < dCount;i++) {

            diceSum += random.nextInt(1, dType+1);

        }



        return diceSum;

    }

}
