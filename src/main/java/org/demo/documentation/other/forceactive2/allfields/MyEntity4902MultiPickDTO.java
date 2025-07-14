package org.demo.documentation.other.forceactive2.allfields;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity4902MultiPickDTO extends DataResponseDTO {

    private String customField;

    public MyEntity4902MultiPickDTO(MyEntity4902Multi entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
