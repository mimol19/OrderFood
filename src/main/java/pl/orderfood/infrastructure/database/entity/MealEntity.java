package pl.orderfood.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(of = "mealId")
@ToString(of = "name")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "restaurant")
public class MealEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meal_id")
    private Integer mealId;
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private CategoryEnum category;
    @Lob
    @Column(columnDefinition = "bytea")
    private byte[] mealPhoto;
    @Column(name = "price")
    private BigDecimal price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private RestaurantEntity restaurant;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "meal")
    private Set<ItemEntity> itemList;

}