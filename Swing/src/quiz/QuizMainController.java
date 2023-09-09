package quiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class QuizMainController {
	
	private final QuizMainView view;
	private List<Question> questions;
	private final File leaderBoardPath;
	
	//
	private List<QuestionListListener> questionListListeners = new ArrayList<>();

	
	public QuizMainController(QuizMainView quizMainView, File leaderBoardPath) {
		this.view = quizMainView;
		this.leaderBoardPath = leaderBoardPath;
		initView(quizMainView);
	}

	private void initView(QuizMainView quizMainView) {
		quizMainView.setController(this);
		quizMainView.setVisible(true);
		loadLeaderbordInfo();
	}
	
	private void loadLeaderbordInfo() {
		
		try {
			List<User> users = LeaderBoardFileHandler.loadLeaderBoardCsv(leaderBoardPath);
			view.refreshTable(users);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(view, e.getMessage(), "Errors happened during the file processing!",
					JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
		for(QuestionListListener listener:questionListListeners) {
			listener.onQuestionListChange(questions.size());
		}
	}
	
	public void addQuestionListListener(QuestionListListener listener) {
		questionListListeners.add(listener);
	}
	
	public void loadQuestions(File file) throws FileNotFoundException {
		List<Question> questions = new ArrayList<>();
		Scanner scanner = new Scanner(file);

		scanner.nextLine();

		while (scanner.hasNextLine()) {

			String[] values = scanner.nextLine().split(";");

			questions.add(new Question(values[0], values[1], Arrays.asList(values[2], values[3], values[4])));
		}
		
		Collections.shuffle(questions);
		setQuestions(questions);
	}
	
	public void startQuiz() {
		
		QuizDialog dialog = new QuizDialog(questions);
		dialog.setVisible(true);
		
		int userScore = dialog.getScore();
		String username = view.getUsername();
		try {
			LeaderBoardFileHandler.appendLeaderBoardCsv(leaderBoardPath, new User(username,userScore));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(view, e.getMessage(), "Something went wrong, sorry :/",
					JOptionPane.ERROR_MESSAGE);
		}
		dialog.dispose();
		loadLeaderbordInfo();
	}
	
	
	

}
