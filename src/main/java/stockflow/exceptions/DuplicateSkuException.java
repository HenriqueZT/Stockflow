package stockflow.exceptions;

public class DuplicateSkuException extends RuntimeException {

    public DuplicateSkuException(String sku) {
        super("O SKU " + sku + " já está cadastrado.");
    }
}
