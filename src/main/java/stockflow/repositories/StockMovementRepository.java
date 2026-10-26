package stockflow.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import stockflow.entities.StockMovement;

public interface StockMovementRepository extends JpaRepository<StockMovement, Long> {

}
