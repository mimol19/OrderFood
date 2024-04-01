package pl.orderfood.api.dto;

import lombok.*;

import java.util.Set;
@ToString(of = "name")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDTO {
    Integer restaurantId;
    String name;
    String email;
    String ownerName;
    String ownerSurname;
    Set<OrderDTO> orders;
    Set<MealDTO> meals;
    Set<DeliveryAddressDTO> deliveryAddresses;

}
