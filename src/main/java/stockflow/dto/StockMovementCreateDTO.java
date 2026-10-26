package stockflow.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import stockflow.entities.enums.MovementType;

public class StockMovementCreateDTO {

    @NotNull(message = "O id do produto é obrigatório")
    @Positive(message = "O id do produto deve ser maior que zero")
    private Long productId;
    @NotNull(message = "O tipo é obrigatório")
    private MovementType type;
    @NotNull(message = "A quantidade é obrigatória")
    @Positive(message = "A quantidade deve ser maior que zero")
    private Integer quantity;


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public MovementType getType() {
        return type;
    }

    public void setType(MovementType type) {
        this.type = type;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
