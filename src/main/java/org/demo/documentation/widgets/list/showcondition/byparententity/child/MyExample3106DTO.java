package org.demo.documentation.widgets.list.showcondition.byparententity.child;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BigDecimalValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3106DTO extends DataResponseDTO {

    public static final String TEXT = "Condition can include boolean expression depending on parent entity. Parent field updates will trigger condition recalculation only on save or if field is force active shown on same view";

    private Boolean customFieldShowCondition;
    @SearchParameter(name = "customField")
    private String customField;
    @SearchParameter(name = "customFieldNumber", provider = BigDecimalValueProvider.class)
    private Long customFieldNumber;

    public MyExample3106DTO(MyEntity3106 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldNumber = entity.getCustomFieldNumber();
        this.customFieldShowCondition = entity.getCustomFieldNumber() > 5;
    }
}