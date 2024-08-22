package pl.orderfood.api.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.orderfood.api.dto.ItemDTO;
import pl.orderfood.domain.Item;
@Mapper(componentModel = "spring", uses = MealMapper.class)
public interface ItemMapper {
    @Mapping(target = "order",ignore = true)
    ItemDTO mapToDTO(Item item);
    @Mapping(target = "order",ignore = true)
    Item mapFromDTO(ItemDTO item);
}
