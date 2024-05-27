package pl.orderfood.business.dao;


import pl.orderfood.domain.Restaurant;

import java.util.List;

public interface RestaurantDAO {
    Restaurant saveRestaurant (Restaurant restaurant, String username);

    List<Restaurant> getRestaurantByDeliveryAddress(String streetName);



}
