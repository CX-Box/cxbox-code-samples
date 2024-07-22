package org.demo.documentation.widgets.formpopup.colortitle.forfields;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3044PickDTO extends DataResponseDTO {

    private String customField;

    public MyEntity3044PickDTO(MyEntity3044 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
