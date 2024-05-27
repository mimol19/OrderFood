package pl.orderfood.infrastructure.database.repository.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import pl.orderfood.domain.Restaurant;
import pl.orderfood.infrastructure.database.entity.RestaurantEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RestaurantEntityMapper {
    @Mapping(target = "orders", ignore = true)
    @Mapping(target = "meals", ignore = true)
    @Mapping(target = "deliveryAddresses", ignore = true)
    RestaurantEntity mapToEntity(Restaurant restaurant);
    @Mapping(target = "orders", ignore = true)
    @Mapping(target = "meals", ignore = true)
    @Mapping(target = "deliveryAddresses", ignore = true)
    Restaurant mapFromEntity(RestaurantEntity restaurant);

}
