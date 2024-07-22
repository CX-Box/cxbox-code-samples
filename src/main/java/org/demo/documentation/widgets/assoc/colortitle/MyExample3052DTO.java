package org.demo.documentation.widgets.assoc.colortitle;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;

import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3052DTO extends DataResponseDTO {

    private String customField;
    @SearchParameter(name = "customFieldMultiList.id", provider = LongValueProvider.class)
    private MultivalueField customFieldMulti;
    private String customFieldMultiDisplayedKey;

    public MyExample3052DTO(MyEntity3052 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldMulti = entity.getCustomFieldMultiList().stream().collect(MultivalueField.toMultivalueField(
                e -> String.valueOf(e.getId()),
                MyEntity3052Multi::getCustomField
        ));
        this.customFieldMultiDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldMultiList().stream().map(MyEntity3052Multi::getCustomField
        ).collect(Collectors.joining(",")), 12);
    }
}