package pl.orderfood.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.orderfood.business.dao.MealDAO;
import pl.orderfood.domain.Meal;


import java.util.Collection;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class MealService {
    private final MealDAO mealDAO;

    public List<Meal> getRestaurantMeals(String username) {
        return mealDAO.getRestaurantMeals(username);
    }

    @Transactional
    public Meal saveMeal(Meal meal, String username) {
        return mealDAO.saveMeal(meal,username);
    }

    public List<Meal> getMealsByRestaurant(Integer id) {
        return mealDAO.getMealsByRestaurant(id);
    }
}
