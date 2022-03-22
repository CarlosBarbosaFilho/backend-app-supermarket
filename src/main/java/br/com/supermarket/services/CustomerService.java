package br.com.supermarket.services;

import br.com.supermarket.controller.request.customer.CustomerResquest;
import br.com.supermarket.controller.request.product.ProductRequest;
import br.com.supermarket.controller.response.customer.CustomerResponse;
import br.com.supermarket.controller.response.product.ProductResponse;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    CustomerResponse create(CustomerResquest request);

    List<CustomerResponse> customers();


    void delete(UUID id);

    void update(CustomerResquest request, UUID id);
}
