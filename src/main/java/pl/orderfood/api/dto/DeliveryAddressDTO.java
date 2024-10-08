package pl.orderfood.api.dto;

import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryAddressDTO {
    Integer deliveryAddressId;
    AddressDTO address;
    RestaurantDTO restaurant;
}
