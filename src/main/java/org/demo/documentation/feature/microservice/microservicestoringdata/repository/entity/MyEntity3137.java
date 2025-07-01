package org.demo.documentation.feature.microservice.microservicestoringdata.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.demo.documentation.feature.microservice.microservicestoringdata.repository.enums.CountryEnum;
import org.demo.documentation.feature.microservice.microservicestoringdata.repository.enums.RegionEnum;

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
    @Enumerated(value = EnumType.STRING)
    private RegionEnum region;
    @Enumerated(value = EnumType.STRING)
    private CountryEnum country;
    private String product;
    private String descriptionProduct;
    private Long money;
    private String street;
}