package pl.orderfood.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.orderfood.infrastructure.database.entity.AddressEntity;
import pl.orderfood.infrastructure.database.entity.DeliveryAddressEntity;
import pl.orderfood.infrastructure.database.entity.RestaurantEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeliveryAddressJpaRepository extends JpaRepository<DeliveryAddressEntity,Integer> {
    List<DeliveryAddressEntity> findAllByAddress(AddressEntity addressEntity);

    Optional<DeliveryAddressEntity> findByAddressAndRestaurant(AddressEntity address, RestaurantEntity restaurant);
}
