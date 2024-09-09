package org.demo.documentation.navigation.tab.other.example5;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3160DTO extends DataResponseDTO {

    @SearchParameter(name = "customField", provider = StringValueProvider.class)
    private String customField;

    public MyExample3160DTO(MyEntity3160 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}