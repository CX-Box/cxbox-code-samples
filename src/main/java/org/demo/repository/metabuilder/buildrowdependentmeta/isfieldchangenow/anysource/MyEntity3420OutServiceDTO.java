package org.demo.repository.metabuilder.buildrowdependentmeta.isfieldchangenow.anysource;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.demo.repository.metabuilder.buildrowdependentmeta.isfieldchangenow.enums.CountryEnum;
import org.demo.repository.metabuilder.buildrowdependentmeta.isfieldchangenow.enums.RegionEnum;

import java.io.Serializable;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
public class MyEntity3420OutServiceDTO implements Serializable {

    private String id;
    private String customField;
    private String customFieldNew;
    private LocalDateTime customFieldDateTime;
    private Double customFieldDouble;
    @Enumerated(value = EnumType.STRING)
    private RegionEnum region;
    @Enumerated(value = EnumType.STRING)
    private CountryEnum country;
    private String product;
    private String descriptionProduct;
    private Long money;
    private String street;
}