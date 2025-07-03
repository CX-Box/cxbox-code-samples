package org.demo.documentation.other.forceactive2.forproject;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity4903FileNamePickPickDTO extends DataResponseDTO {

    private String customField;

    public MyEntity4903FileNamePickPickDTO(MyEntity4903FileNamePick entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
