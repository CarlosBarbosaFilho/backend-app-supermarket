package br.com.supermarket.infrastructure.domain.category;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Category implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private UUID id;

    private String name;
}
