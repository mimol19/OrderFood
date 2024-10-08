package pl.orderfood.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.orderfood.infrastructure.database.entity.ItemEntity;
import pl.orderfood.infrastructure.database.entity.OrderEntity;

import java.util.List;

@Repository
public interface ItemJpaRepository extends JpaRepository<ItemEntity,Integer> {

    List<ItemEntity> findByOrder(OrderEntity order);
}
