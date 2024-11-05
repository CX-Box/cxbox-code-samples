package org.demo.documentation.fields.dictionary.icon.assoc;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.demo.documentation.fields.dictionary.icon.enums.CustomFieldDictionaryEnum;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3011MultiPickDTO extends DataResponseDTO {

    private CustomFieldDictionaryEnum customFieldDictionary;

    public MyEntity3011MultiPickDTO(org.demo.documentation.fields.dictionary.icon.assoc.MyEntity3011Multi entity) {
        this.id = entity.getId().toString();
        this.customFieldDictionary = entity.getCustomFieldDictionary();
    }

}
