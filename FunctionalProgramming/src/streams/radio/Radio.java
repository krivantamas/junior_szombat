package streams.radio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Radio {

    private final int id;
    private final List<Zeneszam> songs;

    public Radio(int id) {
        this.id = id;
        this.songs = new ArrayList<>();
    }

    public boolean addSong(Zeneszam zeneszam) {
        return songs.add(zeneszam);
    }

    public int getId() {
        return id;
    }

    public List<Zeneszam> getSongs() {
        return songs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Radio radio = (Radio) o;
        return id == radio.id && Objects.equals(songs, radio.songs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, songs);
    }
}
