package org.demo.documentation.getstarted.microservice.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;
import org.demo.documentation.getstarted.microservice.MyEntity4001OutServiceDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample4001DTO extends DataResponseDTO {

    @SearchParameter(name = "customField", provider = StringValueProvider.class)
    private String customField;

    public MyExample4001DTO(MyEntity4001OutServiceDTO entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}