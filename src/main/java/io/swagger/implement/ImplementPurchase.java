package io.swagger.implement;

import io.swagger.model.Purchase;
import  io.swagger.service.PurchaseService;
import io.swagger.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ImplementPurchase implements PurchaseService {

    @Autowired
    PurchaseRepository purchaseRepository;

    @Override
    public Purchase findById(Integer id) {
        return purchaseRepository.findByID(id);
    }

    @Override
    public List<Purchase> findAll() {
        return (List<Purchase>) purchaseRepository.findAll();
    }

    @Override
    public void savePurchase(Purchase p) {

        purchaseRepository.save(p);

    }

    @Override
    public void updatePurchase(Purchase p) {

        Purchase purchase = findById(p.getId());
        if(purchase != null){

            purchase.setId(p.getId());
            purchase.setProduct(p.getProduct());
            purchase.setVendor(p.getVendor());
            purchase.setQuantity(p.getQuantity());
            purchase.setPrice(p.getPrice());
            purchaseRepository.save(purchase);
        }

    }

    @Override
    public void deletebyId(Integer id) {

        Purchase delPurchase = findById(id);
        if(delPurchase.getId() != null){
            purchaseRepository.deleteById(id);
        }

    }

    @Override
    public void deleteAll() {

        purchaseRepository.deleteAll();

    }

    @Override
    public Long countPurchase() {
        return purchaseRepository.countPurchase();
    }

    @Override
    public BigDecimal totalPurchase() {
        return purchaseRepository.totalPurchase();
    }
}
