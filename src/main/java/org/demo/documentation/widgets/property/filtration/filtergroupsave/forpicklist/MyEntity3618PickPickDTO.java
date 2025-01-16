package org.demo.documentation.widgets.property.filtration.filtergroupsave.forpicklist;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3618PickPickDTO extends DataResponseDTO {
    @SearchParameter(name = "customField", provider = StringValueProvider.class)
    private String customField;

    public MyEntity3618PickPickDTO(MyEntity3618Pick entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
