package br.com.supermarket.controller.response;

import lombok.Data;
import lombok.Getter;

import java.io.Serializable;
import java.util.UUID;


@Data
public class CategoryResponse {
    private UUID id;
    private String name;

}
