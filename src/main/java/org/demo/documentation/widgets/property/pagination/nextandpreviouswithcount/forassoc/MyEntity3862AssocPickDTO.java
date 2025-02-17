package org.demo.documentation.widgets.property.pagination.nextandpreviouswithcount.forassoc;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3862AssocPickDTO extends DataResponseDTO {

    private String customField;

    public MyEntity3862AssocPickDTO(org.demo.documentation.widgets.property.pagination.nextandpreviouswithcount.forassoc.MyEntity3862Assoc entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
