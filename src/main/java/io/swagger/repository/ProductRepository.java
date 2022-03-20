package io.swagger.repository;

import io.swagger.model.Product;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {


    @Query("select p from Product p where p.productCode = :productCode")
    Product findByID(@Param("productCode") Integer productCode);

}
