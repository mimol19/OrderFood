package pl.orderfood.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.orderfood.business.dao.RestaurantDAO;
import pl.orderfood.domain.Restaurant;
import pl.orderfood.infrastructure.database.entity.RestaurantEntity;
import pl.orderfood.infrastructure.database.repository.jpa.DeliveryAddressJpaRepository;
import pl.orderfood.infrastructure.database.repository.jpa.RestaurantJpaRepository;
import pl.orderfood.infrastructure.database.repository.mapper.RestaurantEntityMapper;
import pl.orderfood.infrastructure.security.UserEntity;
import pl.orderfood.infrastructure.security.UserRepository;

import java.util.List;

@Repository
@AllArgsConstructor
public class RestaurantRepository implements RestaurantDAO {

    private final RestaurantEntityMapper restaurantEntityMapper;
    private final RestaurantJpaRepository restaurantJpaRepository;
    private final DeliveryAddressRepository deliveryAddressRepository;
    private final UserRepository userRepository;

    @Override
    public Restaurant saveRestaurant(Restaurant restaurant, String username) {
        RestaurantEntity toSave = restaurantEntityMapper.mapToEntity(restaurant);
        RestaurantEntity saved = restaurantJpaRepository.save(toSave);
        UserEntity user = userRepository.findByUserName(username);
        user.setRestaurant(saved);
        return restaurantEntityMapper.mapFromEntity(saved);

    }

    @Override
    public List<Restaurant> getRestaurantByDeliveryAddress(String streetName) {

        return null;
    }



}
