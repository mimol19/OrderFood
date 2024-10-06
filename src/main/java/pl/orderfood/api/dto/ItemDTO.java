package pl.orderfood.api.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;


@Data
@Builder
@ToString(of = "quantity")
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {
    @Positive(message = "Item ID must be positive")
    private Integer itemId;

    @PositiveOrZero(message = "Quantity must be zero or positive")
    @NotNull
    private Integer quantity;

    private OrderDTO order;

    @NotNull(message = "Meal cannot be null")
    private MealDTO meal;
}
