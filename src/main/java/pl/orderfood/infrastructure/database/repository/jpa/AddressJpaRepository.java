package pl.orderfood.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.orderfood.infrastructure.database.entity.AddressEntity;

import java.util.Optional;

@Repository
public interface AddressJpaRepository extends JpaRepository<AddressEntity,Integer> {

    AddressEntity findByName(String name);

    Optional<AddressEntity> findByNameAndNumber(String name, Integer number);
}
