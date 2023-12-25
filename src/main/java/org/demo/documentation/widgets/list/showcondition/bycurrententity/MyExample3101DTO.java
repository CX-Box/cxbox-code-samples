package org.demo.documentation.widgets.list.showcondition.bycurrententity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3101DTO extends DataResponseDTO {
    public static final String TEXT = "Сondition can include boolean expression depending on current entity fields. Field updates will trigger condition recalculation only on save or if field is force active";

    public static final String TEXT2 = "Show condition - if CustomField  > 5 widget show.";
    @SearchParameter(name = "customField", provider = StringValueProvider.class)
    private Long customField;
    private String customFieldShowCond;
    public MyExample3101DTO(MyEntity3101 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldShowCond = entity.getCustomField() > 5 ? "true" : "false";
    }
}