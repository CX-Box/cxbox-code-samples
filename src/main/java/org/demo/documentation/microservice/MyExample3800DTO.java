package org.demo.documentation.microservice;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3800DTO extends DataResponseDTO {

    @SearchParameter(name = "customField", provider = StringValueProvider.class)
    private String customField;

    @SearchParameter(name = "customField2", provider = StringValueProvider.class)
    private String customField2;

    public MyExample3800DTO(MyEntity3800OutServiceDTO entity) {
        this.id = entity.getId();
        this.customField = entity.getCustomField();
        this.customField2 = entity.getCustomField2();
    }
}