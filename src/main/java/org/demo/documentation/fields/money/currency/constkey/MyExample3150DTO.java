package org.demo.documentation.fields.money.currency.constkey;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BigDecimalValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3150DTO extends DataResponseDTO {


    @SearchParameter(name = "customField", provider = BigDecimalValueProvider.class)
    private Double customField;

    public MyExample3150DTO(MyEntity3150 entity) {
        this.id = entity.getId().toString();

        this.customField = entity.getCustomField();
    }
}