package quiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class QuizMainController {
	
	private final QuizMainView view;
	private List<Question> questions;
	
	//
	private List<QuestionListListener> questionListListeners = new ArrayList<>();

	
	public QuizMainController(QuizMainView quizMainView) {
		this.view = quizMainView;
		initView(quizMainView);
	}

	private void initView(QuizMainView quizMainView) {
		quizMainView.setController(this);
		quizMainView.setVisible(true);
		quizMainView.refreshTable(new ArrayList<User>());
	}
	
	private void loadLeaderbordInfo() {
		//TODO Olvassunk be egy users.csv-t és frissítsük a táblázatot aszerint!
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
		System.out.println(dialog.getScore());
		dialog.dispose();
		
	}
	
	
	

}
