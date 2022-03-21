package br.com.supermarket.controller;

import br.com.supermarket.controller.request.category.CategoryRequest;
import br.com.supermarket.controller.request.product.ProductRequest;
import br.com.supermarket.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/V1/products")
public record ProductController (ProductService productService) {

    @GetMapping
    public ResponseEntity<List<?>> all() {
        return ResponseEntity.ok(this.productService.products());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ProductRequest request) {
        return ResponseEntity.ok(this.productService.create(request));
    }

    @DeleteMapping()
    public ResponseEntity<?> delete(@RequestParam UUID id) {
        this.productService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestParam UUID id, @RequestBody ProductRequest request) {
        this.productService.update(request, id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
