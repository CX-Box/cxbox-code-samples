package org.demo.documentation.fields.dictionary.dictionarydictionary.filtration;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.DictionaryValueProvider;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;


@Getter
@Setter
@NoArgsConstructor
public class MyExample358DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;
    @SearchParameter(name = "customFieldDictionarySecond", provider = DictionaryValueProvider.class)
    private CustomDictionaryFiltrationSecond customFieldDictionarySecond;
    @SearchParameter(name = "customFieldDictionary", provider = DictionaryValueProvider.class)
    private CustomDictionaryFiltration customFieldDictionary;
    @SearchParameter(name = "customFieldNewDictionary", provider = DictionaryValueProvider.class)
    private CustomDictionaryNewFiltration customFieldNewDictionary;

    public MyExample358DTO(MyEntity358 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldDictionary = entity.getCustomFieldDictionary();
        this.customFieldNewDictionary = entity.getCustomFieldNewDictionary();
        this.customFieldDictionarySecond = entity.getCustomFieldDictionarySecond();
    }
}