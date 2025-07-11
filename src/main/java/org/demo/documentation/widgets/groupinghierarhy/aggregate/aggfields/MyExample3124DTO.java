package org.demo.documentation.widgets.groupinghierarhy.aggregate.aggfields;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BigDecimalValueProvider;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.demo.documentation.widgets.groupinghierarhy.aggregate.aggfields.enums.CustomFieldDictionaryEnum;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3124DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;
    @SearchParameter(name = "customFieldDictionary", provider = EnumValueProvider.class)
    private CustomFieldDictionaryEnum customFieldDictionary;
    @SearchParameter(name = "customFieldNumber", provider = BigDecimalValueProvider.class)
    private Long customFieldNumber;
    @SearchParameter(name = "customFieldNumberOther", provider = BigDecimalValueProvider.class)
    private Long customFieldNumberOther;

    public MyExample3124DTO(MyEntity3124 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldDictionary = entity.getCustomFieldDictionary();
        this.customFieldNumber = entity.getCustomFieldNumber();
        this.customFieldNumberOther = entity.getCustomFieldNumberOther();
    }
}