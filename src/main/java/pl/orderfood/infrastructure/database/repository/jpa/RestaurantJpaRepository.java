package pl.orderfood.infrastructure.database.repository.jpa;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.orderfood.infrastructure.database.entity.RestaurantEntity;

@Repository
public interface RestaurantJpaRepository extends JpaRepository<RestaurantEntity,Integer> {
    RestaurantEntity findByName(String name);
}
