package org.demo.documentation.navigation.tab.typestandard.defaultview.typicalexample.child;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3239DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;
    @SearchParameter(name = "fullName")
    private String fullName;
    @SearchParameter(name = "phoneNumber")
    private String phoneNumber;

    public MyExample3239DTO(MyEntity3239 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.fullName = entity.getFullName();
        this.phoneNumber = entity.getPhoneNumber();
    }
}