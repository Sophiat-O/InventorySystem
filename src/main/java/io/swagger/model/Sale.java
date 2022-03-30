package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Sale
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-30T15:59:15.777Z[GMT]")


public class Sale   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("product")
  private Integer product = null;

  @JsonProperty("customer")
  private Integer customer = null;

  @JsonProperty("quantity")
  private Integer quantity = null;

  @JsonProperty("creationDate")
  private LocalDate creationDate = null;

  @JsonProperty("price")
  private BigDecimal price = null;

  public Sale id(Integer id) {
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

  public Sale product(Integer product) {
    this.product = product;
    return this;
  }

  /**
   * Get product
   * @return product
   **/
  @Schema(example = "4", required = true, description = "")
      @NotNull

    public Integer getProduct() {
    return product;
  }

  public void setProduct(Integer product) {
    this.product = product;
  }

  public Sale customer(Integer customer) {
    this.customer = customer;
    return this;
  }

  /**
   * Get customer
   * @return customer
   **/
  @Schema(example = "4", required = true, description = "")
      @NotNull

    public Integer getCustomer() {
    return customer;
  }

  public void setCustomer(Integer customer) {
    this.customer = customer;
  }

  public Sale quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * Get quantity
   * @return quantity
   **/
  @Schema(example = "50", required = true, description = "")
      @NotNull

    public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Sale creationDate(LocalDate creationDate) {
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
    public LocalDate getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(LocalDate creationDate) {
    this.creationDate = creationDate;
  }

  public Sale price(BigDecimal price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
   **/
  @Schema(example = "5.99", required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Sale sale = (Sale) o;
    return Objects.equals(this.id, sale.id) &&
        Objects.equals(this.product, sale.product) &&
        Objects.equals(this.customer, sale.customer) &&
        Objects.equals(this.quantity, sale.quantity) &&
        Objects.equals(this.creationDate, sale.creationDate) &&
        Objects.equals(this.price, sale.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, product, customer, quantity, creationDate, price);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Sale {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    product: ").append(toIndentedString(product)).append("\n");
    sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
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
