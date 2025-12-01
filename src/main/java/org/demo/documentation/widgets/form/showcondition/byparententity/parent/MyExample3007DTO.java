package org.demo.documentation.widgets.form.showcondition.byparententity.parent;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BooleanValueProvider;


@Getter
@Setter
@NoArgsConstructor
public class MyExample3007DTO extends DataResponseDTO {

    public static final String INFO_TEXT = "Сondition can include boolean expression depending on current entity fields. Field updates will trigger condition recalculation only on save or if field is force active";

    public static final String INFO_TEXT2 = "Show condition child widget  - if CustomField  > 5 widget show.";

    private Boolean customFieldShowCondition;
    @SearchParameter(name = "customField")
    private Long customField;

    @SearchParameter(name = "customFieldCh", provider = BooleanValueProvider.class)
    private Boolean customFieldCh;

    public MyExample3007DTO(MyEntity3007 entity) {
        this.id = entity.getId().toString();
        this.customFieldShowCondition = entity.getCustomField() > 5;
        this.customField = entity.getCustomField();
        this.customFieldCh = entity.getCustomFieldCh();
    }

}