package pl.orderfood.domain;

import lombok.*;

@With
@Value
@Builder
@EqualsAndHashCode(of = "deliveryAddressId")
@ToString(of = "deliveryAddressId")
public class DeliveryAddress {

    Integer deliveryAddressId;
    Address address;
    Restaurant restaurant;
}
