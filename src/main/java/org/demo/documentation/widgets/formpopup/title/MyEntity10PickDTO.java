package org.demo.documentation.widgets.formpopup.title;

import java.lang.Long;

import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
import org.demo.documentation.fields.percent.validationbusinessex.MyEntity10;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity10PickDTO extends DataResponseDTO {

    @SearchParameter(name = "customField", provider = LongValueProvider.class)
    private Long customField;

    public MyEntity10PickDTO(MyEntity10 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
