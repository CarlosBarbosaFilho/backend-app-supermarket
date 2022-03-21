package br.com.supermarket.services;

import br.com.supermarket.controller.request.category.CategoryRequest;
import br.com.supermarket.controller.request.product.ProductRequest;
import br.com.supermarket.controller.response.product.ProductResponse;

import java.util.List;
import java.util.UUID;


public interface ProductService {

    ProductResponse create(ProductRequest request);

    List<ProductResponse> products();


    void delete(UUID id);

    void update(ProductRequest request, UUID id);
}
