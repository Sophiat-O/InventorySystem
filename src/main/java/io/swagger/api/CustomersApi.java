/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.33).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Customer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-15T17:47:53.189Z[GMT]")
@Validated
public interface CustomersApi {

    @Operation(summary = "Deletes all customers.", description = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "List of customers deleted."),
        
        @ApiResponse(responseCode = "200", description = "Unexpected error") })
    @RequestMapping(value = "/customers",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> customersDelete();


    @Operation(summary = "Returns a list of customers.", description = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "A JSON array of customers.", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Customer.class)))) })
    @RequestMapping(value = "/customers",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Customer>> customersGet();


    @Operation(summary = "Deletes a customer by id.", description = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Customer deleted."),
        
        @ApiResponse(responseCode = "400", description = "The specified customer id is invalid (not a number)."),
        
        @ApiResponse(responseCode = "404", description = "No customer with the specified id was found."),
        
        @ApiResponse(responseCode = "200", description = "Unexpected error") })
    @RequestMapping(value = "/customers/{id}",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> customersIdDelete(@Min(1L)@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema(allowableValues={  }, minimum="1"
)) @PathVariable("id") Integer id);


    @Operation(summary = "Returns a customer by ID.", description = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "A customer object.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Customer.class))),
        
        @ApiResponse(responseCode = "400", description = "The specified customer id is invalid (not a number)."),
        
        @ApiResponse(responseCode = "404", description = "No customer with the specified id was found."),
        
        @ApiResponse(responseCode = "200", description = "Unexpected error") })
    @RequestMapping(value = "/customers/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Customer> customersIdGet(@Min(1L)@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema(allowableValues={  }, minimum="1"
)) @PathVariable("id") Integer id);


    @Operation(summary = "Returns a customer by id.", description = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "A customer object.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Customer.class))),
        
        @ApiResponse(responseCode = "400", description = "The specified customer id is invalid (not a number)."),
        
        @ApiResponse(responseCode = "404", description = "No customer with the specified id was found."),
        
        @ApiResponse(responseCode = "200", description = "Unexpected error") })
    @RequestMapping(value = "/customers/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<Customer> customersIdPut(@Min(1L)@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema(allowableValues={  }, minimum="1"
)) @PathVariable("id") Integer id, @Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Customer body);


    @Operation(summary = "Create new customer", description = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "New customer created.") })
    @RequestMapping(value = "/customers",
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> customersPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Customer body);

}

