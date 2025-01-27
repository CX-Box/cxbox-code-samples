package org.demo.documentation.widgets.form.actions.cancelcreate.oncancel;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;


@Getter
@Setter
@NoArgsConstructor
public class MyExample3186DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;
    @SearchParameter(name = "customFieldText")
    private String customFieldText;

    public MyExample3186DTO(MyEntity3186 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldText = entity.getCustomFieldText();
    }
}