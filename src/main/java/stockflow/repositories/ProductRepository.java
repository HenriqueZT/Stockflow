package stockflow.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import stockflow.entities.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    public boolean existsBySku (String sku);
    public boolean existsBySkuAndIdNot (String sku, Long id);
    public List<Product> findByActive (boolean active);
}


