package pizza_futar;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Order {

    private final LocalDate orderDate;
    private final String postmanId;
    private final String address;
    private final LocalTime arrivalTime;


    public Order(LocalDate orderDate, String postmanId, String address, LocalTime arrivalTime) {
        this.orderDate = orderDate;
        this.postmanId = postmanId;
        this.address = address;
        this.arrivalTime = arrivalTime;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public String getPostmanId() {
        return postmanId;
    }

    public String getAddress() {
        return address;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderDate=" + orderDate +
                ", postmanId='" + postmanId + '\'' +
                ", address='" + address + '\'' +
                ", arrivalTime=" + arrivalTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderDate, order.orderDate) && Objects.equals(postmanId, order.postmanId) && Objects.equals(address, order.address) && Objects.equals(arrivalTime, order.arrivalTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderDate, postmanId, address, arrivalTime);
    }
}
