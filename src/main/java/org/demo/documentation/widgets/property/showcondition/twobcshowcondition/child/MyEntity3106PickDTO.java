package org.demo.documentation.widgets.property.showcondition.twobcshowcondition.child;

import java.lang.String;

import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;
import org.demo.documentation.widgets.list.showcondition.byparententity.child.MyEntity3106;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3106PickDTO extends DataResponseDTO {

    @SearchParameter(name = "customField", provider = StringValueProvider.class)
    private String customField;

    public MyEntity3106PickDTO(MyEntity3106 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
