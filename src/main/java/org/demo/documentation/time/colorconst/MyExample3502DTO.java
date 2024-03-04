package org.demo.documentation.time.colorconst;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.DateValueProvider;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3502DTO extends DataResponseDTO {

    @SearchParameter(name = "customField", provider = DateValueProvider.class)
    private LocalDateTime customField;

    public MyExample3502DTO(MyEntity3502 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}