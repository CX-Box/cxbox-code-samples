package org.demo.documentation.widgets.formpopup.title;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;


@Getter
@Setter
@NoArgsConstructor
public class MyExample3401DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;
    @SearchParameter(name = "customField2")
    private String customField2;

    public MyExample3401DTO(MyEntity3401 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customField2 = entity.getCustomField2();
    }
}