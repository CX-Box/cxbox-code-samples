package org.demo.documentation.widgets.assoc.actions.customsave;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3063MultiMultivalueDTO extends DataResponseDTO {

    private String customField;
    @SearchParameter(name = "customFieldReq", provider = StringValueProvider.class)
    private String customFieldReq;

    public MyEntity3063MultiMultivalueDTO(MyEntity3063Multi entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldReq = entity.getCustomFieldReq();
    }

}
