package pl.orderfood.api.dto;

import lombok.*;
import pl.orderfood.infrastructure.security.UserEntity;

import java.util.Set;
@ToString(of = "name")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDTO {
    Integer restaurantId;
    String name;
    UserEntity user;
    Set<OrderDTO> orders;
    Set<MealDTO> meals;
    Set<DeliveryAddressDTO> deliveryAddresses;

}
