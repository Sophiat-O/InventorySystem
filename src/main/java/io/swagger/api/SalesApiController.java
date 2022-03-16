package io.swagger.api;

import io.swagger.model.Sale;
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
public class SalesApiController implements SalesApi {

    private static final Logger log = LoggerFactory.getLogger(SalesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public SalesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> salesDelete() {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Sale>> salesGet() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Sale>>(objectMapper.readValue("[ {\n  \"product\" : {\n    \"productCode\" : 4,\n    \"quantity\" : 12,\n    \"price\" : 12.99,\n    \"name\" : \"Wine\",\n    \"category\" : \"red wine\",\n    \"creationDate\" : \"2000-01-23\",\n    \"vendors\" : {\n      \"name\" : \"SomeNoobVendor\",\n      \"location\" : \"Toulouse\",\n      \"id\" : 4\n    }\n  },\n  \"quantity\" : 50,\n  \"price\" : 5.99,\n  \"id\" : 4,\n  \"creationDate\" : \"2000-01-23\",\n  \"customer\" : {\n    \"name\" : \"Arthur\",\n    \"id\" : 4,\n    \"store\" : {\n      \"name\" : \"Arthur\",\n      \"location\" : \"11 rue de Limogne, 31770 Colomiers\",\n      \"id\" : 4\n    },\n    \"creationDate\" : \"2000-01-23\",\n    \"email\" : \"\"\n  }\n}, {\n  \"product\" : {\n    \"productCode\" : 4,\n    \"quantity\" : 12,\n    \"price\" : 12.99,\n    \"name\" : \"Wine\",\n    \"category\" : \"red wine\",\n    \"creationDate\" : \"2000-01-23\",\n    \"vendors\" : {\n      \"name\" : \"SomeNoobVendor\",\n      \"location\" : \"Toulouse\",\n      \"id\" : 4\n    }\n  },\n  \"quantity\" : 50,\n  \"price\" : 5.99,\n  \"id\" : 4,\n  \"creationDate\" : \"2000-01-23\",\n  \"customer\" : {\n    \"name\" : \"Arthur\",\n    \"id\" : 4,\n    \"store\" : {\n      \"name\" : \"Arthur\",\n      \"location\" : \"11 rue de Limogne, 31770 Colomiers\",\n      \"id\" : 4\n    },\n    \"creationDate\" : \"2000-01-23\",\n    \"email\" : \"\"\n  }\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Sale>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Sale>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> salesIdDelete(@Min(1L)@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema(allowableValues={  }, minimum="1"
)) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Sale> salesIdGet(@Min(1L)@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema(allowableValues={  }, minimum="1"
)) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Sale>(objectMapper.readValue("{\n  \"product\" : {\n    \"productCode\" : 4,\n    \"quantity\" : 12,\n    \"price\" : 12.99,\n    \"name\" : \"Wine\",\n    \"category\" : \"red wine\",\n    \"creationDate\" : \"2000-01-23\",\n    \"vendors\" : {\n      \"name\" : \"SomeNoobVendor\",\n      \"location\" : \"Toulouse\",\n      \"id\" : 4\n    }\n  },\n  \"quantity\" : 50,\n  \"price\" : 5.99,\n  \"id\" : 4,\n  \"creationDate\" : \"2000-01-23\",\n  \"customer\" : {\n    \"name\" : \"Arthur\",\n    \"id\" : 4,\n    \"store\" : {\n      \"name\" : \"Arthur\",\n      \"location\" : \"11 rue de Limogne, 31770 Colomiers\",\n      \"id\" : 4\n    },\n    \"creationDate\" : \"2000-01-23\",\n    \"email\" : \"\"\n  }\n}", Sale.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Sale>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Sale>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Sale> salesIdPut(@Min(1L)@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema(allowableValues={  }, minimum="1"
)) @PathVariable("id") Long id,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Sale body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Sale>(objectMapper.readValue("{\n  \"product\" : {\n    \"productCode\" : 4,\n    \"quantity\" : 12,\n    \"price\" : 12.99,\n    \"name\" : \"Wine\",\n    \"category\" : \"red wine\",\n    \"creationDate\" : \"2000-01-23\",\n    \"vendors\" : {\n      \"name\" : \"SomeNoobVendor\",\n      \"location\" : \"Toulouse\",\n      \"id\" : 4\n    }\n  },\n  \"quantity\" : 50,\n  \"price\" : 5.99,\n  \"id\" : 4,\n  \"creationDate\" : \"2000-01-23\",\n  \"customer\" : {\n    \"name\" : \"Arthur\",\n    \"id\" : 4,\n    \"store\" : {\n      \"name\" : \"Arthur\",\n      \"location\" : \"11 rue de Limogne, 31770 Colomiers\",\n      \"id\" : 4\n    },\n    \"creationDate\" : \"2000-01-23\",\n    \"email\" : \"\"\n  }\n}", Sale.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Sale>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Sale>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> salesPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Sale body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
