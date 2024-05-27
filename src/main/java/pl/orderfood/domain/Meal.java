package pl.orderfood.domain;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;
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
    String mealPhoto;
    BigDecimal price;
    Restaurant restaurant;
    Set<Item> itemList;


}