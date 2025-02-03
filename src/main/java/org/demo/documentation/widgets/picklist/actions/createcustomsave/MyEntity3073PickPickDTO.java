package org.demo.documentation.widgets.picklist.actions.createcustomsave;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3073PickPickDTO extends DataResponseDTO {

    private String customField;
    @SearchParameter(name = "customFieldReq", provider = StringValueProvider.class)
    private String customFieldReq;

    public MyEntity3073PickPickDTO(MyEntity3073Pick entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldReq = entity.getCustomFieldReq();
    }

}
