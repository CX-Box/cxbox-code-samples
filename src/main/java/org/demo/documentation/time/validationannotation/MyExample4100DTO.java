package org.demo.documentation.time.validationannotation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyExample4100DTO extends DataResponseDTO {

    public MyExample4100DTO(MyEntity4100 entity) {
        this.id = entity.getId().toString();
    }
}