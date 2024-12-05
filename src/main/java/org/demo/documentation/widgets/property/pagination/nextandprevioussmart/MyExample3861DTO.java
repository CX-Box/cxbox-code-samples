package org.demo.documentation.widgets.property.pagination.nextandprevioussmart;

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
public class MyExample3861DTO extends DataResponseDTO {

    @SearchParameter(name = "customField", provider = StringValueProvider.class)
    private String customField;
    @SearchParameter(name = "customField", provider = DateTimeValueProvider.class)
    private LocalDateTime customFieldDateTime;
    public MyExample3861DTO(MyEntity3861OutServiceDTO entity) {
        this.id = entity.getId();
        this.customField = entity.getCustomField();
        this.customFieldDateTime = entity.getCustomFieldDateTime();
    }
}