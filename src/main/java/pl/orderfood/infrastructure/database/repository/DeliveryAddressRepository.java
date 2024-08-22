package pl.orderfood.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.orderfood.infrastructure.database.entity.AddressEntity;
import pl.orderfood.infrastructure.database.entity.DeliveryAddressEntity;
import pl.orderfood.infrastructure.database.entity.RestaurantEntity;
import pl.orderfood.infrastructure.database.repository.jpa.DeliveryAddressJpaRepository;
import pl.orderfood.infrastructure.security.UserEntity;
import pl.orderfood.infrastructure.security.UserRepository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class DeliveryAddressRepository {
    private final DeliveryAddressJpaRepository deliveryAddressJpaRepository;

    private final UserRepository userRepository;

    public List<DeliveryAddressEntity> getDeliveryAddressByAddress(AddressEntity addressEntity) {
        return deliveryAddressJpaRepository.findAllByAddress(addressEntity);
    }
    public DeliveryAddressEntity save(AddressEntity address, String username) {

        DeliveryAddressEntity toSave = new DeliveryAddressEntity();

        UserEntity user = userRepository.findByUserName(username);
        RestaurantEntity restaurant = user.getRestaurant();

        toSave.setRestaurant(restaurant);
        toSave.setAddress(address);

        Optional<DeliveryAddressEntity> existingDeliveryAddressOpt = deliveryAddressJpaRepository.
                findByAddressAndRestaurant(toSave.getAddress(), toSave.getRestaurant());

        DeliveryAddressEntity saved;
        if (existingDeliveryAddressOpt.isPresent()){
            saved = existingDeliveryAddressOpt.get();
            System.out.println(saved);
        } else {
            saved = deliveryAddressJpaRepository.save(toSave);
        }
        return saved;
    }

}
