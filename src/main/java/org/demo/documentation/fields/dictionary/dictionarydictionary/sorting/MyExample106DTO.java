package org.demo.documentation.fields.dictionary.dictionarydictionary.sorting;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.DictionaryValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;
import org.demo.documentation.fields.dictionary.dictionarydictionary.basic.Regions;

@Getter
@Setter
@NoArgsConstructor
public class MyExample106DTO extends DataResponseDTO {

    @SearchParameter(name = "customField", provider = StringValueProvider.class)
    private String customField;

    @SearchParameter(name = "customFieldDictionary", provider = DictionaryValueProvider.class)
    private CustomDictionarySorting customFieldDictionary;


    @SearchParameter(name = "customFieldDictionaryExample", provider = DictionaryValueProvider.class)
    private CustomDictionarySortingExample customFieldDictionaryExample;

    public MyExample106DTO(MyEntity106 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldDictionary = entity.getCustomFieldDictionary();
        this.customFieldDictionaryExample = entity.getCustomFieldDictionaryExample();
    }
}