package org.demo.documentation.widgets.statsblock.drilldown.parentchild.data;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;
import org.demo.documentation.widgets.statsblock.drilldown.parentchild.data.enums.ExampleStatus;

@Getter
@Setter
@NoArgsConstructor
public class MyExample4216DTO extends DataResponseDTO {

    @SearchParameter(name = "customField", provider = StringValueProvider.class)
    private String customField;

    @SearchParameter(name = "status", provider = EnumValueProvider.class)
    private ExampleStatus status;

    public MyExample4216DTO(MyEntity4216 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.status = entity.getStatus();
    }
}
