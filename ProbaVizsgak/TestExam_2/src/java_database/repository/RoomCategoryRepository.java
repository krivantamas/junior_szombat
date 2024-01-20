package java_database.repository;

import java_database.Database;
import java_database.model.RoomCategoryDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomCategoryRepository {

    private final Connection connection = new Database().getConnection();

    public List<RoomCategoryDao> getAll() {

        String sql = "SELECT * FROM room_category";
        List<RoomCategoryDao> roomCategoryDaos = new ArrayList<>();

        try {
            var preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                roomCategoryDaos.add(getRoomCategoryFromResultSet(resultSet));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return roomCategoryDaos;
    }

    public RoomCategoryDao getById(int id) {
        String sql = "SELECT * FROM room_category where room_category.room_category_id = ?";

        try {
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                return getRoomCategoryFromResultSet(resultSet);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return null;
    }

    private RoomCategoryDao getRoomCategoryFromResultSet(ResultSet resultSet) throws SQLException {
        int roomCategoryId = resultSet.getInt("room_category_id");
        String roomCategoryName = resultSet.getString("room_category_name");

        return new RoomCategoryDao(roomCategoryId, roomCategoryName);
    }


}
