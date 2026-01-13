package org.demo.documentation.other.forceactive.example2;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BooleanValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3205DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;
    @SearchParameter(name = "customFieldCheckBox", provider = BooleanValueProvider.class)
    private Boolean customFieldCheckBox;

    @SearchParameter(name = "customFieldNew", provider = StringValueProvider.class)
    private String customFieldNew;

    @SearchParameter(name = "customFieldDepend", provider = StringValueProvider.class)
    private String customFieldDepend;

    public MyExample3205DTO(MyEntity3205 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldCheckBox = entity.getCustomFieldCheckBox();
        this.customFieldNew = entity.getCustomFieldNew();
        this.customFieldDepend = entity.getCustomFieldDepend();
    }
}