package pl.orderfood.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import pl.orderfood.business.dao.MealDAO;
import pl.orderfood.domain.Meal;


import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class MealService {
private final MealDAO mealDAO;

//TO DO PRZEPISAĆ METODE
    public List<Meal> getRestaurantMeals() {
        List<Meal> meals = mealDAO.getAll();
        return meals;
    }


    public void saveMeal(Meal meal) {

    }
}
