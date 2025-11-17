package org.demo.repository.metabuilder.buildrowdependentmeta.isfieldchangenow.forproject;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity4903OCPPickPickDTO extends DataResponseDTO {

    private String customField;

    public MyEntity4903OCPPickPickDTO(MyEntity4903OCPPick entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
