package pl.orderfood.infrastructure.database.repository.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import pl.orderfood.domain.DeliveryAddress;
import pl.orderfood.infrastructure.database.entity.DeliveryAddressEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DeliveryAddressEntityMapper {
    @Mapping(target = "restaurant.", ignore = true)
    DeliveryAddress mapFromEntity(DeliveryAddressEntity entity);
}