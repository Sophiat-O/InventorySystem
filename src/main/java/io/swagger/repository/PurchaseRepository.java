package io.swagger.repository;

import io.swagger.model.Purchase;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface PurchaseRepository extends CrudRepository<Purchase, Integer> {

    @Query("select p from Purchase p where p.id = :id")
    Purchase findByID(@Param("id") Integer id);

    @Query("select sum(p.quantity) from Purchase p")
    Long countPurchase();

    @Query("select sum(p.price * p.quantity) as price from Purchase p")
    BigDecimal totalPurchase();
}
