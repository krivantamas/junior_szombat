package quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question {

	private final String question;
	private final String correctAnswer;
	private final List<String> incorrectAnswers;
	

	public Question(String question, String correctAnswer, List<String> incorrectAnswers) {
		this.question = question;
		this.correctAnswer = correctAnswer;
		this.incorrectAnswers = incorrectAnswers;
	}

	public String getQuestion() {
		return question;
	}

	public List<String> getPossibleAnswers() {
		List<String> possibleAnswers = new ArrayList<String>(incorrectAnswers);
		possibleAnswers.add(correctAnswer);
		Collections.shuffle(possibleAnswers);
		return possibleAnswers;
	}

	public boolean isCorrect(String answer) {
		return correctAnswer.equals(answer);
	}
	

	@Override
	public String toString() {
		return "Question [question=" + question + ", correctAnswer=" + correctAnswer + ", incorrectAnswers="
				+ incorrectAnswers + "]";
	}

}
