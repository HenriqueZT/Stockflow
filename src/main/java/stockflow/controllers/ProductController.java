package stockflow.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import stockflow.entities.Product;
import stockflow.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product insert(@RequestBody Product product) {
        return service.insert(product);
    }
}
