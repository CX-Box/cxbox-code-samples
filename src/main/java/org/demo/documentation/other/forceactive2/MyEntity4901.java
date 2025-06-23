package org.demo.documentation.other.forceactive2;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.other.forceactive2.enums.CountryEnum;
import org.demo.documentation.other.forceactive2.enums.ProductTypeEnum;
import org.demo.documentation.other.forceactive2.enums.RegionEnum;

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