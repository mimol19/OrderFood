package pl.orderfood.api.dto;

import lombok.*;


import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    Integer customerId;
    String name;
    String surname;
    String email;
    AddressDTO address;
    Set<OrderDTO> orders;
}
