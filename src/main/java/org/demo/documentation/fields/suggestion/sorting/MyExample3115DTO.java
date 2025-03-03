package org.demo.documentation.fields.suggestion.sorting;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3115DTO extends DataResponseDTO {

    public MyExample3115DTO(MyEntity3115OutServiceDTO entity) {
        this.id = entity.getId().toString();
    }
}