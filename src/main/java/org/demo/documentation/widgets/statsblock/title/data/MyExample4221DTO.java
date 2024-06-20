package org.demo.documentation.widgets.statsblock.title.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.DateValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample4221DTO extends DataResponseDTO {

    private String customField;

    public MyExample4221DTO(MyEntity4221 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}
