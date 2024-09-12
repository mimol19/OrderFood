package pl.orderfood.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.orderfood.infrastructure.database.entity.OrderEntity;
import pl.orderfood.infrastructure.database.entity.RestaurantEntity;

import java.util.List;

@Repository
public interface OrderJpaRepository extends JpaRepository<OrderEntity,Integer> {
    List<OrderEntity> findByRestaurantAndIsCompletedFalse(RestaurantEntity restaurant);
}
