package pl.orderfood.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import pl.orderfood.infrastructure.security.UserEntity;

import java.util.Set;
@ToString(of = {"restaurantId","name"})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDTO {
    @Positive(message = "Restaurant ID must be positive")
    private Integer restaurantId;

    @NotBlank(message = "Name cannot be empty")
    private String name;

    private UserEntity user;

    private Set<OrderDTO> orders;

    private Set<MealDTO> meals;

    private Set<DeliveryAddressDTO> deliveryAddresses;

}
