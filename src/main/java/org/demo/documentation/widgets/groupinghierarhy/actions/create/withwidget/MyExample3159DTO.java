package org.demo.documentation.widgets.groupinghierarhy.actions.create.withwidget;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;

import org.demo.documentation.widgets.groupinghierarhy.actions.create.enums.CustomFieldDictionaryEnum;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3159DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;
    @SearchParameter(name = "customFieldDictionary", provider = EnumValueProvider.class)
    private CustomFieldDictionaryEnum customFieldDictionary;
    @SearchParameter(name = "customFieldText")
    private String customFieldText;

    public MyExample3159DTO(MyEntity3159 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldDictionary = entity.getCustomFieldDictionary();
        this.customFieldText = entity.getCustomFieldText();
    }
}