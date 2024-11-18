package org.demo.documentation.widgets.groupinghierarhy.showcondition.byparententity.child;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3170DTO extends DataResponseDTO {

    @SearchParameter(name = "customField", provider = StringValueProvider.class)
    private String customField;

    public MyExample3170DTO(MyEntity3170 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}