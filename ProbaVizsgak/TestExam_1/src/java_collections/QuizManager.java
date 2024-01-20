package java_collections;

import java.util.List;
import java.util.Map;

public class QuizManager {

    private final List<Question> questionList;

    public QuizManager(List<Question> questionList) {
        this.questionList = questionList;
    }

    public List<String> getQuestionsByGenre(String genre) {
        throw new UnsupportedOperationException();
    }

    public Map<String, List<Question>> getQuestionGroupedByGenre() {
        throw new UnsupportedOperationException();
    }

    public List<String> randomQuestions(int amount) {
        throw new UnsupportedOperationException();
    }

    public String genreWithMaxScore() {
        throw new UnsupportedOperationException();
    }


}
