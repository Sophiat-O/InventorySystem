package io.swagger.api;

import io.swagger.model.Product;
import io.swagger.model.Vendor;
import  io.swagger.service.VendorService;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-15T17:47:53.189Z[GMT]")
@RestController
public class VendorsApiController implements VendorsApi {

    private static final Logger log = LoggerFactory.getLogger(VendorsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private VendorService vendorService;

    @org.springframework.beans.factory.annotation.Autowired
    public VendorsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> vendorsDelete() {
        vendorService.deleteAll();
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<List<Vendor>> vendorsGet() {
        if(vendorService.findAll() == null)
            return  new ResponseEntity(HttpStatus.NOT_FOUND);
        return  new ResponseEntity(vendorService.findAll().toString(),HttpStatus.OK);
    }

    public ResponseEntity<Void> vendorsIdDelete(@Min(1L)@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema(allowableValues={  }, minimum="1"
)) @PathVariable("id") Integer id) {
        if(vendorService.findById(id) == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        vendorService.deletebyId(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    public ResponseEntity<Vendor> vendorsIdGet(@Min(1L)@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema(allowableValues={  }, minimum="1"
)) @PathVariable("id") Integer id) {
        if(vendorService.findById(id) == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        vendorService.findById(id);
        return new ResponseEntity<Vendor>(vendorService.findById(id),HttpStatus.OK);
    }

    public ResponseEntity<Vendor> vendorsIdPut(@Min(1L)@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema(allowableValues={  }, minimum="1"
)) @PathVariable("id") Integer id,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Vendor body) {

        if(vendorService.findById(id).getId() != body.getId() || vendorService.findById(id) == null)
            return new ResponseEntity(HttpStatus.NOT_FOUND);

        vendorService.updateVendor(body);
        return new ResponseEntity<Vendor>(body,HttpStatus.OK);
    }

    public ResponseEntity<Void> vendorsPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Vendor body) {
        for(int i =0; i < vendorService.findAll().size(); i++) {
            if (vendorService.findAll().get(i).getId() == body.getId()) {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
        }
        vendorService.saveVendor(body);
        return new ResponseEntity(body.getId(),HttpStatus.CREATED);
    }

}
