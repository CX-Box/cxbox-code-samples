package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.defaultexpanded;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.defaultexpanded.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.defaultexpanded.enums.CustomFieldDictionaryLevelThreeEnum;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.defaultexpanded.enums.CustomFieldDictionaryLevelTwoEnum;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3203DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;
    @SearchParameter(name = "customFieldDictionary", provider = EnumValueProvider.class)
    private CustomFieldDictionaryEnum customFieldDictionary;
    @SearchParameter(name = "customFieldDictionaryLevelTwo", provider = EnumValueProvider.class)
    private CustomFieldDictionaryLevelTwoEnum customFieldDictionaryLevelTwo;
    @SearchParameter(name = "customFieldDictionaryLevelThree", provider = EnumValueProvider.class)
    private CustomFieldDictionaryLevelThreeEnum customFieldDictionaryLevelThree;

    public MyExample3203DTO(MyEntity3203 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldDictionary = entity.getCustomFieldDictionary();
        this.customFieldDictionaryLevelTwo = entity.getCustomFieldDictionaryLevelTwo();
        this.customFieldDictionaryLevelThree = entity.getCustomFieldDictionaryLevelThree();
    }
}