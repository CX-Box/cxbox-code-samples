package org.demo.documentation.widgets.form.actions.edit.basic;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3301DTO extends DataResponseDTO {

    public static final String INFO_TEXT_CREATE_VIEW = "With Create with view, clicking the \"Add\" button opens a separate view that displays only the data entry form. After completing the form and saving, the system returns to the form of entities with the new row added." ;

    public static final String INFO_TEXT = "Edit Basic implies inline-edit. Click twice on the value you want to change." ;

    @SearchParameter(name = "customField")
    private String customField;

    public MyExample3301DTO(MyEntity3301 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}