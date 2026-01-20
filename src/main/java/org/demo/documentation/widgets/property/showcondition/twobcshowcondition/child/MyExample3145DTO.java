package org.demo.documentation.widgets.property.showcondition.twobcshowcondition.child;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3145DTO extends DataResponseDTO {

    private String customField;

    @SearchParameter(name = "fgdfgdEntity.customField", provider = StringValueProvider.class)
    private String fgdfgd;

    @SearchParameter(name = "fgdfgdEntity.id", provider = LongValueProvider.class)
    private Long fgdfgdId;

    public MyExample3145DTO(MyEntity3145 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.fgdfgdId = Optional.ofNullable(entity.getFgdfgdEntity())
                .map(e -> e.getId())
                .orElse(null);
        this.fgdfgd = Optional.ofNullable(entity.getFgdfgdEntity())
                .map(e -> e.getCustomField())
                .orElse(null);
    }
}