package io.swagger.implement;

import io.swagger.model.Sale;
import io.swagger.service.SaleService;
import io.swagger.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
public class ImplementSale implements SaleService {

    @Autowired
    SaleRepository saleRepository;

    @Override
    public Sale findById(Integer id) {

        return saleRepository.findByID(id);
    }

    @Override
    public List<Sale> findAll() {
        return (List<Sale>) saleRepository.findAll();
    }

    @Override
    public void saveSale(Sale s) {
        saleRepository.save(s);
    }

    @Override
    public void updateSale(Sale s) {

        Sale sale = findById(s.getId());
        if(sale != null){

            sale.setProduct(s.getProduct());
            sale.setCustomer(s.getCustomer());
            sale.setQuantity(s.getQuantity());
            sale.setCreationDate(s.getCreationDate());
            sale.setPrice(s.getPrice());
            saleRepository.save(sale);
        }

    }

    @Override
    public void deletebyId(Integer id) {

        Sale delSale = findById(id);
        if(delSale.getId() != null){
            saleRepository.deleteById(id);
        }

    }

    @Override
    public void deleteAll() {
        saleRepository.deleteAll();

    }

    @Override
    public Long countSale() {
        return saleRepository.countSale();
    }

    @Override
    public BigDecimal totalSale() {
        return saleRepository.totalSale();
    }

    @Override
    public Map<String, BigDecimal> monthlySale() {
        return saleRepository.monthSale();
    }
}
