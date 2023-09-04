package quiz;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextPane;
import javax.swing.BoxLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class QuestionPanel extends JPanel {

	private final Question question;
	private final int index;
	private List<JButton> answerButtons = new ArrayList<>();
	private boolean isCorrect = false;
	

	/**
	 * Create the panel.
	 */
	public QuestionPanel(Question question, int index) {
		this.question = question;
		this.index = index + 1;
		setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Question - " + this.index, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 100, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JPanel questionPanel = new JPanel();
		questionPanel.setMaximumSize(new Dimension(600, 32767));
		questionPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_questionPanel = new GridBagConstraints();
		gbc_questionPanel.insets = new Insets(0, 0, 5, 0);
		gbc_questionPanel.fill = GridBagConstraints.BOTH;
		gbc_questionPanel.gridx = 0;
		gbc_questionPanel.gridy = 0;
		add(questionPanel, gbc_questionPanel);
		questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.X_AXIS));

		JScrollPane scrollPane = new JScrollPane();
		questionPanel.add(scrollPane);

		JTextPane questionTextPane = new JTextPane();
		questionTextPane.setEditable(false);
		questionTextPane.setPreferredSize(new Dimension(200, 20));
		questionTextPane.setMaximumSize(new Dimension(100, 2147483647));
		scrollPane.setViewportView(questionTextPane);
		questionTextPane.setText(question.getQuestion());

		JPanel buttonPanel = new JPanel();
		GridBagConstraints gbc_buttonPanel = new GridBagConstraints();
		gbc_buttonPanel.fill = GridBagConstraints.BOTH;
		gbc_buttonPanel.gridx = 0;
		gbc_buttonPanel.gridy = 1;
		add(buttonPanel, gbc_buttonPanel);
		GridBagLayout gbl_buttonPanel = new GridBagLayout();
		gbl_buttonPanel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_buttonPanel.rowHeights = new int[] { 0, 0, 0 };
		gbl_buttonPanel.columnWeights = new double[] { 1.0, 0.0, 0.0, 1.0 };
		gbl_buttonPanel.rowWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		buttonPanel.setLayout(gbl_buttonPanel);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 2;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		buttonPanel.add(panel, gbc_panel);

		JButton answerButton_1 = new JButton("New button");

		GridBagConstraints gbc_answerButton_1 = new GridBagConstraints();
		gbc_answerButton_1.fill = GridBagConstraints.BOTH;
		gbc_answerButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_answerButton_1.gridx = 1;
		gbc_answerButton_1.gridy = 0;
		buttonPanel.add(answerButton_1, gbc_answerButton_1);

		JButton answerButton_2 = new JButton("New button");

		GridBagConstraints gbc_answerButton_2 = new GridBagConstraints();
		gbc_answerButton_2.fill = GridBagConstraints.BOTH;
		gbc_answerButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_answerButton_2.gridx = 2;
		gbc_answerButton_2.gridy = 0;
		buttonPanel.add(answerButton_2, gbc_answerButton_2);

		JButton answerButton_3 = new JButton("New button");

		GridBagConstraints gbc_answerButton_3 = new GridBagConstraints();
		gbc_answerButton_3.fill = GridBagConstraints.BOTH;
		gbc_answerButton_3.insets = new Insets(0, 0, 0, 5);
		gbc_answerButton_3.gridx = 1;
		gbc_answerButton_3.gridy = 1;
		buttonPanel.add(answerButton_3, gbc_answerButton_3);

		JButton answerButton_4 = new JButton("New button");

		GridBagConstraints gbc_answerButton_4 = new GridBagConstraints();
		gbc_answerButton_4.insets = new Insets(0, 0, 0, 5);
		gbc_answerButton_4.fill = GridBagConstraints.BOTH;
		gbc_answerButton_4.gridx = 2;
		gbc_answerButton_4.gridy = 1;
		buttonPanel.add(answerButton_4, gbc_answerButton_4);

		
		answerButtons.add(answerButton_1);
		answerButtons.add(answerButton_2);
		answerButtons.add(answerButton_3);
		answerButtons.add(answerButton_4);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridheight = 2;
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 3;
		gbc_panel_1.gridy = 0;
		buttonPanel.add(panel_1, gbc_panel_1);

		List<String> answers = question.getPossibleAnswers();

		for (int i = 0; i < answerButtons.size(); i++) {

			answerButtons.get(i).setText(answers.get(i));
			answerButtons.get(i).setActionCommand(answers.get(i));
			answerButtons.get(i).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					onAnswerSelect(e.getActionCommand());
				}
			});

		}

	}

	private void onAnswerSelect(String answer) {
		if (question.isCorrect(answer)) {
			setBorder(new TitledBorder(
					new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
					"Question - "+index, TitledBorder.LEADING, TitledBorder.TOP, null, Color.GREEN));
			this.isCorrect = true;
		} else {
			setBorder(new TitledBorder(
					new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
					"Question - "+index, TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));

		}
		
		disableButtons();
		
	}
	
	public boolean isCorrect() {
		return this.isCorrect;
	}
	
	private void disableButtons() {
		
		for(JButton button: answerButtons) {
			button.setEnabled(false);
		}
		
	}
	


}
