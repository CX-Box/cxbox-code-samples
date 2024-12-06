package org.demo.documentation.feature.microservice.microservicestoringdata.repository.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;



@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MyEntity380 extends BaseEntity {

    private String type;
    private String key;
    private String value;
    private Integer displayOrder;

}