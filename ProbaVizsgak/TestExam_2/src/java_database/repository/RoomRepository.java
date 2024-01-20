package java_database.repository;

import java_database.Database;
import java_database.model.RoomDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomRepository {

    private final Connection connection = new Database().getConnection();

    public List<RoomDao> getAll() {

        String sql = "SELECT * FROM Room";
        List<RoomDao> rooms = new ArrayList<>();

        try {
            var preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                rooms.add(getRoomFromResultSet(resultSet));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return rooms;
    }

    public RoomDao getById(int id) {
        String sql = "SELECT * FROM Room where room.room_id = ?";

        try {
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                return getRoomFromResultSet(resultSet);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return null;
    }

    public void save(RoomDao room) {
        String sql = "INSERT INTO Room (room_level,room_area,room_price,room_reserved,room_on_sale,room_category_id) VALUES (?, ?, ?,?,?,?)";

        try {
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, room.getLevel());
            preparedStatement.setDouble(2, room.getArea());
            preparedStatement.setInt(3, room.getPrice());
            preparedStatement.setBoolean(4, room.isReserved());
            preparedStatement.setBoolean(5, room.isOnSale());
            preparedStatement.setInt(6, room.getRoomCategoryId());

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private RoomDao getRoomFromResultSet(ResultSet resultSet) throws SQLException {

        int roomId = resultSet.getInt("room_id");
        int level = resultSet.getInt("room_level");
        int roomCategoryId = resultSet.getInt("room_category_id");
        double area = resultSet.getDouble("room_area");
        int price = resultSet.getInt("room_price");
        boolean reserved = resultSet.getBoolean("room_reserved");
        boolean onSale = resultSet.getBoolean("room_on_sale");


        return new RoomDao(roomId, level, roomCategoryId, area, price, reserved, onSale);
    }

}
