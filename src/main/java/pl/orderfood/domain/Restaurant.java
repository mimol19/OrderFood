package pl.orderfood.domain;

import lombok.*;
import pl.orderfood.infrastructure.security.UserEntity;

import java.util.Set;

@With
@Value
@Builder
@EqualsAndHashCode(of = "restaurantId")
@ToString(of = "name")
public class Restaurant {
    Integer restaurantId;
    String name;
    UserEntity user;
    Set<Order> orders;
    Set<Meal> meals;
    Set<DeliveryAddress> deliveryAddresses;
}
