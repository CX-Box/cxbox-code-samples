package org.demo.documentation.other.forceactive2;

import jakarta.validation.constraints.DecimalMin;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BigDecimalValueProvider;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.demo.documentation.other.forceactive2.enums.CountryEnum;
import org.demo.documentation.other.forceactive2.enums.ProductTypeEnum;
import org.demo.documentation.other.forceactive2.enums.RegionEnum;

import static org.demo.documentation.fields.main.TextError.LESS_5000;

@Getter
@Setter
@NoArgsConstructor
public class MyExample4901DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;
    @SearchParameter(name = "region", provider = EnumValueProvider.class)
    private RegionEnum region;
    @SearchParameter(name = "country", provider = EnumValueProvider.class)
    private CountryEnum country;
    @SearchParameter(name = "product")
    private String product;
    @SearchParameter(name = "descriptionProduct")
    private String descriptionProduct;
    @SearchParameter(name = "money", provider = BigDecimalValueProvider.class)
    private Long money;
    @SearchParameter(name = "street")
    private String street;

    @DecimalMin(value = "5000.00", message = LESS_5000)
    @SearchParameter(name = "customFieldDouble", provider = BigDecimalValueProvider.class)
    private Double customFieldDouble;
    @SearchParameter(name = "productType", provider = EnumValueProvider.class)
    private ProductTypeEnum productType;

    public MyExample4901DTO(MyEntity4901 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.region = entity.getRegion();
        this.country = entity.getCountry();
        this.product = entity.getProduct();
        this.descriptionProduct = entity.getDescriptionProduct();
        this.money = entity.getMoney();
        this.street = entity.getStreet();
        this.customFieldDouble = entity.getCustomFieldDouble();
        this.productType = entity.getProductType();
    }
}