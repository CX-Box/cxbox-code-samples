package org.demo.documentation.fields.time.validationdynamic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.TimeValueProvider;
import org.cxbox.model.core.entity.BaseEntity;

import java.time.LocalDateTime;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class MyExampleBc4106DTO extends DataResponseDTO {


    @SearchParameter(name = "customField", provider = TimeValueProvider.class)
    private LocalDateTime customField;

    @SearchParameter(name = "customFieldAdditional", provider = TimeValueProvider.class)
    private LocalDateTime customFieldAdditional;

    public MyExampleBc4106DTO(MyExampleBc4106 entity) {
        this.id = Optional.of(entity).map(BaseEntity::getId).map(String::valueOf).orElse(null);
        this.customField = entity.getCustomField();
        this.customFieldAdditional = entity.getCustomFieldAdditional();
    }

}
