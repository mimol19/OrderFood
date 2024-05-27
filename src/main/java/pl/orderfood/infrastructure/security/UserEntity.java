package pl.orderfood.infrastructure.security;

import jakarta.persistence.*;
import lombok.*;
import pl.orderfood.infrastructure.database.entity.RestaurantEntity;

import java.util.Set;
@Getter
@Setter
@EqualsAndHashCode(of = "userId")
@ToString(of = "userName")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_food_user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "active")
    private Boolean active;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private RestaurantEntity restaurant;
}
