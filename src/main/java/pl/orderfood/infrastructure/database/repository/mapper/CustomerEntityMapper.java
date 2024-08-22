package pl.orderfood.infrastructure.database.repository.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import pl.orderfood.api.dto.CustomerDTO;
import pl.orderfood.api.dto.mapper.AddressMapper;
import pl.orderfood.domain.Customer;
import pl.orderfood.infrastructure.database.entity.CustomerEntity;

@Mapper(componentModel = "spring", uses = AddressEntityMapper.class)
public interface CustomerEntityMapper {
    @Mapping(target = "orders", ignore = true)
    CustomerEntity mapToEntity(Customer customer);

    @Mapping(target = "orders", ignore = true)
    Customer mapFromEntity(CustomerEntity customer);
}
