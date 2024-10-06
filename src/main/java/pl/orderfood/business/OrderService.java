package pl.orderfood.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.orderfood.business.dao.OrderDAO;
import pl.orderfood.domain.Customer;
import pl.orderfood.domain.Item;
import pl.orderfood.domain.Meal;
import pl.orderfood.domain.Order;

import java.util.Collection;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class OrderService {

    private final OrderDAO orderDAO;
    private final CustomerService customerService;

@Transactional
    public Order saveOrderAndCustomer(Order order) {
        Customer customer = customerService.saveCustomer(order.getCustomer());
        order.setCustomer(customer);
        return orderDAO.saveOrder(order);
    }


    public List<Order> getRestaurantOrders(String username) {

        return orderDAO.getRestaurantOrders(username);
    }

    public Order completeOrder(Integer orderId) {
        return orderDAO.completeOrder(orderId);
    }

    public Order getOrderById(Integer orderId) {
        return orderDAO.getOrder(orderId);
    }
}
