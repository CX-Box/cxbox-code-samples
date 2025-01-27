package org.demo.documentation.fields.dictionary.dictionarydictionary.basic;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.DictionaryValueProvider;


@Getter
@Setter
@NoArgsConstructor
public class MyExample352DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;

    @SearchParameter(name = "customFieldDictionary", provider = DictionaryValueProvider.class)
    private Regions customFieldDictionary;

    public MyExample352DTO(MyEntity352 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldDictionary = entity.getCustomFieldDictionary();
    }
}