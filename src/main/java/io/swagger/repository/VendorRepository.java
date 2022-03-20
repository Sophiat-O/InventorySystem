package io.swagger.repository;

import io.swagger.model.Vendor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends CrudRepository<Vendor, Integer> {

    @Query("select v from Vendor v where v.id = :id")
    Vendor findByID(@Param("id") Integer id);
}
