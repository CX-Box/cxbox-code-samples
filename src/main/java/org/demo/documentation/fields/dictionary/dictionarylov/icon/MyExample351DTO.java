package org.demo.documentation.fields.dictionary.dictionarylov.icon;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LovValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;
import org.demo.documentation.fields.dictionary.dictionarylov.AdministeredDictionary;

import static org.demo.documentation.fields.dictionary.dictionarylov.AdministeredDictionaryType.REGIONS;

@Getter
@Setter
@NoArgsConstructor
public class MyExample351DTO extends DataResponseDTO {

    @SearchParameter(name = "customField", provider = StringValueProvider.class)
    private String customField;

    @SearchParameter(provider = LovValueProvider.class)
    @AdministeredDictionary(REGIONS)
    private String customFieldDictionary;

    public MyExample351DTO(MyEntity351 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldDictionary =  REGIONS.lookupValue(entity.getCustomFieldDictionary());
    }
}