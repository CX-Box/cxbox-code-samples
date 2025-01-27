package org.demo.documentation.widgets.form.actions.create.withview;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;


@Getter
@Setter
@NoArgsConstructor
public class MyExample3302DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;
    @SearchParameter(name = "customFieldText")
    private String customFieldText;

    private String iNFO_TEXT;

    public MyExample3302DTO(MyEntity3302 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldText = entity.getCustomFieldText();
    }
}