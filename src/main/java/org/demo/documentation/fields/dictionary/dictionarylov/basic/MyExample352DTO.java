package org.demo.documentation.fields.dictionary.dictionarylov.basic;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.DictionaryValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;
import org.demo.documentation.fields.dictionary.dictionarylov.DictinaryLovRegion;

@Getter
@Setter
@NoArgsConstructor
public class MyExample352DTO extends DataResponseDTO {

    @SearchParameter(name = "customField", provider = StringValueProvider.class)
    private String customField;

    @SearchParameter(name = "customFieldLov", provider = DictionaryValueProvider.class)
    private DictinaryLovRegion customFieldLov;

    public MyExample352DTO(MyEntity352 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldLov = entity.getCustomFieldLov();
    }
}