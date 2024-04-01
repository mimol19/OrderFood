package pl.orderfood.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@With
@Value
@Builder
@EqualsAndHashCode(of = "orderId")
@ToString(of = "orderNumber")
public class Order {
    Integer orderId;
    Integer orderNumber;
    Restaurant restaurant;
    Customer customer;
    Set<Item> itemList;
}
