package org.demo.documentation.other.savewithparent.example3;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3422DTO extends DataResponseDTO {

    private String customField;
    @SearchParameter(name = "customFieldDrilldown")
    private String customFieldDrilldown;

    public MyExample3422DTO(MyEntity3422 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldDrilldown = entity.getCustomFieldDrilldown();
    }
}