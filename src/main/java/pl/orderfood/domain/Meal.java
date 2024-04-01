package pl.orderfood.domain;

import lombok.*;
import pl.orderfood.infrastructure.database.entity.CategoryEnum;


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@With
@Value
@Builder
@EqualsAndHashCode(of = "mealId")
@ToString(of = "name")
public class Meal {
    Integer mealId;
    String name;
    String description;
    CategoryEnum category;
    byte[] mealPhoto;
    BigDecimal price;
    Restaurant restaurant;
    Set<Item> itemList;


}