package org.demo.documentation.widgets.groupinghierarhy.colortitle;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.demo.documentation.widgets.groupinghierarhy.colortitle.enums.CustomFieldDictionaryEnum;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3133DTO extends DataResponseDTO {

    private String customFieldColor;
    private String customField;
    @SearchParameter(name = "customFieldDictionary", provider = EnumValueProvider.class)
    private CustomFieldDictionaryEnum customFieldDictionary;

    public MyExample3133DTO(MyEntity3133 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldDictionary = entity.getCustomFieldDictionary();
        this.customFieldColor = entity.getCustomFieldDictionary() == CustomFieldDictionaryEnum.HIGH ? "#eda6a6" :
                (entity.getCustomFieldDictionary() == CustomFieldDictionaryEnum.LOW ? "#b3eda6" :
                        (entity.getCustomFieldDictionary() == CustomFieldDictionaryEnum.MIDDLE ? "#ffeb00" : "#6eaacc")
                );
    }
}