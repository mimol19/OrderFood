package pl.orderfood.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.orderfood.business.dao.CustomerDAO;
import pl.orderfood.domain.Customer;
import pl.orderfood.infrastructure.database.entity.CustomerEntity;
import pl.orderfood.infrastructure.database.entity.RestaurantEntity;
import pl.orderfood.infrastructure.database.repository.jpa.CustomerJpaRepository;
import pl.orderfood.infrastructure.database.repository.mapper.AddressEntityMapper;
import pl.orderfood.infrastructure.database.repository.mapper.CustomerEntityMapper;
import pl.orderfood.infrastructure.database.repository.mapper.RestaurantEntityMapper;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class CustomerRepository implements CustomerDAO {
    private final CustomerEntityMapper customerEntityMapper;
    private final CustomerJpaRepository customerJpaRepository;
    private final AddressEntityMapper addressEntityMapper;
    @Override
    public Customer saveCustomer(Customer customer) {
        CustomerEntity toSave = customerEntityMapper.mapToEntity(customer);
        Optional<CustomerEntity> existingCustomer = customerJpaRepository.
                findByEmailAndAddress(toSave.getEmail(), toSave.getAddress());

        if (existingCustomer.isPresent()) {
            return customerEntityMapper.mapFromEntity(existingCustomer.get());
        }

        CustomerEntity saved = customerJpaRepository.save(toSave);
        return customerEntityMapper.mapFromEntity(saved);
    }
}
