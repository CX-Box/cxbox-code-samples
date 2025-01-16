package org.demo.documentation.widgets.property.filtration.filtergroup.forpicklist;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3630PickDTO extends DataResponseDTO {

    @SearchParameter(name = "customField", provider = StringValueProvider.class)
    private String customField;

    public MyEntity3630PickDTO(MyEntity3630 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
