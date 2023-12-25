package org.demo.documentation.widgets.list.showcondition.byparententity.child;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3106DTO extends DataResponseDTO {

    public MyExample3106DTO(MyEntity3106 entity) {
        this.id = entity.getId().toString();
    }
}