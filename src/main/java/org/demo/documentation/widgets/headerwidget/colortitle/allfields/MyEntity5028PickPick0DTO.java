package org.demo.documentation.widgets.headerwidget.colortitle.allfields;

import java.lang.String;

import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity5028PickPick0DTO extends DataResponseDTO {

    @SearchParameter(name = "customField", provider = StringValueProvider.class)
    private String customField;

    public MyEntity5028PickPick0DTO(MyEntity5028Pick entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
