package org.demo.documentation.widgets.list.showcondition;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3101DTO extends DataResponseDTO {

    public MyExample3101DTO(MyEntity3101 entity) {
        this.id = entity.getId().toString();
    }
}