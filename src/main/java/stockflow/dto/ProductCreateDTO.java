package stockflow.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public class ProductCreateDTO {

    @NotBlank(message = "O nome é obrigatório")
    private String name;
    @NotBlank(message = "O SKU é obrigatório")
    private String sku;
    @NotNull(message = "O preço é obrigatório")
    @PositiveOrZero(message = "O preço não pode ser negativo")
    private BigDecimal price;
    @NotNull(message = "A quantidade é obrigatória")
    @PositiveOrZero(message = "A quantidade não pode ser negativa")
    private Integer quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
