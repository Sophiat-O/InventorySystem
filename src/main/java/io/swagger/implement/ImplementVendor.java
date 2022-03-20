package io.swagger.implement;

import io.swagger.model.Product;
import io.swagger.model.Vendor;
import io.swagger.service.VendorService;
import io.swagger.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplementVendor implements VendorService {

    @Autowired
    VendorRepository vendorRepository;

    @Override
    public Vendor findById(Integer id) {

        return vendorRepository.findByID(id);
    }

    @Override
    public List<Vendor> findAll() {

        return (List<Vendor>)  vendorRepository.findAll();
    }

    @Override
    public void saveVendor(Vendor v) {
        vendorRepository.save(v);
    }

    @Override
    public void updateVendor(Vendor v) {

        Vendor vendor = findById(v.getId());
        if(vendor != null){

            vendor.setId(v.getId());
            vendor.setName(v.getName());
            vendor.setLocation(v.getLocation());
            vendorRepository.save(vendor);
        }

    }

    @Override
    public void deletebyId(Integer id) {

        Vendor delVendor = findById(id);
        if(delVendor.getId() != null){
            vendorRepository.deleteById(id);
        }

    }

    @Override
    public void deleteAll() {
        vendorRepository.deleteAll();

    }
}
