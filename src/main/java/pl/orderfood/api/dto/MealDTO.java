package pl.orderfood.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
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
@ToString(of = {"name","mealId"})
public class MealDTO {
    @Positive(message = "Meal ID must be positive")
    private Integer mealId;

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotBlank(message = "Description cannot be empty")
    private String description;

    @NotNull(message = "Category cannot be null")
    private CategoryEnum category;

    @NotNull(message = "Meal photo cannot be null")
    private String mealPhoto;

    @PositiveOrZero(message = "Price must be zero or positive")
    @NotNull(message = "Price cannot be null")
    private BigDecimal price;

    @NotNull(message = "Restaurant cannot be null")
    private RestaurantDTO restaurant;

    private Set<ItemDTO> itemList;
}