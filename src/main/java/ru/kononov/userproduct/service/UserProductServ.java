package ru.kononov.userproduct.service;

import java.math.BigDecimal;
import java.util.List;

import org.apache.catalina.User;
import ru.kononov.userproduct.entity.UserProduct;

public interface UserProductServ {
    List<UserProduct> getAllProductsByUserId(BigDecimal userId);
    UserProduct getProductById(Long id);
}
