package org.demo.documentation.widgets.assoc.actions.other.createwithparent.assoc;

import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.core.util.filter.SearchParameter;


@Getter
@Setter
@NoArgsConstructor
public class MyEntity3662MultivalueDTO extends DataResponseDTO {

    private String customField;
    @SearchParameter(name = "customFieldText")
    private String customFieldText;

    public MyEntity3662MultivalueDTO(MyEntity3662 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldText = entity.getCustomFieldText();
    }

}
