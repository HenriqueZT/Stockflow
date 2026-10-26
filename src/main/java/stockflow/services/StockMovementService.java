package stockflow.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stockflow.dto.StockMovementCreateDTO;
import stockflow.entities.Product;
import stockflow.entities.StockMovement;
import stockflow.entities.enums.MovementType;
import stockflow.exceptions.InactiveProductException;
import stockflow.repositories.StockMovementRepository;

import java.time.Instant;

@Service
public class StockMovementService {

    private final StockMovementRepository repository;
    private final ProductService productService;

    public StockMovementService(StockMovementRepository repository, ProductService productService) {
        this.repository = repository;
        this.productService = productService;
    }

    @Transactional
    public StockMovement insert(StockMovementCreateDTO dto) {
        Product product = productService.findById(dto.getProductId());

        if(!product.isActive()) {
            throw new InactiveProductException(product.getId());
        }
        if(dto.getType() == MovementType.ENTRY) {
            product.addStock(dto.getQuantity());
        }
        else if(dto.getType() == MovementType.EXIT) {
            product.removeStock(dto.getQuantity());
        }
        StockMovement movement = new StockMovement(null,
                product,
                dto.getType(),
                dto.getQuantity(),
                Instant.now());

        return repository.save(movement);
    }
}
