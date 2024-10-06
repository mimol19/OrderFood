package pl.orderfood.api.dto;

import jakarta.validation.Valid;
import lombok.*;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    @PositiveOrZero(message = "Order ID must be positive or zero")
    private Integer orderId;

    private String orderNumber;

    private RestaurantDTO restaurant;

    @NotNull(message = "Customer cannot be null")
    private CustomerDTO customer;

    private boolean completed;

    @NotEmpty(message = "Item list cannot be empty")
    private List<@Valid ItemDTO> itemList;

    private BigDecimal amount;
}


