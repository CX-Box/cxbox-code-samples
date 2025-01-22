package org.demo.documentation.widgets.property.pagination.nextandpreviouswihhasnext;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.DateTimeValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3860DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;
    @SearchParameter(name = "customField", provider = DateTimeValueProvider.class)
    private LocalDateTime customFieldDateTime;
    public MyExample3860DTO(MyEntity3860OutServiceDTO entity) {
        this.id = entity.getId();
        this.customField = entity.getCustomField();
        this.customFieldDateTime = entity.getCustomFieldDateTime();
    }
}