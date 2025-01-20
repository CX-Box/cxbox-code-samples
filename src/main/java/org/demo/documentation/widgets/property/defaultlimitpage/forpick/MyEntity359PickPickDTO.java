package org.demo.documentation.widgets.property.defaultlimitpage.forpick;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.demo.documentation.widgets.property.defaultlimitpage.forassoc.MyEntity359Pick;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity359PickPickDTO extends DataResponseDTO {

    private String customField;

    public MyEntity359PickPickDTO(MyEntity359Pick entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
