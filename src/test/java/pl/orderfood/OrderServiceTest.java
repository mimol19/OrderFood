package pl.orderfood;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.orderfood.business.CustomerService;
import pl.orderfood.business.OrderService;
import pl.orderfood.business.dao.OrderDAO;
import pl.orderfood.domain.Customer;
import pl.orderfood.domain.Order;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    private OrderDAO orderDAO;

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private OrderService orderService;

    private Order order;
    private Customer customer;

    @BeforeEach
    void setUp() {

        customer = Customer.builder()
                .customerId(1)
                .name("John")
                .surname("Doe")
                .email("john.doe@example.com")
                .build();

        order = Order.builder()
                .orderId(1)
                .orderNumber("ORD123")
                .customer(customer)
                .build();
    }

    @Test
    void testSaveOrderAndCustomer() {

        when(customerService.saveCustomer(any(Customer.class))).thenReturn(customer);
        when(orderDAO.saveOrder(any(Order.class))).thenReturn(order);

        Order savedOrder = orderService.saveOrderAndCustomer(order);


        verify(customerService).saveCustomer(order.getCustomer());
        verify(orderDAO).saveOrder(order);


        assertEquals(savedOrder, order);
    }

    @Test
    void testGetRestaurantOrders() {

        String username = "testRestaurant";
        List<Order> orders = Arrays.asList(order);


        when(orderDAO.getRestaurantOrders(username)).thenReturn(orders);


        List<Order> result = orderService.getRestaurantOrders(username);


        verify(orderDAO).getRestaurantOrders(username);
        assertEquals(1, result.size());
        assertEquals(order, result.get(0));
    }

    @Test
    void testCompleteOrder() {

        Integer orderId = 1;


        when(orderDAO.completeOrder(orderId)).thenReturn(order);


        Order completedOrder = orderService.completeOrder(orderId);


        verify(orderDAO).completeOrder(orderId);
        assertEquals(completedOrder, order);
    }

    @Test
    void testGetOrderById() {

        Integer orderId = 1;


        when(orderDAO.getOrder(orderId)).thenReturn(order);


        Order fetchedOrder = orderService.getOrderById(orderId);


        verify(orderDAO).getOrder(orderId);
        assertEquals(fetchedOrder, order);
    }
}
