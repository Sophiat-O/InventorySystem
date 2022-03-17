package io.swagger.model;

import java.util.Objects;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.Vendor;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;

import org.hibernate.annotations.Type;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Product
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-15T17:47:53.189Z[GMT]")

@Entity
@Table(name = "product")

public class Product   {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @JsonProperty("productCode")
  private Integer productCode = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("quantity")
  private Integer quantity = null;

  @JsonProperty("category")
  private String category = null;

  @JsonProperty("price")
  private BigDecimal price = null;

  @Temporal(TemporalType.DATE)
  @JsonProperty("creationDate")
  private Date creationDate = null;

  @Type(type ="integer")
  @JsonProperty("vendors")
  private Integer vendors = null;

  public  Product(){


  }

  public Product(Integer _productCode, String _name, Integer _qty, String _category, BigDecimal _price, Date _date,Vendor _vendors ){

    this.productCode = _productCode;
    this.name = _name;
    this.quantity = _qty;
    this.category = _category;
    this.price = _price;
    this.creationDate = _date;
    this.vendors = _vendors.getId();
  }

  public Product productCode(Integer productCode) {
    this.productCode = productCode;
    return this;
  }

  /**
   * Get productCode
   * @return productCode
   **/
  @Schema(example = "4", required = true, description = "")
      @NotNull

    public Integer getProductCode() {
    return productCode;
  }

  public void setProductCode(Integer productCode) {
    this.productCode = productCode;
  }

  public Product name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   **/
  @Schema(example = "Wine", required = true, description = "")
      @NotNull

    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Product quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * Get quantity
   * @return quantity
   **/
  @Schema(example = "12", required = true, description = "")
      @NotNull

    public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Product category(String category) {
    this.category = category;
    return this;
  }

  /**
   * Get category
   * @return category
   **/
  @Schema(example = "red wine", description = "")
  
    public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public Product price(BigDecimal price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
   **/
  @Schema(example = "12.99", required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public Product creationDate(Date creationDate) {
    this.creationDate = creationDate;
    return this;
  }

  /**
   * Get creationDate
   * @return creationDate
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }

  public Product vendors(Vendor vendors) {
    this.vendors = vendors.getId();
    return this;
  }

  /**
   * Get vendors
   * @return vendors
   **/
  @Schema(description = "")
  
    @Valid
    public Integer getVendors() {
    return vendors;
  }

  public void setVendors(Integer vendors) {
    this.vendors = vendors;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Product product = (Product) o;
    return Objects.equals(this.productCode, product.productCode) &&
        Objects.equals(this.name, product.name) &&
        Objects.equals(this.quantity, product.quantity) &&
        Objects.equals(this.category, product.category) &&
        Objects.equals(this.price, product.price) &&
        Objects.equals(this.creationDate, product.creationDate) &&
        Objects.equals(this.vendors, product.vendors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productCode, name, quantity, category, price, creationDate, vendors);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Product {\n");
    
    sb.append("    productCode: ").append(toIndentedString(productCode)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    vendors: ").append(toIndentedString(vendors)).append("\n");
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
