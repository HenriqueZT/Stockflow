package stockflow.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import stockflow.dto.ProductCreateDTO;
import stockflow.dto.ProductUpdateDTO;
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
    public Product insert(@Valid @RequestBody ProductCreateDTO dto) {
        return service.insert(dto);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable("id") Long id, @Valid @RequestBody ProductUpdateDTO dto) {
        return service.update(id, dto);
    }
}
