package pl.orderfood.infrastructure.database.repository.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.orderfood.domain.Meal;
import pl.orderfood.infrastructure.database.entity.MealEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MealEntityMapper {
    MealEntity mapToEntity(Meal meal);

    Meal mapFromEntity(MealEntity meal);
}
