package org.demo.documentation.fields.dictionary.dictionarydictionary.filtration;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.DictionaryValueProvider;


@Getter
@Setter
@NoArgsConstructor
public class MyExample358DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;

    @SearchParameter(name = "customFieldDictionary", provider = DictionaryValueProvider.class)
    private CustomDictionaryFiltration customFieldDictionary;

    public MyExample358DTO(MyEntity358 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}