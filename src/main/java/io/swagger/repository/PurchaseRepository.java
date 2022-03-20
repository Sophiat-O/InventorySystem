package io.swagger.repository;

import io.swagger.model.Purchase;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends CrudRepository<Purchase, Integer> {

    @Query("select p from Purchase p where p.id = :id")
    Purchase findByID(@Param("id") Integer id);
}
