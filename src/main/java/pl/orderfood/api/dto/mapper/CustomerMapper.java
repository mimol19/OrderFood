package pl.orderfood.api.dto.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.orderfood.api.dto.CustomerDTO;
import pl.orderfood.api.dto.MealDTO;
import pl.orderfood.domain.Customer;
import pl.orderfood.domain.Meal;

@Mapper(componentModel = "spring", uses = AddressMapper.class)
public interface CustomerMapper {
    @Mapping(target = "orders", ignore = true)
    CustomerDTO mapToDTO(Customer customer);

    @Mapping(target = "orders", ignore = true)
    Customer mapFromDTO(CustomerDTO customer);
}
