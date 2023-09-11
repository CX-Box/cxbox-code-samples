package org.demo.documentation.other.alltypes;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity422PickDTO extends DataResponseDTO {

    private String customField;

    public MyEntity422PickDTO(MyEntity422 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
