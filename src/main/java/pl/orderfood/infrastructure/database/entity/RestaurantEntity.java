package pl.orderfood.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;
import pl.orderfood.infrastructure.security.UserEntity;

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
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "restaurant")
    private UserEntity user;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "restaurant")
    private Set<OrderEntity> orders;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "restaurant")
    private Set<MealEntity> meals;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "restaurant")
    private Set<DeliveryAddressEntity> deliveryAddresses;


}
