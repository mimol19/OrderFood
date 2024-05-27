package pl.orderfood.infrastructure.database.repository.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.springframework.web.multipart.MultipartFile;
import pl.orderfood.domain.Meal;
import pl.orderfood.infrastructure.database.entity.MealEntity;

import java.io.IOException;
import java.util.Base64;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MealEntityMapper {
    @Mapping(target = "mealPhoto", source = "mealPhoto", qualifiedByName = "Base64ToBytes")
    @Mapping(target = "itemList", ignore = true)
    @Mapping(target = "restaurant", ignore = true)
    MealEntity mapToEntity(Meal meal);

    @Mapping(target = "mealPhoto", source = "mealPhoto", qualifiedByName = "bytesToBase64")
    @Mapping(target = "itemList", ignore = true)
    @Mapping(target = "restaurant", ignore = true)
    Meal mapFromEntity(MealEntity meal);

    @Named("Base64ToBytes")
    static byte[] multipartFileToBytes(String base64) {
        return Base64.getDecoder().decode(base64);
    }


    @Named("bytesToBase64")
    static String bytesToBase64(byte[] bytes) {
        return bytes != null ? Base64.getEncoder().encodeToString(bytes) : "";
    }
}
