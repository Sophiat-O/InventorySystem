package io.swagger.repository;

import io.swagger.model.Sale;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface SaleRepository extends CrudRepository<Sale, Integer> {
}
