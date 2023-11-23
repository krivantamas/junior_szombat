package radio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// radio.Database Access Object
// CRUD -> Create, Update, Read, Delete
public class SongDao {


    private final Connection connection;

    public SongDao(Connection connection) {
        this.connection = connection;
    }


    public Optional<Song> get(int id) {

        String sql = "SELECT * FROM song WHERE song_id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int songId = resultSet.getInt("song_id");
                int radioId = resultSet.getInt("radio_id");
                int lengthInSec = resultSet.getInt("length_in_sec");
                String author = resultSet.getString("author");
                String title = resultSet.getString("title");

                return Optional.of(new Song(songId, radioId, lengthInSec, author, title));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    public List<Song> getAll() {
        String sql = "SELECT * FROM song";
        List<Song> songs = new ArrayList<>();

        try {
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            while (resultSet.next()) {
                int songId = resultSet.getInt("song_id");
                int radioId = resultSet.getInt("radio_id");
                int lengthInSec = resultSet.getInt("length_in_sec");
                String author = resultSet.getString("author");
                String title = resultSet.getString("title");

                songs.add(new Song(songId, radioId, lengthInSec, author, title));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return songs;
    }

    public List<Song> getAllByRadioId(int radioId) {
        String sql = "SELECT * FROM song WHERE radio_id = ?";
        List<Song> songs = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, radioId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int songId = resultSet.getInt("song_id");
                int lengthInSec = resultSet.getInt("length_in_sec");
                String author = resultSet.getString("author");
                String title = resultSet.getString("title");

                songs.add(new Song(songId, radioId, lengthInSec, author, title));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return songs;
    }


    public boolean save(Song song) {

        String sql = "INSERT INTO song(radio_id,length_in_sec,author,title) VALUES (?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, song.getRadio());
            preparedStatement.setLong(2, song.getTimeInSeconds());
            preparedStatement.setString(3, song.getAuthor());
            preparedStatement.setString(4, song.getTitle());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }

        return true;
    }

    public boolean update(Song song, Song updateSong) {

        String sql = "UPDATE song SET radio_id = ?, length_in_sec = ?, author = ?, title = ? WHERE song_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, updateSong.getRadio());
            preparedStatement.setLong(2, updateSong.getTimeInSeconds());
            preparedStatement.setString(3, updateSong.getAuthor());
            preparedStatement.setString(4, updateSong.getTitle());

            preparedStatement.setInt(5, song.getSongId());

            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }


    }

    public boolean delete(Song song) {

        String sql = "DELETE FROM song WHERE song_id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, song.getSongId());

            return preparedStatement.executeUpdate() == 1;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }
}
