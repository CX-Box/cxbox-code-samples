package org.demo.documentation.widgets.formpopup.title;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;

import java.util.Optional;


@Getter
@Setter
@NoArgsConstructor
public class MyExample3401DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;
    @SearchParameter(name = "customField2")
    private String customField2;

    @SearchParameter(name = "fghgfEntity.customField", provider = LongValueProvider.class)
    private Long fghgf;

    @SearchParameter(name = "fghgfEntity.id", provider = LongValueProvider.class)
    private Long fghgfId;

    public MyExample3401DTO(MyEntity3401 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customField2 = entity.getCustomField2();
        this.fghgfId = Optional.ofNullable(entity.getFghgfEntity())
                .map(e -> e.getId())
                .orElse(null);
        this.fghgf = Optional.ofNullable(entity.getFghgfEntity())
                .map(e -> e.getCustomField())
                .orElse(null);
    }
}