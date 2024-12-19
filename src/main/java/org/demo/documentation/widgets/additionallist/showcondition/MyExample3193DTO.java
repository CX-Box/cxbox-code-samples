package org.demo.documentation.widgets.additionallist.showcondition;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3193DTO extends DataResponseDTO {
    public static final String TEXT = "Сondition can include boolean expression depending on current entity fields. Field updates will trigger condition recalculation only on save or if field is force active";

    public static final String TEXT2 = "Show condition - if CustomField  > 5 widget show.";

    private Long customField;

    private String customFieldShowCond;
    @SearchParameter(name = "customFieldText", provider = StringValueProvider.class)
    private String customFieldText;

    public MyExample3193DTO(MyEntity3193 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldShowCond = entity.getCustomField() > 5 ? "true" : "false";
        this.customFieldText = entity.getCustomFieldText();
    }
}