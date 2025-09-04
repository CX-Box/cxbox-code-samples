package org.demo.documentation.widgets.emptywidget.showcondition.bycurrententity;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample5033DTO extends DataResponseDTO {

    public static final String TEXT = "Сondition can include boolean expression depending on current entity fields. Field updates will trigger condition recalculation only on save or if field is force active";
    public static final String TEXT2 = "Show condition - if CustomField  > 5 widget show.";
    @SearchParameter(name = "customField")
    private Long customField;

    private Boolean customFieldShowCondition;
    public MyExample5033DTO(MyEntity5033 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldShowCondition = entity.getCustomField() > 5;
    }
}
