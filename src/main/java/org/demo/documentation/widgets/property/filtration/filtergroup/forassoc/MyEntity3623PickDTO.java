package org.demo.documentation.widgets.property.filtration.filtergroup.forassoc;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.core.util.filter.SearchParameter;


@Getter
@Setter
@NoArgsConstructor
public class MyEntity3623PickDTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;

    public MyEntity3623PickDTO(org.demo.documentation.widgets.property.filtration.filtergroup.forassoc.MyEntity3623 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
