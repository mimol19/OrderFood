package pl.orderfood.domain;

import lombok.*;

import java.util.List;

@With
@Data
@Builder
@EqualsAndHashCode(of = "orderId")
@ToString(of = "orderNumber")
public class Order {
    Integer orderId;
    String orderNumber;
    boolean isCompleted;
    Restaurant restaurant;
    Customer customer;
    List<Item> itemList;
}
