package org.demo.documentation.navigation.tab.other.example5.child3;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;


@Getter
@Setter
@NoArgsConstructor
public class MyExample3163DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;

    public MyExample3163DTO(MyEntity3163 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}