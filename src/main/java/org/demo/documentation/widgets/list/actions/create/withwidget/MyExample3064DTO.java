package org.demo.documentation.widgets.list.actions.create.withwidget;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3064DTO extends DataResponseDTO {

    private String customField;
    @SearchParameter(name = "customFieldText")
    private String customFieldText;

    public MyExample3064DTO(MyEntity3064 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldText = entity.getCustomFieldText();
    }
}