package stockflow.controllers.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import stockflow.dto.ValidationErrorDTO;
import stockflow.exceptions.DuplicateSkuException;
import stockflow.exceptions.InactiveProductException;
import stockflow.exceptions.InsufficientStockException;
import stockflow.exceptions.ProductNotFoundException;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> productNotFound(ProductNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorDTO> methodArgumentNotValid(MethodArgumentNotValidException e) {
        List<String> errors = new ArrayList<>();

        for (FieldError error : e.getBindingResult().getFieldErrors()) {
            errors.add(error.getDefaultMessage());
        }

        ValidationErrorDTO dto = new ValidationErrorDTO(400, errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(dto);
    }

    @ExceptionHandler(DuplicateSkuException.class)
    public ResponseEntity<String> duplicateSku(DuplicateSkuException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(e.getMessage());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> dataIntegrityViolation(DataIntegrityViolationException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body("A operação viola uma restrição de integridade dos dados.");
    }

    @ExceptionHandler(InactiveProductException.class)
    public ResponseEntity<String> inactiveProduct(InactiveProductException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(e.getMessage());
    }

    @ExceptionHandler(InsufficientStockException.class)
    public ResponseEntity<String> insufficientStock(InsufficientStockException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(e.getMessage());
    }
}
