package pl.orderfood.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import pl.orderfood.domain.Address;
import pl.orderfood.domain.Meal;
import pl.orderfood.infrastructure.database.entity.AddressEntity;
import pl.orderfood.infrastructure.database.entity.MealEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressEntityMapper {
    @Mapping(target = "customer", ignore = true)
    @Mapping(target = "deliveryAddresses", ignore = true)
    Address mapFromEntity(AddressEntity entity);
    @Mapping(target = "customer", ignore = true)
    @Mapping(target = "deliveryAddresses", ignore = true)
    AddressEntity mapToEntity(Address address);

}

