package pl.orderfood.api.dto;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Integer orderId;
    private Integer orderNumber;
    private RestaurantDTO restaurant;
    private CustomerDTO customer;
    private Set<MealDTO> mealList;
}
