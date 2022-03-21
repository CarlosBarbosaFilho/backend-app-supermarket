package br.com.supermarket.controller;

import br.com.supermarket.controller.request.category.CategoryRequest;
import br.com.supermarket.controller.response.CategoryResponse;
import br.com.supermarket.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/V1/categories")
public record CategoryController(CategoryService categoryService) {

    @GetMapping
    public ResponseEntity<List<?>> all() {
        return ResponseEntity.ok(this.categoryService.categories());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CategoryRequest request) {
        return ResponseEntity.ok(this.categoryService.create(request));
    }

    @DeleteMapping()
    public ResponseEntity<?> delete(@RequestParam UUID id) {
        this.categoryService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestParam UUID id, @RequestBody CategoryRequest request) {
        this.categoryService.update(request, id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    
}
