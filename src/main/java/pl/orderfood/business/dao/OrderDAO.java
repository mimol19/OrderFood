package pl.orderfood.business.dao;

import pl.orderfood.domain.Order;

import java.util.List;

public interface OrderDAO {

    Order saveOrder(Order order);

    List<Order> getRestaurantOrders(String username);

    Order completeOrder(Integer orderId);
}
