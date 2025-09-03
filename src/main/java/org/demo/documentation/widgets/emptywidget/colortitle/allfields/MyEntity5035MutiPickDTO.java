package org.demo.documentation.widgets.emptywidget.colortitle.allfields;

import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity5035MutiPickDTO extends DataResponseDTO {

    @SearchParameter(name = "customField", provider = StringValueProvider.class)
    private String customField;

    public MyEntity5035MutiPickDTO(MyEntity5035Muti entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
