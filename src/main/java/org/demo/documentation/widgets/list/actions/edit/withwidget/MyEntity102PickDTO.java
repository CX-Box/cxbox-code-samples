package org.demo.documentation.widgets.list.actions.edit.withwidget;

import java.lang.String;

import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;
import org.demo.documentation.fields.fileupload.sorting.MyEntity102;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity102PickDTO extends DataResponseDTO {

    @SearchParameter(name = "customField", provider = StringValueProvider.class)
    private String customField;

    public MyEntity102PickDTO(MyEntity102 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
