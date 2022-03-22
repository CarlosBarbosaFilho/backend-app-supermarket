package br.com.supermarket.services;

import br.com.supermarket.controller.request.customer.CustomerResquest;
import br.com.supermarket.controller.response.customer.CustomerResponse;
import br.com.supermarket.exceptions.business.EntityNotFoundException;
import br.com.supermarket.infrastructure.domain.customer.Customer;
import br.com.supermarket.infrastructure.repository.CustomerRepository;
import br.com.supermarket.utils.ConvertUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public record CustomerServiceImpl(CustomerRepository customerRepository, ConvertUtils convertUtils) implements CustomerService{

    @Override
    public CustomerResponse create(CustomerResquest request) {
        var customer = (Customer) this.convertUtils.convertToRequest(request, Customer.class);
        return (CustomerResponse) convertUtils.convertToResponse(this.customerRepository.save(customer), CustomerResponse.class);
    }

    @Override
    public List<CustomerResponse> products() {
        return convertUtils.convertToListResponse(this.customerRepository.findAll(), CustomerResponse.class);
    }

    @Override
    public void delete(UUID id) {
        this.customerRepository.deleteById(id);
    }

    @Override
    public void update(CustomerResquest request, UUID id) {
        var entity = this.customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity customer not found"));

        var entityUpdated = (Customer) convertUtils.convertToResponse(request, entity.getClass());
        entityUpdated.setId(id);

        this.customerRepository.save(entityUpdated);
    }
}
