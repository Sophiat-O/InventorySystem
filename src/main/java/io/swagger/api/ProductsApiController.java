package io.swagger.api;

import io.swagger.model.Product;
import io.swagger.service.ProductService;
import io.swagger.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-15T17:47:53.189Z[GMT]")
@RestController
public class ProductsApiController<products> implements ProductsApi {

    private static final Logger log = LoggerFactory.getLogger(ProductsApiController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository prodRep;

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;



    @org.springframework.beans.factory.annotation.Autowired
    public ProductsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> productsDelete() {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Product>> productsGet() {
       if(productService.findAll() == null)
           return  new ResponseEntity(HttpStatus.NOT_FOUND);
        return  new ResponseEntity(productService.findAll().toString(),HttpStatus.OK);
    }

    public ResponseEntity<Void> productsPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Product body) {
        for(int i =0; i < productService.findAll().size(); i++) {
            if (productService.findAll().get(i).getProductCode() == body.getProductCode()) {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
        }
        productService.saveProduct(body);
        return new ResponseEntity(body.getProductCode(),HttpStatus.CREATED);
    }

    public ResponseEntity<Void> productsProductCodeDelete(@Min(1L)@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema(allowableValues={  }, minimum="1"
)) @PathVariable("productCode") Long productCode) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Product> productsProductCodeGet(@Min(1L)@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema(allowableValues={  }, minimum="1"
)) @PathVariable("productCode") Integer productCode) {
        if(productService.findById(productCode) == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        productService.findById(productCode);
        return new ResponseEntity<Product>(productService.findById(productCode),HttpStatus.OK);
    }

    public ResponseEntity<Void> productsProductCodePut(@Min(1L)@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema(allowableValues={  }, minimum="1"
)) @PathVariable("productCode") Product productCode,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Product body) {

        if(productService.findById(productCode.getProductCode()).getProductCode() != body.getProductCode() || productService.findById(productCode.getProductCode()) == null)
            return new ResponseEntity(HttpStatus.NOT_FOUND);

        productService.updateProduct(body);
        return new ResponseEntity(HttpStatus.OK);
    }

}
