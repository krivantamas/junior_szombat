package quiz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;

import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Dimension;

public class QuizMainView extends JFrame {

	private JPanel contentPane;
	private JTable leaderBoard;
	private JTextField textField;
	private JLabel questionCountLabel;
	private JButton startButton;
	private QuizMainController controller = null;

	public void setController(QuizMainController controller) {
		if (this.controller == null && controller != null) {
			this.controller = controller;
			questionsAddedListener();
		} else {
			throw new RuntimeException();
		}

	}

	private void questionsAddedListener() {
		controller.addQuestionListListener(new QuestionListListener() {

			@Override
			public void onQuestionListChange(int questionListSize) {
				questionCountLabel.setText("Question count: " + questionListSize);
				startButton.setEnabled(questionListSize>0);
			}
		});
	}

	public QuizMainView() {
		setMinimumSize(new Dimension(600, 200));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 200, 200, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 2.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JPanel leaderBoardPanel = new JPanel();
		leaderBoardPanel.setMinimumSize(new Dimension(200, 200));
		leaderBoardPanel.setPreferredSize(new Dimension(200, 200));
		leaderBoardPanel
				.setBorder(new TitledBorder(null, "Leaderboard", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_leaderBoardPanel = new GridBagConstraints();
		gbc_leaderBoardPanel.insets = new Insets(0, 0, 0, 5);
		gbc_leaderBoardPanel.fill = GridBagConstraints.BOTH;
		gbc_leaderBoardPanel.gridx = 0;
		gbc_leaderBoardPanel.gridy = 0;
		contentPane.add(leaderBoardPanel, gbc_leaderBoardPanel);
		leaderBoardPanel.setLayout(new BoxLayout(leaderBoardPanel, BoxLayout.X_AXIS));

		JScrollPane scrollPane = new JScrollPane();
		leaderBoardPanel.add(scrollPane);

		leaderBoard = new JTable();
		scrollPane.setViewportView(leaderBoard);

		leaderBoard.setModel(new DefaultTableModel(new Object[][] { { "asdasd", new Integer(1) }, { "", null }, },
				new String[] { "Username", "Score" }) {
			Class[] columnTypes = new Class[] { Object.class, Integer.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});

		JPanel controllPanel = new JPanel();
		controllPanel.setPreferredSize(new Dimension(200, 200));
		controllPanel.setMinimumSize(new Dimension(200, 200));
		GridBagConstraints gbc_controllPanel = new GridBagConstraints();
		gbc_controllPanel.fill = GridBagConstraints.BOTH;
		gbc_controllPanel.gridx = 1;
		gbc_controllPanel.gridy = 0;
		contentPane.add(controllPanel, gbc_controllPanel);
		GridBagLayout gbl_controllPanel = new GridBagLayout();
		gbl_controllPanel.columnWidths = new int[] { 0, 0 };
		gbl_controllPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_controllPanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_controllPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		controllPanel.setLayout(gbl_controllPanel);

		JButton loadQuestionsButton = new JButton("Load questions");
		loadQuestionsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openQuestionLoadDialog();
			}
		});
		GridBagConstraints gbc_loadQuestionsButton = new GridBagConstraints();
		gbc_loadQuestionsButton.insets = new Insets(0, 0, 5, 0);
		gbc_loadQuestionsButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_loadQuestionsButton.gridx = 0;
		gbc_loadQuestionsButton.gridy = 0;
		controllPanel.add(loadQuestionsButton, gbc_loadQuestionsButton);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "QuestionInfo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		controllPanel.add(panel, gbc_panel);

		questionCountLabel = new JLabel("Question count: 0");
		panel.add(questionCountLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Username", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		controllPanel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 0;
		panel_1.add(textField, gbc_textField);
		textField.setColumns(10);

		startButton = new JButton("Start Quiz");
		startButton.setEnabled(false);
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startQuizButtonPressed();
			}
		});

		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridheight = 3;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 3;
		controllPanel.add(panel_2, gbc_panel_2);
		GridBagConstraints gbc_startButton = new GridBagConstraints();
		gbc_startButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_startButton.gridx = 0;
		gbc_startButton.gridy = 6;
		controllPanel.add(startButton, gbc_startButton);
	}

	private void openQuestionLoadDialog() {
		JFileChooser fileChooser = new JFileChooser();
		FileFilter csvFileFilter = new FileNameExtensionFilter("Question csv", "csv");
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.addChoosableFileFilter(csvFileFilter);
		if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			try {
				controller.loadQuestions(fileChooser.getSelectedFile());
				JOptionPane.showMessageDialog(this, "Questions are loaded!", "Successful",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	private void startQuizButtonPressed() {
		controller.startQuiz();
	}

	public void refreshTable(List<User> userList) {
		leaderBoard.setModel(new LeaderBoardModel(userList));
	}

}
