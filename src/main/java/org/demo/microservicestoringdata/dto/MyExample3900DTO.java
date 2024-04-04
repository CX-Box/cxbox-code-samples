package org.demo.microservicestoringdata.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.demo.microservicestoringdata.repository.entity.MyEntity3900;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3900DTO extends DataResponseDTO {

    private String customField;
    public MyExample3900DTO(MyEntity3900 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}
