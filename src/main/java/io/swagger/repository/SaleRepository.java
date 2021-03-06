package io.swagger.repository;


import io.swagger.model.Sale;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface SaleRepository extends CrudRepository<Sale, Integer> {

    @Query("select s from Sale s where s.id = :id")
    Sale findByID(@Param("id") Integer id);

    @Query("select SUM(s.quantity),SUM(s.price * s.quantity) from Sale s")
    Long countSale();

    @Query("select sum(p.price * p.quantity) as price from Sale p")
    BigDecimal totalSale();

    @Query("select SUM(s.price * s.quantity),DATE_FORMAT(s.creationDate,'%b')"
            + "from Sale s group by DATE_FORMAT(s.creationDate,'%b')")
    List<String> monthSale();

    @Query(value = "SELECT  p.name, (COUNT(s.product)/(SELECT COUNT(*) FROM Inventory.sale s2)) * 100 AS PercentageSold \n" +
            "FROM Inventory.sale s JOIN Inventory.product p ON s.product = p.product_code \n" +
            "GROUP BY p.name \n" +
            "ORDER BY PercentageSold DESC", nativeQuery = true)
    List<String> topProduct();
}
