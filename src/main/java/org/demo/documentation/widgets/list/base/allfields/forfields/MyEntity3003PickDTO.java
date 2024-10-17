package org.demo.documentation.widgets.list.base.allfields.forfields;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.demo.documentation.widgets.form.title.MyEntity3003;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3003PickDTO extends DataResponseDTO {

    private String customField;

    public MyEntity3003PickDTO(MyEntity3003 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
