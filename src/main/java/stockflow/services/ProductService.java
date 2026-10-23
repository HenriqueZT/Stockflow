package stockflow.services;

import org.springframework.stereotype.Service;
import stockflow.dto.ProductCreateDTO;
import stockflow.dto.ProductUpdateDTO;
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

    public Product insert(ProductCreateDTO dto) {
        Product product = new Product(
                null,
                dto.getName(),
                dto.getSku(),
                dto.getPrice(),
                dto.getQuantity()
        );
        return repository.save(product);
    }

    public Product update(Long id, ProductUpdateDTO dto) {
        Product product = findById(id);
        product.setName(dto.getName());
        product.setSku(dto.getSku());
        product.setPrice(dto.getPrice());

        return repository.save(product);
    }
}
