package org.demo.documentation.widgets.assoc.base.forfield;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3053MultiMultivalueDTO extends DataResponseDTO {

    private String customField;
    @SearchParameter(name = "customFieldNew", provider = StringValueProvider.class)
    private String customFieldNew;

    public MyEntity3053MultiMultivalueDTO(MyEntity3053Multi entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldNew = entity.getCustomFieldNew();
    }

}
