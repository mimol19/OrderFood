package pl.orderfood.api.dto.mapper;


import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.orderfood.api.dto.MealDTO;
import pl.orderfood.api.dto.OrderDTO;
import pl.orderfood.domain.Meal;
import pl.orderfood.domain.Order;

@Mapper(componentModel = "spring", uses = {CustomerMapper.class, RestaurantMapper.class, ItemMapper.class})
public interface OrderMapper {
    Order mapFromDTO(OrderDTO order);
    @Mapping(target = "amount", ignore = true)
    OrderDTO mapToDTO(Order order);
}
