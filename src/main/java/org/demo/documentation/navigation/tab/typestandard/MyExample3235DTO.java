package org.demo.documentation.navigation.tab.typestandard;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

import java.util.Optional;


@Getter
@Setter
@NoArgsConstructor
public class MyExample3235DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;

    @SearchParameter(name = "dsdfsEntity.customField", provider = StringValueProvider.class)
    private String dsdfs;

    @SearchParameter(name = "dsdfsEntity.id", provider = LongValueProvider.class)
    private Long dsdfsId;

    public MyExample3235DTO(MyEntity3235 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.dsdfsId = Optional.ofNullable(entity.getDsdfsEntity())
                .map(e -> e.getId())
                .orElse(null);
        this.dsdfs = Optional.ofNullable(entity.getDsdfsEntity())
                .map(e -> e.getCustomField())
                .orElse(null);
    }
}