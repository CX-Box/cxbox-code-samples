package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.threelevel;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;

import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.threelevel.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.threelevel.enums.CustomFieldDictionaryLevelThreeEnum;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.threelevel.enums.CustomFieldDictionaryLevelTwoEnum;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3165DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;
    @SearchParameter(name = "customFieldDictionary", provider = EnumValueProvider.class)
    private CustomFieldDictionaryEnum customFieldDictionary;
    @SearchParameter(name = "customFieldDictionaryLevelThree", provider = EnumValueProvider.class)
    private CustomFieldDictionaryLevelThreeEnum customFieldDictionaryLevelThree;
    @SearchParameter(name = "customFieldDictionaryLevelTwo", provider = EnumValueProvider.class)
    private CustomFieldDictionaryLevelTwoEnum customFieldDictionaryLevelTwo;

    public MyExample3165DTO(MyEntity3165 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldDictionary = entity.getCustomFieldDictionary();
        this.customFieldDictionaryLevelThree = entity.getCustomFieldDictionaryLevelThree();
        this.customFieldDictionaryLevelTwo = entity.getCustomFieldDictionaryLevelTwo();
    }
}