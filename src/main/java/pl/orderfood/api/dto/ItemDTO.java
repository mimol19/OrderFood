package pl.orderfood.api.dto;

import lombok.*;


@Data
@Builder
@ToString(of = {"quantity","meal"})
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {
    Integer itemId;
    Integer quantity;
    OrderDTO order;
    MealDTO meal;
}
