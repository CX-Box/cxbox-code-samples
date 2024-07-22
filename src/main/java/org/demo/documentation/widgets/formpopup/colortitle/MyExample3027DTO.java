package org.demo.documentation.widgets.formpopup.colortitle;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.DateValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3027DTO extends DataResponseDTO {

    private String customField;

    public MyExample3027DTO(MyEntity3027 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}