package stockflow.exceptions;

public class InactiveProductException extends RuntimeException {

    public InactiveProductException(Long id) {
        super("O produto do id " + id + " está inativo");
    }
}
