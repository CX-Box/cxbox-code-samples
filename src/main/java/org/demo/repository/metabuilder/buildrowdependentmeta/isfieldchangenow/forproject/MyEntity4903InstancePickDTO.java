package org.demo.repository.metabuilder.buildrowdependentmeta.isfieldchangenow.forproject;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity4903InstancePickDTO extends DataResponseDTO {

    private String customField;

    public MyEntity4903InstancePickDTO(MyEntity4903Instance entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
