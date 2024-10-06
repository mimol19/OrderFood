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
    Restaurant restaurant;
    Customer customer;
    boolean completed;
    List<Item> itemList;
}
