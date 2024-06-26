package pl.orderfood.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.orderfood.infrastructure.database.entity.MealEntity;
import pl.orderfood.infrastructure.database.entity.RestaurantEntity;

import java.util.List;

@Repository
public interface MealJpaRepository extends JpaRepository<MealEntity,Integer> {
    @Query("SELECT m FROM MealEntity m WHERE m.restaurant.restaurantId = :restaurantId ORDER BY CASE m.category " +
            "WHEN 'PRZYSTAWKI' THEN 1 " +
            "WHEN 'ZUPY' THEN 2 " +
            "WHEN 'DRUGIE_DANIA' THEN 3 " +
            "WHEN 'DESERY' THEN 4 " +
            "WHEN 'NAPOJE' THEN 5 " +
            "WHEN 'ALKOHOLE' THEN 6 END")
    List<MealEntity> findByRestaurantIdOrderByCategory(@Param("restaurantId") Integer restaurantId);
}
