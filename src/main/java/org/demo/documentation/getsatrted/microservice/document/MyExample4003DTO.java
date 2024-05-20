package org.demo.documentation.getsatrted.microservice.document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.demo.documentation.getsatrted.microservice.MyEntity4001OutServiceDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample4003DTO extends DataResponseDTO {

    public MyExample4003DTO(MyEntity4001OutServiceDTO entity) {
        this.id = entity.getId();
    }
}