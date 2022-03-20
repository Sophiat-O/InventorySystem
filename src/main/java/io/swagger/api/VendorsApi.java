/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.33).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Vendor;
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
public interface VendorsApi {

    @Operation(summary = "Deletes all vendors.", description = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "List of vendors deleted."),
        
        @ApiResponse(responseCode = "200", description = "Unexpected error") })
    @RequestMapping(value = "/vendors",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> vendorsDelete();


    @Operation(summary = "Returns a list of vendors.", description = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "A JSON array of vendors.", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Vendor.class)))) })
    @RequestMapping(value = "/vendors",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Vendor>> vendorsGet();


    @Operation(summary = "Deletes a vendor by id.", description = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Vendor deleted."),
        
        @ApiResponse(responseCode = "400", description = "The specified vendor id is invalid (not a number)."),
        
        @ApiResponse(responseCode = "404", description = "No vendor with the specified id was found."),
        
        @ApiResponse(responseCode = "200", description = "Unexpected error") })
    @RequestMapping(value = "/vendors/{id}",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> vendorsIdDelete(@Min(1L)@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema(allowableValues={  }, minimum="1"
)) @PathVariable("id") Integer id);


    @Operation(summary = "Returns a vendor by ID.", description = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "A vendor object.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Vendor.class))),
        
        @ApiResponse(responseCode = "400", description = "The specified vendor id is invalid (not a number)."),
        
        @ApiResponse(responseCode = "404", description = "No vendor with the specified id was found."),
        
        @ApiResponse(responseCode = "200", description = "Unexpected error") })
    @RequestMapping(value = "/vendors/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Vendor> vendorsIdGet(@Min(1L)@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema(allowableValues={  }, minimum="1"
)) @PathVariable("id") Integer id);


    @Operation(summary = "Returns a vendor by id.", description = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "A vendor object.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Vendor.class))),
        
        @ApiResponse(responseCode = "400", description = "The specified vendor id is invalid (not a number)."),
        
        @ApiResponse(responseCode = "404", description = "No vendor with the specified id was found."),
        
        @ApiResponse(responseCode = "200", description = "Unexpected error") })
    @RequestMapping(value = "/vendors/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<Vendor> vendorsIdPut(@Min(1L)@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema(allowableValues={  }, minimum="1"
)) @PathVariable("id") Integer id, @Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Vendor body);


    @Operation(summary = "Create new vendor", description = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "New vendor created.") })
    @RequestMapping(value = "/vendors",
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> vendorsPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Vendor body);

}

