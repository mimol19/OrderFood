package pl.orderfood.api.dto;

import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Integer orderId;
    private String orderNumber;
    private RestaurantDTO restaurant;
    private CustomerDTO customer;
    private List<ItemDTO> itemList;
}


