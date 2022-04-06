package io.swagger.service;

import io.swagger.model.Sale;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface SaleService {

    Sale findById(Integer id);

    List<Sale> findAll();

    void saveSale(Sale s);

    void updateSale(Sale s);


    void deletebyId(Integer id);

    void deleteAll();

    Long countSale();

    BigDecimal totalSale();

    Map<String, BigDecimal> monthlySale();

}
