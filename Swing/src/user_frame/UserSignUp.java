package user_frame;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class User {

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
    private final String sex;
    private final int yearOfBirth;

    public User(String firstName, String lastName, String email, String password, String sex, int yearOfBirth) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.sex = sex;
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String toString() {
        return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password
                + ", sex=" + sex + ", yearOfBirth=" + yearOfBirth + "]";
    }

}

public class UserSignUp extends JFrame {

    private JPanel contentPane;
    private JTextField lastNameField;
    private JTextField firstNameField;
    private JTextField emailField;
    private JPasswordField password_1Field;
    private JPasswordField password_2Field;
    private final ButtonGroup buttonGroup = new ButtonGroup();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {

        UserSignUp frame = new UserSignUp();
        frame.setVisible(true);

    }

    /**
     * Create the frame.
     */

    public UserSignUp() {
        initComponents();
    }

    private void register(User user) {
        System.out.println("Sikeres regisztráció: " + user.toString());
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[] { 500, 10, 0 };
        gbl_contentPane.rowHeights = new int[] { 10, 0, 0 };
        gbl_contentPane.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
        gbl_contentPane.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
        contentPane.setLayout(gbl_contentPane);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(
                new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "UserInfo",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.insets = new Insets(0, 0, 5, 0);
        gbc_panel.gridwidth = 2;
        gbc_panel.fill = GridBagConstraints.BOTH;
        gbc_panel.gridx = 0;
        gbc_panel.gridy = 0;
        contentPane.add(panel, gbc_panel);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[] { 100, 200, 200, 0 };
        gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
        gbl_panel.columnWeights = new double[] { 0.0, 1.0, 1.0, Double.MIN_VALUE };
        gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
        panel.setLayout(gbl_panel);

        JLabel lblNewLabel = new JLabel("Lastname");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 0;
        panel.add(lblNewLabel, gbc_lblNewLabel);

        lastNameField = new JTextField();
        GridBagConstraints gbc_lastNameField = new GridBagConstraints();
        gbc_lastNameField.gridwidth = 2;
        gbc_lastNameField.insets = new Insets(0, 0, 5, 0);
        gbc_lastNameField.fill = GridBagConstraints.HORIZONTAL;
        gbc_lastNameField.gridx = 1;
        gbc_lastNameField.gridy = 0;
        panel.add(lastNameField, gbc_lastNameField);
        lastNameField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Firstname");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 0;
        gbc_lblNewLabel_1.gridy = 1;
        panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

        firstNameField = new JTextField();
        GridBagConstraints gbc_firstNameField = new GridBagConstraints();
        gbc_firstNameField.gridwidth = 2;
        gbc_firstNameField.insets = new Insets(0, 0, 5, 0);
        gbc_firstNameField.fill = GridBagConstraints.HORIZONTAL;
        gbc_firstNameField.gridx = 1;
        gbc_firstNameField.gridy = 1;
        panel.add(firstNameField, gbc_firstNameField);
        firstNameField.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Email");
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_2.gridx = 0;
        gbc_lblNewLabel_2.gridy = 2;
        panel.add(lblNewLabel_2, gbc_lblNewLabel_2);

        emailField = new JTextField();
        GridBagConstraints gbc_emailField = new GridBagConstraints();
        gbc_emailField.gridwidth = 2;
        gbc_emailField.insets = new Insets(0, 0, 5, 0);
        gbc_emailField.fill = GridBagConstraints.HORIZONTAL;
        gbc_emailField.gridx = 1;
        gbc_emailField.gridy = 2;
        panel.add(emailField, gbc_emailField);
        emailField.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("Password");
        GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
        gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_3.gridx = 0;
        gbc_lblNewLabel_3.gridy = 3;
        panel.add(lblNewLabel_3, gbc_lblNewLabel_3);

        password_1Field = new JPasswordField();
        GridBagConstraints gbc_password_1Field = new GridBagConstraints();
        gbc_password_1Field.gridwidth = 2;
        gbc_password_1Field.insets = new Insets(0, 0, 5, 0);
        gbc_password_1Field.fill = GridBagConstraints.HORIZONTAL;
        gbc_password_1Field.gridx = 1;
        gbc_password_1Field.gridy = 3;
        panel.add(password_1Field, gbc_password_1Field);
        password_1Field.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("Password again");
        GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
        gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_4.gridx = 0;
        gbc_lblNewLabel_4.gridy = 4;
        panel.add(lblNewLabel_4, gbc_lblNewLabel_4);

        password_2Field = new JPasswordField();
        GridBagConstraints gbc_password_2Field = new GridBagConstraints();
        gbc_password_2Field.gridwidth = 2;
        gbc_password_2Field.insets = new Insets(0, 0, 5, 0);
        gbc_password_2Field.fill = GridBagConstraints.HORIZONTAL;
        gbc_password_2Field.gridx = 1;
        gbc_password_2Field.gridy = 4;
        panel.add(password_2Field, gbc_password_2Field);
        password_2Field.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("Sex");
        GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
        gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_5.gridx = 0;
        gbc_lblNewLabel_5.gridy = 5;
        panel.add(lblNewLabel_5, gbc_lblNewLabel_5);

        JRadioButton maleButton = new JRadioButton("Male");
        maleButton.setSelected(true);
        maleButton.setActionCommand("Male");
        buttonGroup.add(maleButton);
        GridBagConstraints gbc_maleButton = new GridBagConstraints();
        gbc_maleButton.insets = new Insets(0, 0, 5, 5);
        gbc_maleButton.gridx = 1;
        gbc_maleButton.gridy = 5;
        panel.add(maleButton, gbc_maleButton);

        JRadioButton femaleButton = new JRadioButton("Female");
        maleButton.setActionCommand("Female");
        buttonGroup.add(femaleButton);
        GridBagConstraints gbc_femaleButton = new GridBagConstraints();
        gbc_femaleButton.insets = new Insets(0, 0, 5, 0);
        gbc_femaleButton.gridx = 2;
        gbc_femaleButton.gridy = 5;
        panel.add(femaleButton, gbc_femaleButton);

        JLabel lblNewLabel_6 = new JLabel("Year of birth");
        GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
        gbc_lblNewLabel_6.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_6.insets = new Insets(0, 0, 0, 5);
        gbc_lblNewLabel_6.gridx = 0;
        gbc_lblNewLabel_6.gridy = 6;
        panel.add(lblNewLabel_6, gbc_lblNewLabel_6);

        JSpinner yearSpinner = new JSpinner();
        yearSpinner.setModel(
                new SpinnerNumberModel(Integer.valueOf(1900), Integer.valueOf(1900), null, Integer.valueOf(1)));
        GridBagConstraints gbc_yearSpinner = new GridBagConstraints();
        gbc_yearSpinner.fill = GridBagConstraints.HORIZONTAL;
        gbc_yearSpinner.gridwidth = 2;
        gbc_yearSpinner.insets = new Insets(0, 0, 0, 5);
        gbc_yearSpinner.gridx = 1;
        gbc_yearSpinner.gridy = 6;
        panel.add(yearSpinner, gbc_yearSpinner);

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                firstNameField.getText();
                lastNameField.getText();
                String email = emailField.getText();
                String pass_1 = password_1Field.getText();
                String pass_2 = password_2Field.getText();
                yearSpinner.getModel().getValue();
                buttonGroup.getSelection().getActionCommand();

                if(pass_1.equals(pass_2) && isValidEmail(email)) {
                    register(new User(firstNameField.getText(), lastNameField.getText(), emailField.getText(),
                            password_1Field.getText(), buttonGroup.getSelection().getActionCommand(),
                            (int) yearSpinner.getModel().getValue()));
                }else {
                    System.out.println("Sikertelen regisztráció!");
                }

            }

            private boolean isValidEmail(String email) {

                String[] parts = email.split("@");

                if(parts.length != 2) {
                    return false;
                }

                if(!parts[1].contains(".")) {
                    return false;
                }

                return true;

            }
        });
        GridBagConstraints gbc_registerButton = new GridBagConstraints();
        gbc_registerButton.gridx = 1;
        gbc_registerButton.gridy = 1;
        contentPane.add(registerButton, gbc_registerButton);
    }
}
