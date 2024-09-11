package org.demo.documentation.navigation.tab.typestandard.businessexample.relatedobject;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3427DTO extends DataResponseDTO {

    private String customField;

    public MyExample3427DTO(MyEntity3427 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}