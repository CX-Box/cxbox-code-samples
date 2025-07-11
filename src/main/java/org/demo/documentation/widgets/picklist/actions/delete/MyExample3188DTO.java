package org.demo.documentation.widgets.picklist.actions.delete;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3188DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;
    @SearchParameter(name = "customFieldDeleteEntity.customField")
    private String customFieldDelete;
    @SearchParameter(name = "customFieldDeleteEntity.id", provider = LongValueProvider.class)
    private Long customFieldDeleteId;

    public MyExample3188DTO(MyEntity3188 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldDeleteId = Optional.ofNullable(entity.getCustomFieldDeleteEntity())
                .map(e -> e.getId())
                .orElse(null);
        this.customFieldDelete = Optional.ofNullable(entity.getCustomFieldDeleteEntity())
                .map(e -> e.getCustomField())
                .orElse(null);
    }
}