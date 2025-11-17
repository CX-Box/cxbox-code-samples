package org.demo.repository.metabuilder.buildrowdependentmeta.isfieldchangenow;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.repository.metabuilder.buildrowdependentmeta.isfieldchangenow.enums.CountryEnum;
import org.demo.repository.metabuilder.buildrowdependentmeta.isfieldchangenow.enums.ProductTypeEnum;
import org.demo.repository.metabuilder.buildrowdependentmeta.isfieldchangenow.enums.RegionEnum;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity4901 extends BaseEntity {
    @Column
    private String customField;
    @Enumerated(value = EnumType.STRING)
    @Column
    private RegionEnum region;
    @Enumerated(value = EnumType.STRING)
    @Column
    private CountryEnum country;
    @Column
    private String product;
    @Column
    private String descriptionProduct;
    @Column
    private Long money;
    @Column
    private String street;
    @Column
    private Double customFieldDouble;

    @Enumerated(value = EnumType.STRING)
    @Column
    private ProductTypeEnum productType;
}