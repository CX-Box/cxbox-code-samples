package org.demo.documentation.fields.dictionary.dictionarydictionary.old.icon;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LovValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;
import org.demo.documentation.fields.dictionary.dictionarydictionary.old.AdministeredDictionaryOld;

import static org.demo.documentation.fields.dictionary.dictionarydictionary.old.AdministeredDictionaryTypeOld.REGIONS;

@Getter
@Setter
@NoArgsConstructor
public class MyExample351DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;

    @SearchParameter(provider = LovValueProvider.class)
    @AdministeredDictionaryOld(REGIONS)
    private String customFieldDictionary;

    public MyExample351DTO(MyEntity351 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldDictionary =  REGIONS.lookupValue(entity.getCustomFieldDictionary());
    }
}