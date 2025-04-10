package org.demo.documentation.fields.time.validationannotation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample4102DTO extends DataResponseDTO {

    public MyExample4102DTO(MyEntity4102 entity) {
        this.id = entity.getId().toString();
    }
}