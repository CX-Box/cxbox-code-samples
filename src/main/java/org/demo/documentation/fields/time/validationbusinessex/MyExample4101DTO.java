package org.demo.documentation.fields.time.validationbusinessex;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample4101DTO extends DataResponseDTO {

    public MyExample4101DTO(MyEntity4101 entity) {
        this.id = entity.getId().toString();
    }
}