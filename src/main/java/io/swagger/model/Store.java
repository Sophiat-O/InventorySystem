package io.swagger.model;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.Product;
import io.swagger.v3.oas.annotations.media.Schema;
import org.hibernate.annotations.Type;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.LocalDate;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Store
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-15T17:47:53.189Z[GMT]")

@Entity
@Table(name= "Store")
public class Store   {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("location")
  private String location = null;

  @Type(type ="integer")
  @JsonProperty("products")
  private Product products = null;

  public Store(){

  }

  public Store(Integer _id, String _name, String _qty, Product _product ){

    this.id = _id;
    this.name = _name;
    this.location = _qty;
    this.products = _product;

  }

  public Store id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  @Schema(example = "4", required = true, description = "")
      @NotNull

    public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Store name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   **/
  @Schema(example = "Arthur", required = true, description = "")
      @NotNull

    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Store location(String location) {
    this.location = location;
    return this;
  }

  /**
   * Get location
   * @return location
   **/
  @Schema(example = "11 rue de Limogne, 31770 Colomiers", required = true, description = "")
      @NotNull

    public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public Store products(Product products) {
    this.products = products;
    return this;
  }

  /**
   * Get products
   * @return products
   **/
  @Schema(description = "")
  
    @Valid
    public Product getProducts() {
    return products;
  }

  public void setProducts(Product products) {
    this.products = products;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Store store = (Store) o;
    return Objects.equals(this.id, store.id) &&
        Objects.equals(this.name, store.name) &&
        Objects.equals(this.location, store.location) &&
        Objects.equals(this.products, store.products);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, location, products);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Store {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    products: ").append(toIndentedString(products)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
