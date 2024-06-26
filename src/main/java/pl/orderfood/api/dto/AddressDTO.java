package pl.orderfood.api.dto;

import lombok.*;

import java.util.Set;
@Data
@ToString(of = {"addressId", "name", "number"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    Integer addressId;
    String name;
    Integer number;
    CustomerDTO customer;
    Set<DeliveryAddressDTO> deliveryAddresses;
}