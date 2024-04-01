package pl.orderfood.business;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;
import pl.orderfood.business.dao.RestaurantDAO;
import pl.orderfood.domain.Meal;
import pl.orderfood.domain.Restaurant;


import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class RestaurantService {
    private final RestaurantDAO restaurantDAO;

    public Meal createMeal(Map<String, List<String>> inputData) {

        return null;

    }

    @Transactional
    public Restaurant saveRestaurant(Restaurant restaurant) {
        return restaurantDAO.saveRestaurant(restaurant);
    }
}

