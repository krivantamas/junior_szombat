package java_oop;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public class OrderManager {

    private final List<OrderDetails> detailsList;

    OrderManager(List<OrderDetails> detailsList) {

        this.detailsList = detailsList;
    }


    public LocalDate leastAmountOrder() {
        throw new UnsupportedOperationException();
    }

    public OrderDetails getOrderByDateAndTime(LocalDate date, LocalTime time) {

        throw new UnsupportedOperationException();

    }

    public Map<String, Long> getPostmanStatistics() {
        throw new UnsupportedOperationException();
    }

    public String mostFavoredAddress() {
        throw new UnsupportedOperationException();
    }

}
