package io.swagger.repository;
import io.swagger.model.Customer;
import io.swagger.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    @Query("select c from Customer c where c.id = :id")
    Product findByID(@Param("id") Integer id);
}
