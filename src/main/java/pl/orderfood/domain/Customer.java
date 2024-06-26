package pl.orderfood.domain;

import lombok.*;

import java.util.Set;

@With
@Data
@Builder
@EqualsAndHashCode(of = "customerId")
@ToString(of ={ "name", "surname"})
public class Customer {
    Integer customerId;
    String name;
    String surname;
    String email;
    Address address;
    Set<Order> orders;
}
