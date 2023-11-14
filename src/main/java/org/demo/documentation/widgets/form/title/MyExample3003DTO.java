package org.demo.documentation.widgets.form.title;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;


@Getter
@Setter
@NoArgsConstructor
public class MyExample3003DTO extends DataResponseDTO {

    @SearchParameter(name = "customTitleField")
    private String customTitleField;
    @SearchParameter(name = "customField")
    private Long customField;

    public MyExample3003DTO(MyEntity3003 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customTitleField = entity.getCustomField() > 5 ? "CustomField>5" : "CustomField<5";
    }

}