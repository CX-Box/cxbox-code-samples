package org.demo.documentation.widgets.form.actions.delete;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;


@Getter
@Setter
@NoArgsConstructor
public class MyExample3180DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;

    public MyExample3180DTO(MyEntity3180 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}