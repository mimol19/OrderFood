package pl.orderfood.domain;

import lombok.*;
@With
@Value
@Builder
@EqualsAndHashCode(of = "itemId")
@ToString(of = "itemId")
public class Item {
    Integer itemId;
    Integer quantity;
    Order order;
    Meal meal;
}
