package org.demo.documentation.widgets.additionalinfo.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3600DTO extends DataResponseDTO {

    @SearchParameter(name = "customField", provider = StringValueProvider.class)
    private String customField;
    @SearchParameter(name = "customField2", provider = StringValueProvider.class)
    private String customField2;
    @SearchParameter(name = "customField3", provider = StringValueProvider.class)
    private String customField3;

    public MyExample3600DTO(MyEntity3600 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customField2 = entity.getCustomField2();
        this.customField3 = entity.getCustomField3();
    }
}