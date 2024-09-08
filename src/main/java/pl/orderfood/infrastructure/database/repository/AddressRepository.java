package pl.orderfood.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.orderfood.business.dao.AddressDAO;
import pl.orderfood.domain.Address;
import pl.orderfood.domain.Meal;
import pl.orderfood.infrastructure.database.entity.AddressEntity;
import pl.orderfood.infrastructure.database.entity.CustomerEntity;
import pl.orderfood.infrastructure.database.entity.DeliveryAddressEntity;
import pl.orderfood.infrastructure.database.entity.RestaurantEntity;
import pl.orderfood.infrastructure.database.repository.jpa.AddressJpaRepository;
import pl.orderfood.infrastructure.database.repository.jpa.DeliveryAddressJpaRepository;
import pl.orderfood.infrastructure.database.repository.mapper.AddressEntityMapper;
import pl.orderfood.infrastructure.security.UserEntity;
import pl.orderfood.infrastructure.security.UserRepository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class AddressRepository implements AddressDAO {
    private final AddressJpaRepository addressJpaRepository;
    private final DeliveryAddressRepository deliveryAddressRepository;
    private final AddressEntityMapper addressEntityMapper;
    private final UserRepository userRepository;


    @Override
    public Address saveAddress(Address address, String username) {
        Optional<AddressEntity> existingAddressOpt = addressJpaRepository.
                findByNameAndNumber(address.getName(), address.getNumber());

        AddressEntity saved;
        if (existingAddressOpt.isPresent()) {
            saved = existingAddressOpt.get();
            System.out.println(saved);
        } else {
            AddressEntity toSave = addressEntityMapper.mapToEntity(address);
            saved = addressJpaRepository.save(toSave);
        }

        deliveryAddressRepository.save(saved, username);
        return addressEntityMapper.mapFromEntity(saved);
    }

    @Override
    public Address saveAddress(Address address) {
        AddressEntity toSave = addressEntityMapper.mapToEntity(address);

        Optional<AddressEntity> existingAddress = addressJpaRepository.
                findByNameAndNumber(toSave.getName(), toSave.getNumber());

        if (existingAddress.isPresent()) {
            return addressEntityMapper.mapFromEntity(existingAddress.get());
        }

        AddressEntity saved = addressJpaRepository.save(toSave);
        return addressEntityMapper.mapFromEntity(saved);
    }

    @Override
    public Address getByName(Address address) {
        System.out.println(address);
        AddressEntity toFound = addressEntityMapper.mapToEntity(address);
        AddressEntity found = addressJpaRepository.findByName(toFound.getName());
        System.out.println(found);
        return addressEntityMapper.mapFromEntity(found);
    }

}