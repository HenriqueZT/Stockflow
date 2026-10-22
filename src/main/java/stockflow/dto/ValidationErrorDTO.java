package stockflow.dto;

import java.util.List;

public class ValidationErrorDTO {

    private int status;
    private List<String> errors;

    public ValidationErrorDTO(int status, List<String> errors) {
        this.status = status;
        this.errors = errors;
    }

    public int getStatus() {
        return status;
    }

    public List<String> getErrors() {
        return errors;
    }
}
