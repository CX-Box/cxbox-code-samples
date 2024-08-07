package org.demo.documentation.feature.customizationcolumns;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BooleanValueProvider;
import org.cxbox.core.util.filter.provider.impl.DateValueProvider;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;
import org.demo.documentation.feature.customizationcolumns.enums.CustomFieldDictionaryEnum;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3135DTO extends DataResponseDTO {

    private String customField;
    @SearchParameter(name = "customFieldInput", provider = StringValueProvider.class)
    private String customFieldInput;
    @SearchParameter(name = "customFieldDate", provider = DateValueProvider.class)
    private LocalDateTime customFieldDate;
    @SearchParameter(name = "customFieldCheckBox", provider = BooleanValueProvider.class)
    private Boolean customFieldCheckBox;
    @SearchParameter(name = "customFieldDictionary", provider = EnumValueProvider.class)
    private CustomFieldDictionaryEnum customFieldDictionary;

    public MyExample3135DTO(MyEntity3135 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldInput = entity.getCustomFieldInput();
        this.customFieldDate = entity.getCustomFieldDate();
        this.customFieldCheckBox = entity.getCustomFieldCheckBox();
        this.customFieldDictionary = entity.getCustomFieldDictionary();
    }
}