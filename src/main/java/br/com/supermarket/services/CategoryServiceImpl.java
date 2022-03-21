package br.com.supermarket.services;

import br.com.supermarket.controller.request.category.CategoryRequest;
import br.com.supermarket.controller.response.CategoryResponse;
import br.com.supermarket.exceptions.business.EntityNotFoundException;
import br.com.supermarket.infrastructure.domain.category.Category;
import br.com.supermarket.infrastructure.repository.CategoryRepository;
import br.com.supermarket.utils.ConvertUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public record CategoryServiceImpl(CategoryRepository categoryRepository, ConvertUtils convertUtils) implements CategoryService {

    @Override
    public List<CategoryResponse> categories() {
        return (List<CategoryResponse>)
                convertUtils.convertToListResponse(this.categoryRepository.findAll(), CategoryResponse.class);
    }

    @Override
    public CategoryResponse create(CategoryRequest request) {
        var entity = (Category) convertUtils.convertToRequest(request, Category.class);
        return (CategoryResponse) convertUtils.convertToResponse(this.categoryRepository.save(entity), CategoryResponse.class);
    }

    @Override
    public void delete(UUID id) {
        this.categoryRepository.deleteById(id);
    }

    @Override
    public void update(CategoryRequest request, UUID id) {
        var entity = this.categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found"));

        var entityUpdated = (Category) convertUtils.convertToResponse(request, entity.getClass());
        entityUpdated.setId(id);

        this.categoryRepository.save(entityUpdated);

    }

}
