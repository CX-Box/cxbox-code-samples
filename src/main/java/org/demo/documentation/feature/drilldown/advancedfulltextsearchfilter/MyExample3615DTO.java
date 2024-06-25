package org.demo.documentation.feature.drilldown.advancedfulltextsearchfilter;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.DateValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3615DTO extends DataResponseDTO {

    private String customField;
    @SearchParameter(name = "customField2", provider = StringValueProvider.class)
    private String customField2;
    @SearchParameter(name = "fullName", provider = StringValueProvider.class)
    private String fullName;
    @SearchParameter(name = "address", provider = StringValueProvider.class)
    private String address;

    public MyExample3615DTO(MyEntity3615 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customField2 = entity.getCustomField2();
        this.fullName = entity.getFullName();
        this.address = entity.getAddress();
    }
}