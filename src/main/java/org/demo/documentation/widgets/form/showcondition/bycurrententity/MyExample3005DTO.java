package org.demo.documentation.widgets.form.showcondition.bycurrententity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;


@Getter
@Setter
@NoArgsConstructor
public class MyExample3005DTO extends DataResponseDTO {

    public static final String TEXT = "Сondition can include boolean expression depending on current entity fields. Field updates will trigger condition recalculation only on save or if field is force active";
    public static final String TEXT2 = "Show condition - if CustomField  > 5 widget show.";
    @SearchParameter(name = "customField", provider = StringValueProvider.class)
    private Long customField;

    private Boolean customFieldShowCondition;
    @SearchParameter(name = "customField2", provider = StringValueProvider.class)
    private String customField2;


    public MyExample3005DTO(MyEntity3005 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldShowCondition = entity.getCustomField() > 5 ? true : false;
        this.customField2 = entity.getCustomField2();
    }

}