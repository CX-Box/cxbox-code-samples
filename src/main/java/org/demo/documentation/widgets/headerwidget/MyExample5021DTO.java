package org.demo.documentation.widgets.headerwidget;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample5021DTO extends DataResponseDTO {

    @SearchParameter(name = "customField", provider = StringValueProvider.class)
    private String customField;

    public MyExample5021DTO(MyEntity5021 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}
