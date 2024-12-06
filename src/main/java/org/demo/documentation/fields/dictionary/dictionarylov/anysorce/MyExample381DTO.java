package org.demo.documentation.fields.dictionary.dictionarylov.anysorce;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample381DTO extends DataResponseDTO {

    private DictionaryType customField;

    public MyExample381DTO(MyEntity381 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
    }
}