package org.demo.navigation.tab.other.example2;

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
public class MyExample3422DTO extends DataResponseDTO {

    private String customField;
    @SearchParameter(name = "customFieldDrilldown", provider = StringValueProvider.class)
    private String customFieldDrilldown;

    public MyExample3422DTO(MyEntity3422 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldDrilldown = entity.getCustomFieldDrilldown();
    }
}