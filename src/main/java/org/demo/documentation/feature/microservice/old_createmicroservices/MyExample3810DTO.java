package org.demo.documentation.feature.microservice.old_createmicroservices;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.DateTimeValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3810DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;
    @SearchParameter(name = "customField", provider = DateTimeValueProvider.class)
    private LocalDateTime customFieldDateTime;
    public MyExample3810DTO(MyEntity3810OutServiceDTO entity) {
        this.id = entity.getId();
        this.customField = entity.getCustomField();
        this.customFieldDateTime = entity.getCustomFieldDateTime();
    }
}