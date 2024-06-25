package org.demo.documentation.feature.fulltextsearch;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3614DTO extends DataResponseDTO {

    @SearchParameter(name = "customField", provider = StringValueProvider.class)
    private String customField;
    @SearchParameter(name = "fullName", provider = StringValueProvider.class)
    private String fullName;
    @SearchParameter(name = "address", provider = StringValueProvider.class)
    private String address;

    public MyExample3614DTO(MyEntity3614 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.fullName = entity.getFullName();
        this.address = entity.getAddress();
    }
}