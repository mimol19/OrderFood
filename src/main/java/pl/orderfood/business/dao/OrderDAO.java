package pl.orderfood.business.dao;

import pl.orderfood.domain.Order;

public interface OrderDAO {

    Order saveOrder(Order order);
}
