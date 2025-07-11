package org.demo.documentation.fields.money.currency.fieldkey;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BigDecimalValueProvider;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;

import org.demo.documentation.fields.money.currency.fieldkey.enums.CustomFieldCurrencyDictionaryEnum;

import static org.demo.documentation.fields.money.currency.fieldkey.enums.CustomFieldCurrencyDictionaryEnum.DOLLAR;
import static org.demo.documentation.fields.money.currency.fieldkey.enums.CustomFieldCurrencyDictionaryEnum.RUBLE;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3151DTO extends DataResponseDTO {

    @SearchParameter(name = "customFieldCurrencyDictionary", provider = EnumValueProvider.class)
    private CustomFieldCurrencyDictionaryEnum customFieldCurrency;

    @SearchParameter(name = "customField", provider = BigDecimalValueProvider.class)
    private Double customField;


    public MyExample3151DTO(MyEntity3151 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldCurrency = entity.getCustomField() > 50000 ? RUBLE : DOLLAR;

    }
}