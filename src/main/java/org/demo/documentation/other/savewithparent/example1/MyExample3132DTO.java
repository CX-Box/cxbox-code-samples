package org.demo.documentation.other.savewithparent.example1;

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
public class MyExample3132DTO extends DataResponseDTO {

    private String customField;
    @SearchParameter(name = "customField2")
    private String customField2;
    @SearchParameter(name = "customField3")
    private String customField3;
    @SearchParameter(name = "customFieldInfo")
    private String customFieldInfo;

    public MyExample3132DTO(MyEntity3132 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customField2 = entity.getCustomField2();
        this.customField3 = entity.getCustomField3();
        this.customFieldInfo = entity.getCustomFieldInfo();
    }
}