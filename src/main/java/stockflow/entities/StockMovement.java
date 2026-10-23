package stockflow.entities;

import jakarta.persistence.*;
import stockflow.entities.enums.MovementType;

import java.time.Instant;

@Entity
@Table(name = "tb_stock_movement")
public class StockMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MovementType type;
    @Column(nullable = false)
    private Integer quantity;
    @Column(nullable = false)
    private Instant moment;

    public StockMovement() {
    }

    public StockMovement(Long id, Product product, MovementType type, Integer quantity, Instant moment) {
        this.id = id;
        this.product = product;
        this.type = type;
        this.quantity = quantity;
        this.moment = moment;
    }

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public MovementType getType() {
        return type;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Instant getMoment() {
        return moment;
    }
}
