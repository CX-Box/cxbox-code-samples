package org.demo.documentation.fields.dictionary.filtration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.demo.documentation.fields.dictionary.filtration.enums.CustomFieldEnum;
import org.demo.documentation.fields.dictionary.filtration.enums.CustomFieldNewEnum;
import org.demo.documentation.fields.dictionary.filtration.enums.CustomFieldSecondEnum;

@Getter
@Setter
@NoArgsConstructor
public class MyExample87DTO extends DataResponseDTO {

    @SearchParameter(name = "customField", provider = EnumValueProvider.class)
    private CustomFieldEnum customField;

    @SearchParameter(name = "customFieldNew", provider = EnumValueProvider.class)
    private CustomFieldNewEnum customFieldNew;

    @SearchParameter(name = "customFieldSecond", provider = EnumValueProvider.class)
    private CustomFieldSecondEnum customFieldSecond;

    public MyExample87DTO(MyEntity87 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldNew = entity.getCustomFieldNew();
        this.customFieldSecond = entity.getCustomFieldSecond();
    }

}