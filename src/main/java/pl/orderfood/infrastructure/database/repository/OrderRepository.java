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
import java.util.UUID;

@Repository
@AllArgsConstructor
public class OrderRepository implements OrderDAO {
private final OrderJpaRepository orderJpaRepository;
private final ItemJpaRepository itemJpaRepository;
private final OrderEntityMapper orderEntityMapper;
    @Override
    public Order saveOrder(Order order) {
        OrderEntity toSave = orderEntityMapper.mapToEntity(order);
        toSave.setOrderNumber(UUID.randomUUID().toString());
        OrderEntity saved = orderJpaRepository.save(toSave);

        List<ItemEntity> itemList = toSave.getItemList();
        for (ItemEntity item : itemList ) {
            item.setOrder(saved);
            itemJpaRepository.save(item);
        }


        return orderEntityMapper.mapFromEntity(saved);
    }
}
