package pl.orderfood.api.dto.mapper;


import org.mapstruct.Mapper;
import pl.orderfood.api.dto.OrderDTO;
import pl.orderfood.domain.Order;

@Mapper(componentModel = "spring", uses = {CustomerMapper.class, RestaurantMapper.class, ItemMapper.class})
public interface OrderMapper {
    OrderDTO mapToDTO(Order order);

    Order mapFromDTO(OrderDTO order);
}
