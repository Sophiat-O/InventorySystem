package io.swagger.api;

import io.swagger.model.Purchase;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.service.PurchaseService;
import io.swagger.repository.PurchaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-30T15:59:15.777Z[GMT]")
@RestController
public class TotalpurchaseApiController implements TotalpurchaseApi {

    private static final Logger log = LoggerFactory.getLogger(TotalpurchaseApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private PurchaseService purchaseService;



    @org.springframework.beans.factory.annotation.Autowired
    public TotalpurchaseApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }



    public ResponseEntity<BigDecimal> totalpurchaseGet() {
        /*String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Purchase>(objectMapper.readValue("{\n  \"product\" : 4,\n  \"quantity\" : 50,\n  \"vendor\" : 4,\n  \"price\" : 2.99,\n  \"id\" : 4\n}", Purchase.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Purchase>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Purchase>(HttpStatus.NOT_IMPLEMENTED);
    }*/
        if(purchaseService.totalPurchase() == null)
            return new ResponseEntity<BigDecimal>(HttpStatus.NO_CONTENT);
        System.out.println(purchaseService.totalPurchase());
        return new ResponseEntity<BigDecimal>(purchaseService.totalPurchase(),HttpStatus.OK);
    }

}
