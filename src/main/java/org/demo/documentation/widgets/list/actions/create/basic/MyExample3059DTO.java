package org.demo.documentation.widgets.list.actions.create.basic;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;


@Getter
@Setter
@NoArgsConstructor
public class MyExample3059DTO extends DataResponseDTO {

    private String customField;
    @SearchParameter(name = "customFieldText")
    private String customFieldText;

    public MyExample3059DTO(MyEntity3059 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldText = entity.getCustomFieldText();
    }
}