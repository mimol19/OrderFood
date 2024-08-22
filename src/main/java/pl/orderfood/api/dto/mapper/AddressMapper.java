package pl.orderfood.api.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.orderfood.api.dto.AddressDTO;
import pl.orderfood.api.dto.RestaurantDTO;
import pl.orderfood.domain.Address;
import pl.orderfood.domain.Restaurant;
@Mapper(componentModel = "spring")
public interface AddressMapper {
    @Mapping(target = "customer", ignore = true)
    @Mapping(target = "deliveryAddresses", ignore = true)
    Address mapFromDTO(AddressDTO address);
    @Mapping(target = "customer", ignore = true)
    @Mapping(target = "deliveryAddresses", ignore = true)
    AddressDTO mapToDTO(Address address);
}
