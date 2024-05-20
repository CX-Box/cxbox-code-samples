package org.demo.documentation.getsatrted.microservice.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.demo.documentation.getsatrted.microservice.MyEntity4001OutServiceDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample4001DTO extends DataResponseDTO {

    public MyExample4001DTO(MyEntity4001OutServiceDTO entity) {
        this.id = entity.getId().toString();
    }
}