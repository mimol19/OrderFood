package pl.orderfood.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(of = "restaurantId")
@ToString(of = "name")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "restaurant")
public class RestaurantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private Integer restaurantId;
    @Column(name = "name")
    private String name;
    @Column(name = "owner_name")
    private String ownerName;
    @Column(name = "owner_surname")
    private String ownerSurname;
    @Column(name = "email")
    private String email;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "restaurant")
    private Set<OrderEntity> orders;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "restaurant")
    private Set<MealEntity> meals;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "restaurant")
    private Set<DeliveryAddressEntity> deliveryAddresses;

}
