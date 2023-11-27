package org.demo.documentation.widgets.form.showcondition.byparententity.parent;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3007DTO extends DataResponseDTO {

    public static final String INFO_TEXT = "Shows each field on new row. Each field can have width from 1 to 27";

    @SearchParameter(name = "customFieldShowCondition", provider = StringValueProvider.class)
    private String customFieldShowCondition;
    @SearchParameter(name = "customField", provider = StringValueProvider.class)
    private Long customField;
    @SearchParameter(name = "customField3", provider = StringValueProvider.class)
    private String customField3;
    private String customField4;


    public MyExample3007DTO(MyEntity3007 entity) {
        this.id = entity.getId().toString();
        this.customFieldShowCondition = entity.getCustomField() > 7 ? "true" : "false";
        this.customField4 = entity.getCustomField4();
        this.customField  = entity.getCustomField();
    }

}