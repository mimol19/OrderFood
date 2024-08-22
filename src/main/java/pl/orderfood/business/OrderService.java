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

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class OrderService {

    private final OrderDAO orderDAO;

    @Transactional
    public Order saveOrderAndCustomer(Order order) {


        return orderDAO.saveOrder(order);
    }
}
