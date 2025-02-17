package org.demo.documentation.navigation.tab.typestandard.defaultview.typicalexample;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;

import org.demo.documentation.navigation.tab.typestandard.defaultview.typicalexample.enums.StatusEnum;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3238DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;
    @SearchParameter(name = "fullName")
    private String fullName;
    @SearchParameter(name = "address")
    private String address;
    @SearchParameter(name = "status", provider = EnumValueProvider.class)
    private StatusEnum status;

    private String fullNameRO;

    public MyExample3238DTO(MyEntity3238 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.fullName = entity.getFullName();
        this.fullNameRO = entity.getFullName();
        this.address = entity.getAddress();
        this.status = entity.getStatus();
    }
}