package java_collections;

public class Question {

    private final String question;
    private final String answer;
    private final int score;
    private final String genre;

    public Question(String question, String answer, int score, String genre) {
        this.question = question;
        this.answer = answer;
        this.score = score;
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public String getQuestion() {
        return question;
    }

    public int getScore() {
        return score;
    }
}
