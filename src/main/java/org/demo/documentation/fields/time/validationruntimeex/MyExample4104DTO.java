package org.demo.documentation.fields.time.validationruntimeex;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample4104DTO extends DataResponseDTO {

    public MyExample4104DTO(MyEntity4104 entity) {
        this.id = entity.getId().toString();
    }
}