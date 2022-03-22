package br.com.supermarket.controller.request.product;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ProductRequest {

    private String name;
    private BigDecimal price;
}
