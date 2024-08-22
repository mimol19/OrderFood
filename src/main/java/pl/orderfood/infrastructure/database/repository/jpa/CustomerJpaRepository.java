package pl.orderfood.infrastructure.database.repository.jpa;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.orderfood.infrastructure.database.entity.AddressEntity;
import pl.orderfood.infrastructure.database.entity.CustomerEntity;

import java.util.Optional;

@Repository
public interface CustomerJpaRepository extends JpaRepository<CustomerEntity,Integer> {
    Optional<CustomerEntity> findByEmailAndAddress( String email, AddressEntity address);

}