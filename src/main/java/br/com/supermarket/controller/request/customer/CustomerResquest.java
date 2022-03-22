package br.com.supermarket.controller.request.customer;

import br.com.supermarket.infrastructure.domain.customer.TypeCustomer;
import lombok.Data;

@Data
public class CustomerResquest {

    private String name;
    private String email;
    private String document;
    private TypeCustomer typeCustomer;
}
