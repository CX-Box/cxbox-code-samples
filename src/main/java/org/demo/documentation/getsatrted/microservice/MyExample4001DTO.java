package org.demo.documentation.getsatrted.microservice;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyExample4001DTO extends DataResponseDTO {

    public MyExample4001DTO(MyEntity4001 entity) {
        this.id = entity.getId().toString();
    }
}