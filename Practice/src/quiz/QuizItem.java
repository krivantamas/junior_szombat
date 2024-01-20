package quiz;

import java.util.Objects;

public class QuizItem {

    private final String question;
    private final String answer;
    private final int score;
    private final String theme;

    public QuizItem(String question, String answer, int score, String theme) {
        this.question = question;
        this.answer = answer;
        this.score = score;
        this.theme = theme;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public int getScore() {
        return score;
    }

    public String getTheme() {
        return theme;
    }

    @Override
    public String toString() {
        return "QuizItem{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", score=" + score +
                ", theme='" + theme + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuizItem quizItem = (QuizItem) o;
        return score == quizItem.score && Objects.equals(question, quizItem.question) && Objects.equals(answer, quizItem.answer) && Objects.equals(theme, quizItem.theme);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, answer, score, theme);
    }
}
