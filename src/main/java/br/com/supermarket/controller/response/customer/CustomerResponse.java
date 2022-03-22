package br.com.supermarket.controller.response.customer;

import br.com.supermarket.infrastructure.domain.customer.TypeCustomer;
import lombok.Data;

import java.util.UUID;

@Data
public class CustomerResponse {

    private UUID id;
    private String name;
    private String email;
    private String document;
    private TypeCustomer typeCustomer;
}
