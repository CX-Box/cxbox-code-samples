package org.demo.documentation.fields.suggest;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.DateValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3810DTO extends DataResponseDTO {

    public MyExample3810DTO(MyEntity3810OutServiceDTO entity) {
        this.id = entity.getId().toString();
    }
}