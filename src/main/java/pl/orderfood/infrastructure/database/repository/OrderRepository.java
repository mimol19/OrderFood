package pl.orderfood.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.orderfood.business.dao.OrderDAO;
import pl.orderfood.domain.Order;
import pl.orderfood.infrastructure.database.entity.ItemEntity;
import pl.orderfood.infrastructure.database.entity.OrderEntity;
import pl.orderfood.infrastructure.database.repository.jpa.ItemJpaRepository;
import pl.orderfood.infrastructure.database.repository.jpa.OrderJpaRepository;
import pl.orderfood.infrastructure.database.repository.mapper.OrderEntityMapper;

import java.util.List;

@Repository
@AllArgsConstructor
public class OrderRepository implements OrderDAO {
private final OrderJpaRepository orderJpaRepository;
private final ItemJpaRepository itemJpaRepository;
private final OrderEntityMapper orderEntityMapper;
    @Override
    public Order saveOrder(Order order) {
        OrderEntity toSave = orderEntityMapper.mapToEntity(order);

        List<ItemEntity> itemList = toSave.getItemList();
        for (ItemEntity item : itemList ) {
            itemJpaRepository.save(item);
        }

        OrderEntity saved = orderJpaRepository.save(toSave);

        return orderEntityMapper.mapFromEntity(saved);
    }
}
