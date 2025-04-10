package org.demo.documentation.widgets.groupinghierarhy.base;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BooleanValueProvider;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.demo.documentation.widgets.groupinghierarhy.base.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.groupinghierarhy.base.enums.CustomFieldRadioEnum;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3121DTO extends DataResponseDTO {

    private String customField;
    @SearchParameter(name = "customFieldDictionary", provider = EnumValueProvider.class)
    private CustomFieldDictionaryEnum customFieldDictionary;
    @SearchParameter(name = "customFieldCheckbox", provider = BooleanValueProvider.class)
    private Boolean customFieldCheckbox;
    @SearchParameter(name = "customFieldRadio", provider = EnumValueProvider.class)
    private CustomFieldRadioEnum customFieldRadio;

    public MyExample3121DTO(MyEntity3121 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldDictionary = entity.getCustomFieldDictionary();
        this.customFieldCheckbox = entity.getCustomFieldCheckbox();
        this.customFieldRadio = entity.getCustomFieldRadio();
    }
}