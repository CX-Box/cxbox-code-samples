package org.demo.documentation.getsatrted.postgres.document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample4000DTO extends DataResponseDTO {

    public MyExample4000DTO(MyEntity4000 entity) {
        this.id = entity.getId().toString();
    }
}