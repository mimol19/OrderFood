package pl.orderfood.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(of = "addressId")
@ToString(of = {"addressId", "name", "number"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Integer addressId;
    @Column(name = "name")
    private String name;
    @Column(name = "number")
    private Integer number;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "address")
    private CustomerEntity customer;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "address")
    private Set<DeliveryAddressEntity> deliveryAddresses;
}