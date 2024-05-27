
package pl.orderfood.api.dto.mapper;


import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.orderfood.api.dto.RestaurantDTO;
import pl.orderfood.domain.Restaurant;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {
    @Mapping(target = "orders", ignore = true)
    @Mapping(target = "meals", ignore = true)
    @Mapping(target = "deliveryAddresses", ignore = true)
    Restaurant map(RestaurantDTO restaurant);
    @Mapping(target = "orders", ignore = true)
    @Mapping(target = "meals", ignore = true)
    @Mapping(target = "deliveryAddresses", ignore = true)
    RestaurantDTO mapToDTO(Restaurant restaurant);

}