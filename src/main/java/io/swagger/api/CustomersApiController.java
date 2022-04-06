package io.swagger.api;

import io.swagger.model.Customer;
import io.swagger.model.Product;
import io.swagger.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-15T17:47:53.189Z[GMT]")
@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false")
@RestController
public class CustomersApiController implements CustomersApi {

    private static final Logger log = LoggerFactory.getLogger(CustomersApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private CustomerService customerService;

    @org.springframework.beans.factory.annotation.Autowired
    public CustomersApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> customersDelete() {
        customerService.deleteAll();
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<List<Customer>> customersGet() {
        if(customerService.findAll() == null)
            return  new ResponseEntity(HttpStatus.NOT_FOUND);
        return  new ResponseEntity(customerService.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<Void> customersIdDelete(@Min(1L)@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema(allowableValues={  }, minimum="1"
)) @PathVariable("id") Integer id) {
        if(customerService.findById(id) == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        customerService.deletebyId(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    public ResponseEntity<Customer> customersIdGet(@Min(1L)@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema(allowableValues={  }, minimum="1"
)) @PathVariable("id") Integer id) {
        if(customerService.findById(id) == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        customerService.findById(id);
        return new ResponseEntity<Customer>(customerService.findById(id),HttpStatus.OK);
    }

    public ResponseEntity<Customer> customersIdPut(@Min(1L)@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema(allowableValues={  }, minimum="1"
)) @PathVariable("id") Integer id,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Customer body) {

        if(customerService.findById(id).getId() != body.getId() || customerService.findById(id) == null)
            return new ResponseEntity(HttpStatus.NOT_FOUND);

        customerService.updateCustomer(body);
        return new ResponseEntity(body,HttpStatus.OK);
    }

    public ResponseEntity<Void> customersPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Customer body) {

        for(int i =0; i < customerService.findAll().size(); i++) {
            if (customerService.findAll().get(i).getId() == body.getId()) {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
        }
        customerService.saveCustomer(body);
        return new ResponseEntity(body.getId(),HttpStatus.CREATED);
    }

}
