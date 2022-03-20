package io.swagger.implement;

import io.swagger.model.Product;
import io.swagger.model.Vendor;
import io.swagger.service.ProductService;
import io.swagger.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImplementProduct implements ProductService {

    @Autowired
    ProductRepository productRepository;

//    public ImplementProduct(){
//        this.productRepository = productRepository;
//   }


    @Override
    public Product findById(Integer productCode) {
        //System.out.println(productRepository.findByID(productCode));

        return  productRepository.findByID(productCode);
    }

    @Override
    public List<Product> findAll() {
        //List<Product> product = new ArrayList();
        //System.out.println(productRepository.findAll());
        //productRepository.findAll().forEach(e -> product.add(e));

        return  (List<Product>) productRepository.findAll();
    }

    @Override
    public void saveProduct(Product p) {
        productRepository.save(p);

    }

    @Override
    public void updateProduct(Product p) {

        Product product = findById(p.getProductCode());
        if(product != null){

            product.setName(p.getName());
            product.setCategory(p.getCategory());
            product.setCreationDate(p.getCreationDate());
            product.setPrice(p.getPrice());
            product.setVendors(p.getVendors());
            productRepository.save(product);
        }

    }


    @Override
    public void deletebyId(Integer productCode) {
        Product delProduct = findById(productCode);
        if(delProduct.getProductCode() != null){
            productRepository.deleteById(productCode);
        }

    }

    @Override
    public void deleteAll() {

        productRepository.deleteAll();

    }
}
