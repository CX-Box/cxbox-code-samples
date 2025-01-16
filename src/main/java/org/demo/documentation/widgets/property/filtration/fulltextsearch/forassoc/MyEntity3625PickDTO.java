package org.demo.documentation.widgets.property.filtration.fulltextsearch.forassoc;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3625PickDTO extends DataResponseDTO {
    @SearchParameter(name = "customField", provider = StringValueProvider.class)
    private String customField;

    public MyEntity3625PickDTO(org.demo.documentation.widgets.property.filtration.fulltextsearch.forassoc.MyEntity3625 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
