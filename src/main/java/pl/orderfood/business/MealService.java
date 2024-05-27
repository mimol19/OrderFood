package pl.orderfood.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.orderfood.business.dao.MealDAO;
import pl.orderfood.domain.Meal;


import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class MealService {
    private final MealDAO mealDAO;

    public List<Meal> getRestaurantMeals(String username) {
        List<Meal> meals = mealDAO.getRestaurantMeals(username);
        return meals;
    }

    @Transactional
    public Meal saveMeal(Meal meal, String username) {
        return mealDAO.saveMeal(meal,username);
    }
}
