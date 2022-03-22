package br.com.supermarket.utils;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public record ModelMapperConfiguration() {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
