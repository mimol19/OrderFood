package pl.orderfood.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.orderfood.business.dao.RestaurantDAO;
import pl.orderfood.domain.Address;
import pl.orderfood.domain.Restaurant;
import pl.orderfood.infrastructure.database.entity.AddressEntity;
import pl.orderfood.infrastructure.database.entity.DeliveryAddressEntity;
import pl.orderfood.infrastructure.database.entity.RestaurantEntity;
import pl.orderfood.infrastructure.database.repository.jpa.DeliveryAddressJpaRepository;
import pl.orderfood.infrastructure.database.repository.jpa.RestaurantJpaRepository;
import pl.orderfood.infrastructure.database.repository.mapper.AddressEntityMapper;
import pl.orderfood.infrastructure.database.repository.mapper.RestaurantEntityMapper;
import pl.orderfood.infrastructure.security.UserEntity;
import pl.orderfood.infrastructure.security.UserRepository;

import java.util.List;

@Repository
@AllArgsConstructor
public class RestaurantRepository implements RestaurantDAO {

    private final RestaurantEntityMapper restaurantEntityMapper;
    private final AddressEntityMapper addressEntityMapper;
    private final RestaurantJpaRepository restaurantJpaRepository;
    private final AddressRepository addressRepository;
    private final DeliveryAddressRepository deliveryAddressRepository;
    private final UserRepository userRepository;


    @Override
    public Restaurant saveRestaurant(Restaurant restaurant, String username) {
        RestaurantEntity toSave = restaurantEntityMapper.mapToEntity(restaurant);
        RestaurantEntity saved = restaurantJpaRepository.save(toSave);
        UserEntity user = userRepository.findByUsername(username);
        user.setRestaurant(saved);
        return restaurantEntityMapper.mapFromEntity(saved);

    }

    @Override
    public List<Restaurant> getRestaurantByAddress(Address address) {
        AddressEntity addressEntity = addressEntityMapper.mapToEntity(address);
        List<DeliveryAddressEntity> deliveryAddressEntities = deliveryAddressRepository
                .getDeliveryAddressByAddress(addressEntity);

        List<RestaurantEntity> restaurantEntityList = deliveryAddressEntities.stream()
                .map(DeliveryAddressEntity::getRestaurant).toList();

        return restaurantEntityList.stream().map(restaurantEntityMapper::mapFromEntity).toList();
    }


}
