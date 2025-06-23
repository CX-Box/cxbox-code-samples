package org.demo.documentation.other.forceactive2.anysource;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.demo.documentation.other.forceactive2.enums.CountryEnum;
import org.demo.documentation.other.forceactive2.enums.RegionEnum;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3420DTO extends DataResponseDTO {

    private String customField;
    private String customFieldNew;
    private Double customFieldDouble;
    private LocalDateTime customFieldDateTime;
    private RegionEnum region;
    private CountryEnum country;
    private String product;
    private String descriptionProduct;
    private Long money;
    private String street;

    public MyExample3420DTO(MyEntity3420OutServiceDTO entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldNew = entity.getCustomFieldNew();
        this.customFieldDateTime = entity.getCustomFieldDateTime();
        this.customFieldDouble = entity.getCustomFieldDouble();
        this.region = entity.getRegion();
        this.country = entity.getCountry();
        this.product = entity.getProduct();
        this.descriptionProduct = entity.getDescriptionProduct();
        this.money = entity.getMoney();
        this.street = entity.getStreet();

    }
}