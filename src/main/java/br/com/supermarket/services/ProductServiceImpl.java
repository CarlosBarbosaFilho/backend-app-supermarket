package br.com.supermarket.services;

import br.com.supermarket.controller.request.product.ProductRequest;
import br.com.supermarket.controller.response.category.CategoryResponse;
import br.com.supermarket.controller.response.product.ProductResponse;
import br.com.supermarket.exceptions.business.EntityNotFoundException;
import br.com.supermarket.infrastructure.domain.product.Product;
import br.com.supermarket.infrastructure.repository.ProductRepository;
import br.com.supermarket.utils.ConvertUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public record ProductServiceImpl(ProductRepository productRepository, ConvertUtils convertUtils) implements ProductService {

    @Override
    public ProductResponse create(ProductRequest request) {
        var entity = (Product) convertUtils.convertToRequest(request, Product.class);
        return (ProductResponse) convertUtils.convertToResponse(this.productRepository.save(entity), ProductResponse.class);
    }

    @Override
    public List<ProductResponse> products() {
        return convertUtils.convertToListResponse(this.productRepository.findAll(), ProductResponse.class);
    }

    @Override
    public void delete(UUID id) {
        this.productRepository.deleteById(id);
    }

    @Override
    public void update(ProductRequest request, UUID id) {
        var entity = this.productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity product not found"));

        var entityUpdated = (Product) convertUtils.convertToResponse(request, entity.getClass());
        entityUpdated.setId(id);

        this.productRepository.save(entityUpdated);
    }

}
