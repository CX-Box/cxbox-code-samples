package org.demo.documentation.time.validationbusinessex;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyExample4101DTO extends DataResponseDTO {

    public MyExample4101DTO(MyEntity4101 entity) {
        this.id = entity.getId().toString();
    }
}