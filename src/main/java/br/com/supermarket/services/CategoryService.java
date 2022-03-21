package br.com.supermarket.services;


import br.com.supermarket.controller.request.category.CategoryRequest;
import br.com.supermarket.controller.response.category.CategoryResponse;

import java.util.List;
import java.util.UUID;

public interface CategoryService {

    List<CategoryResponse> categories();

    CategoryResponse create(CategoryRequest request);

    void delete(UUID id);

    void update(CategoryRequest request, UUID id);
}
