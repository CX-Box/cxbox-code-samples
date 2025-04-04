package org.demo.documentation.feature.microservice.existingmicroservices;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;


@Getter
@Setter
@NoArgsConstructor
public class MyExample3800DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;

    public MyExample3800DTO(MyEntity3800OutServiceDTO entity) {
        this.id = entity.getId();
        this.customField = entity.getCustomField();
    }
}