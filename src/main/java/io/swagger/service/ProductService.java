package io.swagger.service;

import io.swagger.model.Product;
import io.swagger.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import java.util.List;

public interface ProductService {



    Product findById(Integer productCode);

    List<Product> findAll();

    void saveProduct(Product p);

    void updateProduct(Product p);


    void deletebyId(Integer id);

    void deleteAll();
}
