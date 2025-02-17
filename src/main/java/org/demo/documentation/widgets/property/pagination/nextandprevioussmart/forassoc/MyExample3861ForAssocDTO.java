package org.demo.documentation.widgets.property.pagination.nextandprevioussmart.forassoc;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.DateTimeValueProvider;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3861ForAssocDTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;
    @SearchParameter(name = "customFieldDateTime", provider = DateTimeValueProvider.class)
    private LocalDateTime customFieldDateTime;
    public MyExample3861ForAssocDTO(MyEntity3861ForAssocOutServiceDTO entity) {
        this.id = entity.getId();
        this.customField = entity.getCustomField();
        this.customFieldDateTime = entity.getCustomFieldDateTime();
    }
}