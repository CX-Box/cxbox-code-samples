package org.demo.documentation.getstarted.postgres.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample4002DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;

    public MyExample4002DTO(MyEntity4002 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();

    }
}