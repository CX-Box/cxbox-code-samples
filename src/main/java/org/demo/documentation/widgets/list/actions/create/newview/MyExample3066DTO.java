package org.demo.documentation.widgets.list.actions.create.newview;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.DateValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3066DTO extends DataResponseDTO {
    public static final String INFO_TEXT = "List widget is list the general information for many records and present it in a way that is easily interpretable for users.";

    private String customField;
    @SearchParameter(name = "customFieldText")
    private String customFieldText;

    public MyExample3066DTO(MyEntity3066 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldText = entity.getCustomFieldText();
    }
}