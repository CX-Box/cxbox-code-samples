package org.demo.documentation.other.forceactive;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3204DTO extends DataResponseDTO {

    @SearchParameter(name = "customField", provider = StringValueProvider.class)
    private String customField;
    @SearchParameter(name = "customFieldFA", provider = StringValueProvider.class)
    private String customFieldFA;
    @SearchParameter(name = "customFieldDrillDown", provider = StringValueProvider.class)
    private String customFieldDrillDown;

    public MyExample3204DTO(MyEntity3204 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldFA = entity.getCustomFieldFA();
        this.customFieldDrillDown = entity.getCustomFieldDrillDown();
    }
}