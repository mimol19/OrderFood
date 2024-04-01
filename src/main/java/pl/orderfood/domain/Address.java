package pl.orderfood.domain;

import lombok.*;

import java.util.Set;
@With
@Value
@Builder
@EqualsAndHashCode(of = "addressId")
@ToString(of ={ "name", "number"})
public class Address {
    Integer addressId;
    String name;
    Integer number;
    Customer customer;
    Set<DeliveryAddress> deliveryAddresses;
}
