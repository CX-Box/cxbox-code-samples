package org.demo.documentation.widgets.groupinghierarhy.actions.edit.withwidget;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;

import org.demo.documentation.widgets.groupinghierarhy.actions.edit.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.groupinghierarhy.actions.edit.withwidget.enums.CustomFieldDictionary2Enum;
import org.demo.documentation.widgets.groupinghierarhy.actions.edit.withwidget.enums.CustomFieldDictionary3Enum;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3168DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;
    @SearchParameter(name = "customFieldDictionary", provider = EnumValueProvider.class)
    private CustomFieldDictionaryEnum customFieldDictionary;
    @SearchParameter(name = "customFieldDictionary2", provider = EnumValueProvider.class)
    private CustomFieldDictionary2Enum customFieldDictionary2;
    @SearchParameter(name = "customFieldDictionary3", provider = EnumValueProvider.class)
    private CustomFieldDictionary3Enum customFieldDictionary3;

    public MyExample3168DTO(MyEntity3168 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldDictionary = entity.getCustomFieldDictionary();
        this.customFieldDictionary2 = entity.getCustomFieldDictionary2();
        this.customFieldDictionary3 = entity.getCustomFieldDictionary3();
    }
}