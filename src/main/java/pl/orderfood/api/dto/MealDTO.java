package pl.orderfood.api.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;
import pl.orderfood.infrastructure.database.entity.CategoryEnum;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = "name")
public class MealDTO {
    Integer mealId;
    String name;
    String description;
    CategoryEnum category;
    String mealPhoto;
    BigDecimal price;
    RestaurantDTO restaurant;
    Set<ItemDTO> itemList;
}