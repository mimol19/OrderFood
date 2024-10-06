package pl.orderfood.business;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.orderfood.api.dto.RestaurantDTO;
import pl.orderfood.business.dao.AddressDAO;
import pl.orderfood.business.dao.RestaurantDAO;
import pl.orderfood.domain.Address;
import pl.orderfood.domain.Meal;
import pl.orderfood.domain.Restaurant;
import pl.orderfood.infrastructure.database.entity.RestaurantEntity;


import java.util.List;
import java.util.Map;
@Slf4j
@Service
@AllArgsConstructor
public class RestaurantService {
    private final RestaurantDAO restaurantDAO;
    private final AddressDAO addressDAO;

    @Transactional
    public Restaurant saveRestaurant(Restaurant restaurant, String username) {
        return restaurantDAO.saveRestaurant(restaurant, username);
    }


    public List<Restaurant> getRestaurantByAddress(Address address) {
        Address found = addressDAO.getByName(address);
        return restaurantDAO.getRestaurantByAddress(found);
    }
}

