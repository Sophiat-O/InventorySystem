package io.swagger.service;

import io.swagger.model.Purchase;


import java.util.List;

public interface PurchaseService {

    Purchase findById(Integer id);

    List<Purchase> findAll();

    void savePurchase(Purchase p);

    void updatePurchase(Purchase p);


    void deletebyId(Integer id);

    void deleteAll();
}
