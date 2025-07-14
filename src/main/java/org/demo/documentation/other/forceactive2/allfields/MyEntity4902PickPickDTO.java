package org.demo.documentation.other.forceactive2.allfields;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity4902PickPickDTO extends DataResponseDTO {

    private String customField;

    public MyEntity4902PickPickDTO(MyEntity4902Pick entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
