package org.demo.documentation.widgets.groupinghierarhy.title;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.DateValueProvider;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.demo.documentation.widgets.groupinghierarhy.title.enums.CustomFieldDictionaryEnum;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3139DTO extends DataResponseDTO {

    private String customField;

    public static final String INFO_TEXT_EMPTY_TITLE = "Title empty. If you want to visually connect widgets by them to be placed one under another";
    public static final String INFO_TEXT_CUSTOM_TITLE = "Title calculate. Shows value provided in hidden text field, e.g. it can be calculated based on business logic of application";
    public static final String INFO_TEXT_CONST_TITLE = "Title constant. Shows constant text";
    @SearchParameter(name = "customFieldDictionary", provider = EnumValueProvider.class)
    private CustomFieldDictionaryEnum customFieldDictionary;

    public MyExample3139DTO(MyEntity3139 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();

        this.customFieldDictionary = entity.getCustomFieldDictionary();
    }
}