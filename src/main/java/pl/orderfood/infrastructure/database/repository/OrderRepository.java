package pl.orderfood.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.orderfood.business.dao.OrderDAO;
import pl.orderfood.domain.Order;
import pl.orderfood.infrastructure.database.entity.ItemEntity;
import pl.orderfood.infrastructure.database.entity.OrderEntity;
import pl.orderfood.infrastructure.database.entity.RestaurantEntity;
import pl.orderfood.infrastructure.database.repository.jpa.ItemJpaRepository;
import pl.orderfood.infrastructure.database.repository.jpa.OrderJpaRepository;
import pl.orderfood.infrastructure.database.repository.mapper.OrderEntityMapper;
import pl.orderfood.infrastructure.security.UserEntity;
import pl.orderfood.infrastructure.security.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class OrderRepository implements OrderDAO {
    private final OrderJpaRepository orderJpaRepository;
    private final ItemJpaRepository itemJpaRepository;
    private final OrderEntityMapper orderEntityMapper;
    private final UserRepository userRepository;

    @Override
    public Order saveOrder(Order order) {
        OrderEntity toSave = orderEntityMapper.mapToEntity(order);
        toSave.setOrderNumber(UUID.randomUUID().toString());
        OrderEntity saved = orderJpaRepository.save(toSave);

        List<ItemEntity> itemList = toSave.getItemList();
        for (ItemEntity item : itemList) {
            item.setOrder(saved);
            itemJpaRepository.save(item);
        }


        return orderEntityMapper.mapFromEntity(saved);
    }

    @Override
    public List<Order> getRestaurantOrders(String username) {
        UserEntity user = userRepository.findByUserName(username);
        RestaurantEntity restaurant = user.getRestaurant();

        List<OrderEntity> orders = orderJpaRepository.findByRestaurant(restaurant);
        setItemList(orders);


        return orders.stream().map(orderEntityMapper::mapFromEntity).toList();

    }

    @Override
    public Order completeOrder(Integer orderId) {
        OrderEntity order = orderJpaRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));

        order.setCompleted(true);

        OrderEntity saved = orderJpaRepository.save(order);

        return orderEntityMapper.mapFromEntity(saved);
    }

    private void setItemList(List<OrderEntity> orders) {
        for (OrderEntity order : orders) {
            List<ItemEntity> items = itemJpaRepository.findByOrder(order);
            order.setItemList(items);
        }

    }
}