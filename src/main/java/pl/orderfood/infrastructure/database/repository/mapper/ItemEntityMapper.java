package pl.orderfood.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.orderfood.domain.Item;
import pl.orderfood.infrastructure.database.entity.ItemEntity;

@Mapper(componentModel = "spring", uses = MealEntityMapper.class)
public interface ItemEntityMapper {
    @Mapping(target = "order",ignore = true)
    ItemEntity mapToEntity(Item item);
    @Mapping(target = "order",ignore = true)
    Item mapFromEntity(ItemEntity item);
}
