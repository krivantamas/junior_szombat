public class Song {

    private final int songId;
    private final int radio;
    private final long timeInSeconds;
    private final String author;
    private final String title;

    public Song(int radio, long timeInSeconds, String author, String title) {
        this.songId = -1;
        this.radio = radio;
        this.timeInSeconds = timeInSeconds;
        this.author = author;
        this.title = title;
    }

    public Song(int songId, int radio, long timeInSeconds, String author, String title) {
        this.songId = songId;
        this.radio = radio;
        this.timeInSeconds = timeInSeconds;
        this.author = author;
        this.title = title;
    }

    public int getSongId() {
        return songId;
    }

    public int getRadio() {
        return radio;
    }

    public long getTimeInSeconds() {
        return timeInSeconds;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }


    @Override
    public String toString() {
        return "Song{" +
                "songId=" + songId +
                ", radio=" + radio +
                ", timeInSeconds=" + timeInSeconds +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
