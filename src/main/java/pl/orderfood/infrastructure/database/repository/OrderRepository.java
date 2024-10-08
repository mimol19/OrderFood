package pl.orderfood.infrastructure.database.repository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
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

import java.util.ArrayList;
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
    public Order getOrder(Integer id) {
        Optional<OrderEntity> savedAndFetched = orderJpaRepository.findById(id);

        if (savedAndFetched.isPresent()) {
            return orderEntityMapper.mapFromEntity(savedAndFetched.get());
        } else {
            throw new EntityNotFoundException("OrderEntity with ID " + id + " not found");
        }
    }


    @Override
    public List<Order> getRestaurantOrders(String username) {
        UserEntity user = userRepository.findByUsername(username);
        RestaurantEntity restaurant = user.getRestaurant();

        List<OrderEntity> orders = orderJpaRepository.findByRestaurantAndIsCompletedFalse(restaurant);


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

}