package stockflow.exceptions;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(Long id) {
        super("Produto não encontrado. ID: " + id);
    }
}
