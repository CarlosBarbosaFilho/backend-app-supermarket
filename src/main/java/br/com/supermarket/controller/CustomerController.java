package br.com.supermarket.controller;

import br.com.supermarket.controller.request.category.CategoryRequest;
import br.com.supermarket.controller.request.customer.CustomerResquest;
import br.com.supermarket.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/V1/costomers")
public record CustomerController (CustomerService customerService) {


    @GetMapping
    public ResponseEntity<List<?>> all() {
        return ResponseEntity.ok(this.customerService.customers());
    }

    @PostMapping
        return ResponseEntity.ok(this.customerService.create(request));
    }

    @DeleteMapping()
    public ResponseEntity<?> delete(@RequestParam UUID id) {
        this.customerService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestParam UUID id, @RequestBody CustomerResquest request) {
        this.customerService.update(request, id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
