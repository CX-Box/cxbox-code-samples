package org.demo.documentation.other.twobcshowcondition.child;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3145DTO extends DataResponseDTO {

    private String customField;

    public MyExample3145DTO(MyEntity3145 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}