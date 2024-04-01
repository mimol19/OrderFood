package pl.orderfood.infrastructure.database.repository;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Repository;
import pl.orderfood.business.dao.MealDAO;
import pl.orderfood.domain.Meal;
import pl.orderfood.infrastructure.database.entity.MealEntity;
import pl.orderfood.infrastructure.database.repository.jpa.MealJpaRepository;
import pl.orderfood.infrastructure.database.repository.mapper.MealEntityMapper;

import java.util.List;
@Repository
@AllArgsConstructor
public class MealRepository implements MealDAO {
    private final MealEntityMapper mealEntityMapper;
    private final MealJpaRepository mealJpaRepository;

    @Override
    public List<Meal> getAll() {
        List<MealEntity> meals =mealJpaRepository.findAll();

        return mealJpaRepository.findAll().stream()
                .map(mealEntityMapper::mapFromEntity)
                .toList();
    }
}
