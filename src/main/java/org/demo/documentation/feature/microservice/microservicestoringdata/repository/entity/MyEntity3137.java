package org.demo.documentation.feature.microservice.microservicestoringdata.repository.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;


@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MyEntity3137 extends BaseEntity {

    private String customField;
    private String customFieldNew;
    private LocalDateTime customFieldDateTime;
    private Double customFieldDouble;
    private String parentId;
}