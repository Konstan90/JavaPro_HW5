package ru.kononov.userproduct.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.kononov.userproduct.entity.UserProduct;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class UserProductDaoImpl implements UserProductDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<UserProduct> getAllProductsByUserId(BigDecimal userId) {
        String sql = "SELECT * FROM user_product WHERE user_id = ?";
        return jdbcTemplate.query(sql, new Object[]{userId},
                (rs, rowNum) -> {
                    UserProduct product = new UserProduct();
                    product.setId(rs.getLong("id"));
                    product.setAccountNumber(rs.getString("acc_number"));
                    product.setBalance(rs.getBigDecimal("amount"));
                    product.setProductType(rs.getString("type_product"));
                    product.setUserId(rs.getBigDecimal("user_id"));
                    return product;
                });
    }

    public UserProduct getProductById(Long id) {
        String sql = "SELECT * FROM user_product WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id},
                (rs, rowNum) -> {
                    UserProduct product = new UserProduct();
                    product.setId(rs.getLong("id"));
                    product.setAccountNumber(rs.getString("acc_number"));
                    product.setBalance(rs.getBigDecimal("amount"));
                    product.setProductType(rs.getString("type_product"));
                    product.setUserId(rs.getBigDecimal("user_id"));
                    return product;
                });
    }
}