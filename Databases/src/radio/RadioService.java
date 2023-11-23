package radio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RadioService {
    private final Connection connection;
    private final SongDao songDao;

    public RadioService(Connection connection) {
        this.connection = connection;
        this.songDao = new SongDao(connection);
    }

    public int totalSongLength(int radioId) {

        String sql = "SELECT SUM(length_in_sec) FROM song WHERE radio_id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, radioId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getInt(1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return 0;

    }

    public int totalSongCount(int radioId) {
        String sql = "SELECT COUNT(*) FROM SONG WHERE radio_id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, radioId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getInt(1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return 0;
    }

    public Optional<Song> longestSong(int radioId) {

        String sql = "SELECT * FROM song WHERE length_in_sec = (SELECT MAX(length_in_sec) FROM SONG WHERE radio_id = ?) AND radio_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, radioId);
            preparedStatement.setInt(2, radioId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int songId = resultSet.getInt("song_id");
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

    public Optional<Song> shortestSong(int radioId) {

        String sql = "SELECT * FROM song WHERE length_in_sec = (SELECT MIN(length_in_sec) FROM SONG WHERE radio_id = ?) AND radio_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, radioId);
            preparedStatement.setInt(2, radioId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int songId = resultSet.getInt("song_id");
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

    public Optional<String> mostPlayedAuthor(int radioId) {

        String sql = "SELECT author FROM song WHERE radio_id = ? GROUP BY author ORDER BY COUNT(author) DESC LIMIT 1";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, radioId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return Optional.of(resultSet.getString(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Optional.empty();
    }

    public List<Song> songsByAuthor(String author, int radioId) {

        String sql = "SELECT * FROM song WHERE radio_id = ? AND author = ?";
        List<Song> songs = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, radioId);
            preparedStatement.setString(2, author);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int songId = resultSet.getInt("song_id");
                int lengthInSec = resultSet.getInt("length_in_sec");
                String title = resultSet.getString("title");

                songs.add(new Song(songId, radioId, lengthInSec, author, title));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return songs;
    }

    public Optional<Song> currentTrack(int radioId, int hour, int minute) {

        int sec = hour * 3600 + minute * 60;
        int sumMusicLength = 0;

        for (Song song : songDao.getAllByRadioId(radioId)) {
            long trackLengthInSec = song.getTimeInSeconds();
            sumMusicLength += trackLengthInSec;
            if (sumMusicLength > sec) {
                return Optional.of(song);
            }
        }
        return Optional.empty();
    }
}
