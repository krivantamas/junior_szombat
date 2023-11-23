package streams.radio;

public class Zeneszam {

    private final int min;
    private final int sec;
    private final String singer;
    private final String title;


    public int getTrackLengthInSec() {
        return min * 60 + sec;
    }

    public Zeneszam(int min, int sec, String singer, String title) {
        this.min = min;
        this.sec = sec;
        this.singer = singer;
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    @Override
    public String toString() {
        return "Zeneszam{" +
                "min=" + min +
                ", sec=" + sec +
                ", singer='" + singer + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
