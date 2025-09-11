package org.demo.documentation.navigation.tab.typestandard;

import java.lang.String;

import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;
import org.demo.documentation.fields.fileupload.validationbusinessex.MyEntity103;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity103PickDTO extends DataResponseDTO {

    @SearchParameter(name = "customField", provider = StringValueProvider.class)
    private String customField;

    public MyEntity103PickDTO(MyEntity103 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }

}
