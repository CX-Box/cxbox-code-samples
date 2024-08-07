package org.demo.documentation.feature.excel.inner.forfields;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3134MultiMultivalueDTO extends DataResponseDTO {

    private String customField;

    public MyEntity3134MultiMultivalueDTO(MyEntity3134Multi entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
