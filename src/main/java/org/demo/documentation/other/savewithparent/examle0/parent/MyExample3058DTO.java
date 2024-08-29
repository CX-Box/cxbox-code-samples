package org.demo.documentation.other.savewithparent.examle0.parent;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3058DTO extends DataResponseDTO {

    private String customField;
    @SearchParameter(name = "customFieldRequired", provider = StringValueProvider.class)
    private String customFieldRequired;


    public MyExample3058DTO(MyEntity3058 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();

        this.customFieldRequired = entity.getCustomFieldRequired();
    }
}