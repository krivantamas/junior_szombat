package java_database.model;

import java.util.Objects;

public class RoomCategoryDao {

    private final int roomCategoryId;
    private final String categoryName;

    public RoomCategoryDao(int roomCategoryId, String categoryName) {
        this.roomCategoryId = roomCategoryId;
        this.categoryName = categoryName;
    }

    public int getRoomCategoryId() {
        return roomCategoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    @Override
    public String toString() {
        return "RoomCategoryDao{" +
                "roomCategoryId=" + roomCategoryId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomCategoryDao that = (RoomCategoryDao) o;
        return roomCategoryId == that.roomCategoryId && Objects.equals(categoryName, that.categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomCategoryId, categoryName);
    }
}
