package io.swagger.api;

import io.swagger.model.Purchase;
import io.swagger.model.Vendor;
import io.swagger.service.PurchaseService;
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
public class PurchasesApiController implements PurchasesApi {

    private static final Logger log = LoggerFactory.getLogger(PurchasesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private PurchaseService purchaseService;

    @org.springframework.beans.factory.annotation.Autowired
    public PurchasesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> purchasesDelete() {
        purchaseService.deleteAll();
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<List<Purchase>> purchasesGet() {
        if(purchaseService.findAll() == null)
            return  new ResponseEntity(HttpStatus.NOT_FOUND);

        return  new ResponseEntity(purchaseService.findAll(),HttpStatus.OK);

    }

    public ResponseEntity<Void> purchasesIdDelete(@Min(1L)@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema(allowableValues={  }, minimum="1"
)) @PathVariable("id") Integer id) {
        if(purchaseService.findById(id) == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        purchaseService.deletebyId(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    public ResponseEntity<Purchase> purchasesIdGet(@Min(1L)@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema(allowableValues={  }, minimum="1"
)) @PathVariable("id") Integer id) {

        if(purchaseService.findById(id) == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        purchaseService.findById(id);
        return new ResponseEntity<Purchase>(purchaseService.findById(id),HttpStatus.OK);
    }

    public ResponseEntity<Purchase> purchasesIdPut(@Min(1L)@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema(allowableValues={  }, minimum="1"
)) @PathVariable("id") Integer id,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Purchase body) {

        if(purchaseService.findById(id).getId() != body.getId() || purchaseService.findById(id) == null)
            return new ResponseEntity(HttpStatus.NOT_FOUND);

        purchaseService.updatePurchase(body);
        return new ResponseEntity<Purchase>(body,HttpStatus.OK);
    }

    public ResponseEntity<Void> purchasesPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Purchase body) {

        for(int i =0; i < purchaseService.findAll().size(); i++) {
            if (purchaseService.findAll().get(i).getId() == body.getId()) {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
        }
        purchaseService.savePurchase(body);
        return new ResponseEntity(body.getId(),HttpStatus.CREATED);
    }

}
