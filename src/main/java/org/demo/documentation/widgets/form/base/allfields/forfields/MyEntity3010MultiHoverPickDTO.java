package org.demo.documentation.widgets.form.base.allfields.forfields;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3010MultiHoverPickDTO extends DataResponseDTO {

    private String customField;

    public MyEntity3010MultiHoverPickDTO(MyEntity3010MultiHover entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
