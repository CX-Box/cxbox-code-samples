package org.demo.documentation.widgets.formpopup.base.onefield;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;


import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3400DTO extends DataResponseDTO {

    public static final String TEXT = "Form Popup widget is a component for confirmation text.";

    @SearchParameter(name = "customField")
    private String customField;
    @SearchParameter(name = "customField2")
    private String customField2;
    @SearchParameter(name = "customFieldInlinePicklistEntity.customField")
    private String customFieldInlinePicklist;
    @SearchParameter(name = "customFieldInlinePicklistEntity.id", provider = LongValueProvider.class)
    private Long customFieldInlinePicklistId;
    @SearchParameter(name = "customFieldRequired")
    private String customFieldRequired;
    @SearchParameter(name = "customFieldRequired2", provider = StringValueProvider.class)
    private String customFieldRequired2;
    @SearchParameter(name = "customFieldFA", provider = StringValueProvider.class)
    private String customFieldFA;
    @SearchParameter(name = "customFieldFA2", provider = StringValueProvider.class)
    private String customFieldFA2;

    public MyExample3400DTO(MyEntity3400 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customField2 = entity.getCustomField2();
        this.customFieldInlinePicklistId = Optional.ofNullable(entity.getCustomFieldInlinePicklistEntity())
                .map(e -> e.getId())
                .orElse(null);
        this.customFieldInlinePicklist = Optional.ofNullable(entity.getCustomFieldInlinePicklistEntity())
                .map(e -> e.getCustomField())
                .orElse(null);
        this.customFieldRequired = entity.getCustomFieldRequired();
        this.customFieldRequired2 = entity.getCustomFieldRequired2();
        this.customFieldFA = entity.getCustomFieldFA();
        this.customFieldFA2 = entity.getCustomFieldFA2();
    }
}