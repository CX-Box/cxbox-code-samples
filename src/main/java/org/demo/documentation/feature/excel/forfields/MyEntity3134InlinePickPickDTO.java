package org.demo.documentation.feature.excel.forfields;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3134InlinePickPickDTO extends DataResponseDTO {

    private String customField;

    public MyEntity3134InlinePickPickDTO(MyEntity3134InlinePick entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
