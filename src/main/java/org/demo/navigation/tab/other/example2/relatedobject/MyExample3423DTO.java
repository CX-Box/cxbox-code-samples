package org.demo.navigation.tab.other.example2.relatedobject;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.DateValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3423DTO extends DataResponseDTO {

    private String customField;

    public MyExample3423DTO(MyEntity3423 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}