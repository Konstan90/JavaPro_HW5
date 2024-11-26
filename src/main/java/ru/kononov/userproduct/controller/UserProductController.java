package ru.kononov.userproduct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kononov.userproduct.entity.UserProduct;
import ru.kononov.userproduct.service.UserProductServImpl;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserProductController {

    @Autowired
    private UserProductServImpl userProductService;

    @GetMapping("/{id}/getAllProducts")
    public ResponseEntity<List<UserProduct>> getAllProducts(@PathVariable("id") BigDecimal userId) {
        List<UserProduct> products = userProductService.getAllProductsByUserId(userId);
        if (products.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(products);
    }

    @GetMapping("/getProduct")
    public ResponseEntity<UserProduct> getProduct(@RequestParam("id") Long id) {
        try {
            UserProduct product = userProductService.getProductById(id);
            return ResponseEntity.ok(product);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.notFound().build();
        }
    }
}