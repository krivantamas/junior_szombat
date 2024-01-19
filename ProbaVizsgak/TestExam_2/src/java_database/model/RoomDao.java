package java_database.model;

import java.util.Objects;

public class RoomDao {

    private int roomId;
    private final int level;
    private final int roomCategoryId;
    private final double area;
    private final int price;
    private final boolean reserved;
    private final boolean onSale;


    public RoomDao(int level, int roomCategoryId, double area, int price, boolean reserved, boolean onSale) {
        this.level = level;
        this.roomCategoryId = roomCategoryId;
        this.area = area;
        this.price = price;
        this.reserved = reserved;
        this.onSale = onSale;
    }

    public RoomDao(int roomId, int level, int roomCategoryId, double area, int price, boolean reserved, boolean onSale) {
        this.roomId = roomId;
        this.level = level;
        this.roomCategoryId = roomCategoryId;
        this.area = area;
        this.price = price;
        this.reserved = reserved;
        this.onSale = onSale;
    }

    public int getRoomId() {
        return roomId;
    }

    public int getLevel() {
        return level;
    }

    public int getRoomCategoryId() {
        return roomCategoryId;
    }

    public double getArea() {
        return area;
    }

    public int getPrice() {
        return price;
    }

    public boolean isReserved() {
        return reserved;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public double getOnSalePrice() {
        return getPrice();
    }

    @Override
    public String toString() {
        return "RoomDao{" +
                "roomId=" + roomId +
                ", level=" + level +
                ", roomCategory=" + roomCategoryId +
                ", area=" + area +
                ", price=" + price +
                ", reserved=" + reserved +
                ", onSale=" + onSale +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomDao roomDao = (RoomDao) o;
        return roomId == roomDao.roomId && level == roomDao.level && roomCategoryId == roomDao.roomCategoryId && area == roomDao.area && price == roomDao.price && reserved == roomDao.reserved && onSale == roomDao.onSale;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId, level, roomCategoryId, area, price, reserved, onSale);
    }
}
