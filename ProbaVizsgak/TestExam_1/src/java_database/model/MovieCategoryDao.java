package java_database.model;

public class MovieCategoryDao {


    private int movieCategoryId;
    private final String movieCategoryName;

    public MovieCategoryDao(String movieCategoryName) {
        this.movieCategoryId = -1;
        this.movieCategoryName = movieCategoryName;
    }

    public MovieCategoryDao(int movieCategoryId, String movieCategoryName) {
        this.movieCategoryId = movieCategoryId;
        this.movieCategoryName = movieCategoryName;
    }

    public int getMovieCategoryId() {
        return movieCategoryId;
    }

    public String getMovieCategoryName() {
        return movieCategoryName;
    }

    @Override
    public String toString() {
        return "MovieCategoryDao{" +
                "movieCategoryId=" + movieCategoryId +
                ", movieCategoryName='" + movieCategoryName + '\'' +
                '}';
    }
}
