package pl.orderfood.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.orderfood.business.dao.RestaurantDAO;
import pl.orderfood.domain.Meal;
import pl.orderfood.domain.Restaurant;

import java.util.List;
@Slf4j
@Service
@AllArgsConstructor
public class MakeOrderService {

    private final RestaurantDAO restaurantDAO;

//    public List<Restaurant> getRestaurants(String streetName) {
//        List<Restaurant> restaurants = restaurantDAO.getRestaurantByDeliveryAddress(streetName);
//        return restaurants;
//    }
}
