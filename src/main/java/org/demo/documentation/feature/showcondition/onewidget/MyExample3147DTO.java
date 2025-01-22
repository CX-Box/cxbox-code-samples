package org.demo.documentation.feature.showcondition.onewidget;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BigDecimalValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3147DTO extends DataResponseDTO {

    public static final String INFO_TEXT = "Сondition can include boolean expression depending on current entity fields. Field updates will trigger condition recalculation only on save or if field is force active";

    private Boolean customFieldShowCondition;

    @SearchParameter(name = "customField")
    private String customField;
    @SearchParameter(name = "customFieldNumber", provider = BigDecimalValueProvider.class)
    private Long customFieldNumber;

    public MyExample3147DTO(MyEntity3147 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldShowCondition = entity.getCustomFieldNumber() > 5;
        this.customFieldNumber = entity.getCustomFieldNumber();
    }
}