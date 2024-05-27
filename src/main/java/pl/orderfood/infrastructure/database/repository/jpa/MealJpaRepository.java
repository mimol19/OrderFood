package pl.orderfood.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.orderfood.infrastructure.database.entity.MealEntity;
import pl.orderfood.infrastructure.database.entity.RestaurantEntity;

import java.util.List;

@Repository
public interface MealJpaRepository extends JpaRepository<MealEntity,Integer> {
    List<MealEntity> findByRestaurant(RestaurantEntity restaurant);
}
