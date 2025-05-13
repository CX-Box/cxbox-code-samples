package org.demo.documentation.fields.time.color;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.TimeValueProvider;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3501DTO extends DataResponseDTO {

    @SearchParameter(name = "customField", provider = TimeValueProvider.class)
    private LocalDateTime customField;

    private String customFieldColor;
    public MyExample3501DTO(MyEntity3501 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldColor = "#eda6a6";
    }
}