package org.demo.documentation.other.twobcshowcondition.parent;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.DateValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;
import org.demo.documentation.widgets.form.showcondition.byparententity.parent.MyEntity3007;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3146DTO extends DataResponseDTO {

    public static final String INFO_TEXT = "Сondition can include boolean expression depending on current entity fields. Field updates will trigger condition recalculation only on save or if field is force active";

    private Boolean customFieldShowCondition;
    @SearchParameter(name = "customField", provider = StringValueProvider.class)
    private Long customField;

    public MyExample3146DTO(MyEntity3146 entity) {
        this.id = entity.getId().toString();
        this.customFieldShowCondition = entity.getCustomField() > 5 ;
        this.customField = entity.getCustomField();
    }
}