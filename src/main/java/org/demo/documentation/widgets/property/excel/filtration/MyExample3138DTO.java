package org.demo.documentation.widgets.property.excel.filtration;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BigDecimalValueProvider;
import org.cxbox.core.util.filter.provider.impl.DateTimeValueProvider;


import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3138DTO extends DataResponseDTO {


    @SearchParameter(name = "customFieldDateTime", provider = DateTimeValueProvider.class)
    private LocalDateTime customFieldDateTime;
    @SearchParameter(name = "customFieldNumber", provider = BigDecimalValueProvider.class)
    private Long customFieldNumber;
    @SearchParameter(name = "customFieldInput")
    private String customFieldInput;
    @SearchParameter(name = "customFieldText")
    private String customFieldText;

    public MyExample3138DTO(MyEntity3138 entity) {
        this.id = entity.getId().toString();
        this.customFieldDateTime = entity.getCustomFieldDateTime();
        this.customFieldNumber = entity.getCustomFieldNumber();
        this.customFieldInput = entity.getCustomFieldInput();
        this.customFieldText = entity.getCustomFieldText();
    }
}