package pl.orderfood.business.dao;



import pl.orderfood.domain.Meal;

import java.util.List;

public interface MealDAO {

    List<Meal> getAll();
}
