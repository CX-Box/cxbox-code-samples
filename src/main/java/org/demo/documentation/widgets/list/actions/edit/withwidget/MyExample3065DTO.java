package org.demo.documentation.widgets.list.actions.edit.withwidget;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.DateValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3065DTO extends DataResponseDTO {

    private String customField;

    public MyExample3065DTO(MyEntity3065 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}