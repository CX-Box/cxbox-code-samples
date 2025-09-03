package org.demo.documentation.widgets.property.sethidden.graph.inner;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BigDecimalValueProvider;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.demo.documentation.widgets.property.sethidden.graph.inner.enums.ProductNameEnum;

@Getter
@Setter
@NoArgsConstructor
public class MyExample5020DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;

    @SearchParameter(name = "clientName")
    private String clientName;

    @SearchParameter(name = "productName", provider = EnumValueProvider.class)
    private ProductNameEnum productName;

    @SearchParameter(name = "sum", provider = BigDecimalValueProvider.class)
    private Long sum;

    public MyExample5020DTO(MyEntity5020 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.clientName = entity.getClientName();
        this.productName = entity.getProductName();
        this.sum = entity.getSum();
    }
}
