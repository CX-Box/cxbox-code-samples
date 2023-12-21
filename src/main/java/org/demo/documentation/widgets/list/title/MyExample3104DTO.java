package org.demo.documentation.widgets.list.title;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3104DTO extends DataResponseDTO {

    public static final String INFO_TEXT_EMPTY_TITLE = "Title empty. If you want to visually connect widgets by them to be placed one under another";
    public static final String INFO_TEXT_CUSTOM_TITLE = "Title calculate. Shows value provided in hidden text field, e.g. it can be calculated based on business logic of application";
    public static final String INFO_TEXT_CONST_TITLE = "Title constant. Shows constant text";

    @SearchParameter(name = "customField", provider = StringValueProvider.class)
    private String customField;

    public MyExample3104DTO(MyEntity3104 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}