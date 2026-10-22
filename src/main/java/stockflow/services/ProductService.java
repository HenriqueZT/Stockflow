package stockflow.services;

import org.springframework.stereotype.Service;
import stockflow.entities.Product;
import stockflow.exceptions.ProductNotFoundException;
import stockflow.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }
}
