
package pl.orderfood.api.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.orderfood.api.dto.MealDTO;
import pl.orderfood.domain.Meal;

@Mapper(componentModel = "spring")
public interface MealMapper {
    @Mapping(target = "itemList",ignore = true)
    @Mapping(target = "restaurant",ignore = true)
    MealDTO mapToDTO(Meal meal);
    @Mapping(target = "itemList",ignore = true)
    @Mapping(target = "restaurant",ignore = true)
    Meal mapFromDTO(MealDTO meal);
}


