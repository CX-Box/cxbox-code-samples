package org.demo.documentation.fields.suggestion.sorting.forfield;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3122DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;

    public MyExample3122DTO(MyEntity3122 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}