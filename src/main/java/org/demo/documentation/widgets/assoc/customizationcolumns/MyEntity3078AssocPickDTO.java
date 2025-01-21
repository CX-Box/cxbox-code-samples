package org.demo.documentation.widgets.assoc.customizationcolumns;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BigDecimalValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3078AssocPickDTO extends DataResponseDTO {

    private String customField;
    @SearchParameter(name = "customFieldText", provider = StringValueProvider.class)
    private String customFieldText;
    @SearchParameter(name = "customFieldNumber", provider = BigDecimalValueProvider.class)
    private Long customFieldNumber;

    public MyEntity3078AssocPickDTO(MyEntity3078Assoc entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldText = entity.getCustomFieldText();
        this.customFieldNumber = entity.getCustomFieldNumber();
    }

}
