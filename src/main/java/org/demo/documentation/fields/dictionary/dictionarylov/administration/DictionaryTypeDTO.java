package org.demo.documentation.fields.dictionary.dictionarylov.administration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.model.dictionary.entity.DictionaryTypeDesc;


@Getter
@Setter
@NoArgsConstructor
public class DictionaryTypeDTO extends DataResponseDTO {

    private String type;

    public DictionaryTypeDTO(DictionaryTypeDesc entity) {
        this.id = entity.getId().toString();
        this.type = entity.getType();
    }

}
