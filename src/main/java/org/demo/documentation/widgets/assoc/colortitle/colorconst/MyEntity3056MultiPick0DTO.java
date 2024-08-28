package org.demo.documentation.widgets.assoc.colortitle.colorconst;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;
import org.demo.documentation.widgets.assoc.colortitle.MyEntity3056Multi;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3056MultiPick0DTO extends DataResponseDTO {
    @SearchParameter(name = "customField", provider = StringValueProvider.class)
    private String customField;
    @SearchParameter(name = "customFieldText", provider = StringValueProvider.class)
    private String customFieldText;

    public MyEntity3056MultiPick0DTO(MyEntity3056Multi entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldText = entity.getCustomFieldText();

    }

}
