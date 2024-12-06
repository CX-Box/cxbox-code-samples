package org.demo.documentation.fields.dictionary.dictionarylov.anysorce.dictionaryanysource;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample380DTO extends DataResponseDTO {

    private String type;
    private String key;
    private String value;
    private Integer displayOrder;

    public MyExample380DTO(MyEntity380OutServiceDTO entity) {

        this.type = entity.getType();
        this.key = entity.getKey();
        this.value = entity.getValue();
        this.displayOrder = entity.getDisplayOrder();
    }
}