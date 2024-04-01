package pl.orderfood.domain;

import jakarta.persistence.*;
import lombok.*;


import java.util.HashSet;
import java.util.Set;

@With
@Value
@Builder
@EqualsAndHashCode(of = "restaurantId")
@ToString(of = "name")
public class Restaurant {
    Integer restaurantId;
    String name;
    String email;
    String ownerName;
    String ownerSurname;
    Set<Order> orders;
    Set<Meal> meals;
    Set<DeliveryAddress> deliveryAddresses;
}
