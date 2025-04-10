package org.demo.documentation.other.anysource;

import jakarta.validation.constraints.DecimalMin;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BigDecimalValueProvider;

import java.time.LocalDateTime;

import static org.demo.documentation.fields.main.TextError.LESS_100000;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3420DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;

    @SearchParameter(name = "customFieldNew")
    private String customFieldNew;

    @SearchParameter(name = "customFieldDouble", provider = BigDecimalValueProvider.class)
    @DecimalMin(value = "100000.00", message = LESS_100000)
    private Double customFieldDouble;

    private LocalDateTime customFieldDateTime;

    public MyExample3420DTO(MyEntity3420OutServiceDTO entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldNew = entity.getCustomFieldNew();
        this.customFieldDateTime = entity.getCustomFieldDateTime();
        this.customFieldDouble = entity.getCustomFieldDouble();
    }
}