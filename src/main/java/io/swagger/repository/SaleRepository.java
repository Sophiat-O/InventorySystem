package io.swagger.repository;

import io.swagger.model.Purchase;
import io.swagger.model.Sale;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

public interface SaleRepository extends CrudRepository<Sale, Integer> {

    @Query("select s from Sale s where s.id = :id")
    Purchase findByID(@Param("id") Integer id);

    @Query("select SUM(s.quantity),SUM(s.price * s.quantity) from Sale s")
    Long countSale();

    @Query("select sum(p.price * p.quantity) as price from Sale p")
    BigDecimal totalSale();

    @Query("select MONTHNAME(s.creationDate),SUM(s.price * s.quantity)"
            + "from Sale s group by MONTHNAME(s.creationDate) order by MONTHNAME(s.creationDate) DESC")
    List<Object> monthSale();
}
