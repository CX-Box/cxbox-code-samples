package org.demo.documentation.widgets.info.colortitle;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.DateValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3040DTO extends DataResponseDTO {

    private String customField;

    public MyExample3040DTO(MyEntity3040 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}