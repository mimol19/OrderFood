package pl.orderfood.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import pl.orderfood.api.dto.mapper.CustomerMapper;
import pl.orderfood.api.dto.mapper.ItemMapper;
import pl.orderfood.api.dto.mapper.RestaurantMapper;
import pl.orderfood.domain.Order;
import pl.orderfood.domain.Restaurant;
import pl.orderfood.infrastructure.database.entity.CustomerEntity;
import pl.orderfood.infrastructure.database.entity.ItemEntity;
import pl.orderfood.infrastructure.database.entity.OrderEntity;

@Mapper(componentModel = "spring", uses = {CustomerEntityMapper.class, RestaurantEntityMapper.class, ItemEntityMapper.class})
public interface OrderEntityMapper {
    OrderEntity mapToEntity(Order order);
    Order mapFromEntity(OrderEntity order);
}
