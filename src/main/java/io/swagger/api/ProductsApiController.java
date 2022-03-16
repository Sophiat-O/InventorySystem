package io.swagger.api;

import io.swagger.model.Product;
import io.swagger.service.ImplementProduct;
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
    ImplementProduct productService;

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;


    List<Product> products = productService.findAllProduct();


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
       //if(products == null)
           //return  new ResponseEntity(HttpStatus.NOT_FOUND);
        return  new ResponseEntity(productService.findAllProduct(),HttpStatus.OK);
        /*String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Product>>(objectMapper.readValue("[ {\n  \"productCode\" : 4,\n  \"quantity\" : 12,\n  \"price\" : 12.99,\n  \"name\" : \"Wine\",\n  \"category\" : \"red wine\",\n  \"creationDate\" : \"2000-01-23\",\n  \"vendors\" : {\n    \"name\" : \"SomeNoobVendor\",\n    \"location\" : \"Toulouse\",\n    \"id\" : 4\n  }\n}, {\n  \"productCode\" : 4,\n  \"quantity\" : 12,\n  \"price\" : 12.99,\n  \"name\" : \"Wine\",\n  \"category\" : \"red wine\",\n  \"creationDate\" : \"2000-01-23\",\n  \"vendors\" : {\n    \"name\" : \"SomeNoobVendor\",\n    \"location\" : \"Toulouse\",\n    \"id\" : 4\n  }\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Product>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Product>>(HttpStatus.NOT_IMPLEMENTED);*/
    }

    public ResponseEntity<Void> productsPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Product body) {
        /*String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);*/
//        for(int i =0; i < products.size(); i++) {
//            if (products.get(i).getProductCode() == body.getProductCode()) {
//                return new ResponseEntity<>(HttpStatus.CONFLICT);
//            }
//        }
        productService.saveProduct(body);
        return new ResponseEntity(body.getProductCode(),HttpStatus.CREATED);
    }

    public ResponseEntity<Void> productsProductCodeDelete(@Min(1L)@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema(allowableValues={  }, minimum="1"
)) @PathVariable("productCode") Long productCode) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Product> productsProductCodeGet(@Min(1L)@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema(allowableValues={  }, minimum="1"
)) @PathVariable("productCode") Long productCode) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Product>(objectMapper.readValue("{\n  \"productCode\" : 4,\n  \"quantity\" : 12,\n  \"price\" : 12.99,\n  \"name\" : \"Wine\",\n  \"category\" : \"red wine\",\n  \"creationDate\" : \"2000-01-23\",\n  \"vendors\" : {\n    \"name\" : \"SomeNoobVendor\",\n    \"location\" : \"Toulouse\",\n    \"id\" : 4\n  }\n}", Product.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Product>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Product> productsProductCodePut(@Min(1L)@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema(allowableValues={  }, minimum="1"
)) @PathVariable("productCode") Long productCode,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Product body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Product>(objectMapper.readValue("{\n  \"productCode\" : 4,\n  \"quantity\" : 12,\n  \"price\" : 12.99,\n  \"name\" : \"Wine\",\n  \"category\" : \"red wine\",\n  \"creationDate\" : \"2000-01-23\",\n  \"vendors\" : {\n    \"name\" : \"SomeNoobVendor\",\n    \"location\" : \"Toulouse\",\n    \"id\" : 4\n  }\n}", Product.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Product>(HttpStatus.NOT_IMPLEMENTED);
    }

}
