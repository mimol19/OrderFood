package pl.orderfood.api.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Set;
@Data
@ToString(of = {"addressId", "name", "number"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    @Positive(message = "Address ID must be positive")
    Integer addressId;
    @NotBlank(message = "Name is mandatory")
    @Size(max = 64, message = "Name cannot exceed 64 characters")
    String name;
    @NotNull
    @PositiveOrZero(message = "Address number must be positive or zero")
    Integer number;
    CustomerDTO customer;
    Set<DeliveryAddressDTO> deliveryAddresses;
}