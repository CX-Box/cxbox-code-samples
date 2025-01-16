package org.demo.documentation.widgets.property.filtration.fulltextsearch.forpicklist;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3614PickPickDTO extends DataResponseDTO {

    @SearchParameter(name = "customField", provider = StringValueProvider.class)
    private String customField;

    public MyEntity3614PickPickDTO(MyEntity3614Pick entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
