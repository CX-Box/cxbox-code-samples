package org.demo.documentation.widgets.groupinghierarhy.showcondition.bycurrententity;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;
import org.demo.documentation.widgets.groupinghierarhy.showcondition.bycurrententity.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.list.showcondition.bycurrententity.MyEntity3101;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3147DTO extends DataResponseDTO {

    public static final String TEXT = "Сondition can include boolean expression depending on current entity fields. Field updates will trigger condition recalculation only on save or if field is force active";

    public static final String TEXT2 = "Show condition - if CustomField  > 5 widget show.";
    private Long customField;
    @SearchParameter(name = "customFieldDictionary", provider = EnumValueProvider.class)
    private CustomFieldDictionaryEnum customFieldDictionary;
    private String customFieldShowCond;
    public MyExample3147DTO(MyEntity3147 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldDictionary = entity.getCustomFieldDictionary();
        this.customFieldShowCond = entity.getCustomField() > 5 ? "true" : "false";
    }

}