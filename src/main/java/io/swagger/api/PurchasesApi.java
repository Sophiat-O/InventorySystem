/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.33).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Purchase;
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
public interface PurchasesApi {

    @Operation(summary = "Deletes all purchases.", description = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "List of purchases deleted."),
        
        @ApiResponse(responseCode = "200", description = "Unexpected error") })
    @RequestMapping(value = "/purchases",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> purchasesDelete();


    @Operation(summary = "Returns a list of purchases.", description = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "A JSON array of purchases.", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Purchase.class)))) })
    @RequestMapping(value = "/purchases",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Purchase>> purchasesGet();


    @Operation(summary = "Deletes a purchase by id.", description = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Purchase deleted."),
        
        @ApiResponse(responseCode = "400", description = "The specified purchase id is invalid (not a number)."),
        
        @ApiResponse(responseCode = "404", description = "No purchase with the specified id was found."),
        
        @ApiResponse(responseCode = "200", description = "Unexpected error") })
    @RequestMapping(value = "/purchases/{id}",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> purchasesIdDelete(@Min(1L)@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema(allowableValues={  }, minimum="1"
)) @PathVariable("id") Long id);


    @Operation(summary = "Returns a purchase by ID.", description = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "A purchase object.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Purchase.class))),
        
        @ApiResponse(responseCode = "400", description = "The specified purchase id is invalid (not a number)."),
        
        @ApiResponse(responseCode = "404", description = "No purchase with the specified id was found."),
        
        @ApiResponse(responseCode = "200", description = "Unexpected error") })
    @RequestMapping(value = "/purchases/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Purchase> purchasesIdGet(@Min(1L)@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema(allowableValues={  }, minimum="1"
)) @PathVariable("id") Long id);


    @Operation(summary = "Returns a purchase by id.", description = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "A purchase object.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Purchase.class))),
        
        @ApiResponse(responseCode = "400", description = "The specified purchase id is invalid (not a number)."),
        
        @ApiResponse(responseCode = "404", description = "No purchase with the specified id was found."),
        
        @ApiResponse(responseCode = "200", description = "Unexpected error") })
    @RequestMapping(value = "/purchases/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<Purchase> purchasesIdPut(@Min(1L)@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema(allowableValues={  }, minimum="1"
)) @PathVariable("id") Long id, @Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Purchase body);


    @Operation(summary = "Create new purchase", description = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "New purchase created.") })
    @RequestMapping(value = "/purchases",
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> purchasesPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Purchase body);

}
