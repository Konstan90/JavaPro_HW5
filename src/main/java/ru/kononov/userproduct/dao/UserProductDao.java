package ru.kononov.userproduct.dao;

import ru.kononov.userproduct.entity.UserProduct;
import java.math.BigDecimal;
import java.util.List;

public interface UserProductDao {
    List<UserProduct> getAllProductsByUserId(BigDecimal userId);
    UserProduct getProductById(Long id);
}


