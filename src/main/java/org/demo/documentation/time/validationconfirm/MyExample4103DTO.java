package org.demo.documentation.time.validationconfirm;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyExample4103DTO extends DataResponseDTO {

    public MyExample4103DTO(MyEntity4103 entity) {
        this.id = entity.getId().toString();
    }
}