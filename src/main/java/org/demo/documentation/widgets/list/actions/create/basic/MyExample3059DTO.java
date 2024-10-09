package org.demo.documentation.widgets.list.actions.create.basic;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3059DTO extends DataResponseDTO {

    private String customField;
    @SearchParameter(name = "customFieldText", provider = StringValueProvider.class)
    private String customFieldText;
    @SearchParameter(name = "customFieldDisable", provider = StringValueProvider.class)
    private String customFieldDisable;
    @SearchParameter(name = "customFieldDisableDynamic", provider = StringValueProvider.class)
    private String customFieldDisableDynamic;

    public MyExample3059DTO(MyEntity3059 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldText = entity.getCustomFieldText();
        this.customFieldDisable = entity.getCustomFieldDisable();
        this.customFieldDisableDynamic = entity.getCustomFieldDisableDynamic();
    }
}