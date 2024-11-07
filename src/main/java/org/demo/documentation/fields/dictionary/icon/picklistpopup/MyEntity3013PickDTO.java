package org.demo.documentation.fields.dictionary.icon.picklistpopup;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.demo.documentation.fields.dictionary.icon.enums.CustomFieldDictionaryEnum;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3013PickDTO extends DataResponseDTO {

    private CustomFieldDictionaryEnum customFieldDictionary;

    public MyEntity3013PickDTO(MyEntity3013 entity) {
        this.id = entity.getId().toString();
        this.customFieldDictionary = entity.getCustomFieldDictionary();
    }

}
