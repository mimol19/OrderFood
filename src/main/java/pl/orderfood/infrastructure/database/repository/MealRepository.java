package pl.orderfood.infrastructure.database.repository;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import pl.orderfood.business.dao.MealDAO;
import pl.orderfood.domain.Meal;
import pl.orderfood.infrastructure.database.entity.MealEntity;
import pl.orderfood.infrastructure.database.entity.RestaurantEntity;
import pl.orderfood.infrastructure.database.repository.jpa.MealJpaRepository;
import pl.orderfood.infrastructure.database.repository.mapper.MealEntityMapper;
import pl.orderfood.infrastructure.security.UserEntity;
import pl.orderfood.infrastructure.security.UserRepository;

import java.util.List;
@Repository
@AllArgsConstructor
public class MealRepository implements MealDAO {
    private final MealEntityMapper mealEntityMapper;
    private final MealJpaRepository mealJpaRepository;
    private final UserRepository userRepository;

    @Override
    public List<Meal> getRestaurantMeals(String username) {
        UserEntity user = userRepository.findByUsername(username);
        RestaurantEntity restaurant = user.getRestaurant();

        List<MealEntity> meals =mealJpaRepository.findByRestaurantIdOrderByCategory(restaurant.getRestaurantId());

        return meals.stream().map(mealEntityMapper::mapFromEntity).toList();
    }

    @Override
    public Meal saveMeal(Meal meal, String username) {
        MealEntity toSave = mealEntityMapper.mapToEntity(meal);

        UserEntity user = userRepository.findByUsername(username);
        RestaurantEntity restaurant = user.getRestaurant();

        toSave.setRestaurant(restaurant);
        MealEntity saved = mealJpaRepository.save(toSave);

        return mealEntityMapper.mapFromEntity(saved);
    }

    @Override
    public List<Meal> getMealsByRestaurant(Integer id) {
        List<MealEntity> meals = mealJpaRepository.findByRestaurantIdOrderByCategory(id);

        return meals.stream().map(mealEntityMapper::mapFromEntity).toList();
    }
}
