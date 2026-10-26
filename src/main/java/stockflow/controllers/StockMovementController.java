package stockflow.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import stockflow.dto.StockMovementCreateDTO;
import stockflow.entities.StockMovement;
import stockflow.services.StockMovementService;

@RestController
@RequestMapping("/stock-movements")
public class StockMovementController {

    private final StockMovementService service;

    public StockMovementController(StockMovementService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StockMovement insert(@Valid @RequestBody StockMovementCreateDTO dto) {
        return service.insert(dto);
    }
}
