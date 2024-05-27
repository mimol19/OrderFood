package pl.orderfood.business.dao;



import org.springframework.web.multipart.MultipartFile;
import pl.orderfood.domain.Meal;

import java.util.List;

public interface MealDAO {

    List<Meal> getRestaurantMeals(String username);

    Meal saveMeal(Meal meal, String username);
}
