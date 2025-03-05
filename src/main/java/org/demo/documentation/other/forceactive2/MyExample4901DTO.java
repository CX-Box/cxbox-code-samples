package org.demo.documentation.other.forceactive2;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BigDecimalValueProvider;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;
import org.demo.documentation.other.forceactive2.enums.CountryEnum;
import org.demo.documentation.other.forceactive2.enums.RegionEnum;

@Getter
@Setter
@NoArgsConstructor
public class MyExample4901DTO extends DataResponseDTO {

    @SearchParameter(name = "customField", provider = StringValueProvider.class)
    private String customField;
    @SearchParameter(name = "region", provider = EnumValueProvider.class)
    private RegionEnum region;
    @SearchParameter(name = "country", provider = EnumValueProvider.class)
    private CountryEnum country;
    @SearchParameter(name = "product", provider = StringValueProvider.class)
    private String product;
    @SearchParameter(name = "descriptionProduct", provider = StringValueProvider.class)
    private String descriptionProduct;
    @SearchParameter(name = "money", provider = BigDecimalValueProvider.class)
    private Long money;

    public MyExample4901DTO(MyEntity4901 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.region = entity.getRegion();
        this.country = entity.getCountry();
        this.product = entity.getProduct();
        this.descriptionProduct = entity.getDescriptionProduct();
        this.money = entity.getMoney();
    }
}