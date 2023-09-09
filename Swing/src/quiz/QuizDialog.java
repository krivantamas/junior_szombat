package quiz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.GridBagConstraints;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QuizDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel questionsPanel;
	private List<QuestionPanel> questionPanels = new ArrayList<>();

	
	public QuizDialog(List<Question> questions) {
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 1, 0 };
		gbl_contentPanel.rowHeights = new int[] { 1, 0 };
		gbl_contentPanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		contentPanel.add(scrollPane, gbc_scrollPane);

		questionsPanel = new JPanel();
		scrollPane.setViewportView(questionsPanel);
		questionsPanel.setBackground(Color.LIGHT_GRAY);
		questionsPanel.setLayout(new BoxLayout(questionsPanel, BoxLayout.Y_AXIS));

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuizDialog.this.setVisible(false);
			}
		});
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
		
		
		initQuestionPanels(questions);
	}

	private void initQuestionPanels(List<Question> questions) {
		int index = 0;
		for (Question question : questions) {
			QuestionPanel panel = new QuestionPanel(question, index);
			questionsPanel.add(panel);
			questionPanels.add(panel);
			index++;
		}
	}
	
	public int getScore() {
		return questionPanels.stream().mapToInt(panel -> panel.isCorrect()?1:0).sum();
	}

}
