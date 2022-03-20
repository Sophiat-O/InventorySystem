package io.swagger.service;

import io.swagger.model.Vendor;


import java.util.List;

public interface VendorService {

    Vendor findById(Integer id);

    List<Vendor> findAll();

    void saveVendor(Vendor v);

    void updateVendor(Vendor v);


    void deletebyId(Integer id);

    void deleteAll();
}
