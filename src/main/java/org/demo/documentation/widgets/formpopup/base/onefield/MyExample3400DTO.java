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

    @SearchParameter(name = "customField", provider = StringValueProvider.class)
    private String customField;
    @SearchParameter(name = "customField2", provider = StringValueProvider.class)
    private String customField2;
    @SearchParameter(name = "customFieldInlinePicklistEntity.customField", provider = StringValueProvider.class)
    private String customFieldInlinePicklist;
    @SearchParameter(name = "customFieldInlinePicklistEntity.id", provider = LongValueProvider.class)
    private Long customFieldInlinePicklistId;

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
    }
}