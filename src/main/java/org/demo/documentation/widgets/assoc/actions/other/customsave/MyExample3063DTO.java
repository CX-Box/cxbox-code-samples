package org.demo.documentation.widgets.assoc.actions.other.customsave;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3063DTO extends DataResponseDTO {


    @SearchParameter(name = "customFieldList.id", provider = LongValueProvider.class)
    private MultivalueField customField;
    private String customFieldDisplayedKey;
    @SearchParameter(name = "customFieldRequired")
    private String customFieldRequired;

    public MyExample3063DTO(MyEntity3063 entity) {
        this.id = entity.getId().toString();

        this.customField = entity.getCustomFieldList().stream().collect(MultivalueField.toMultivalueField(
                e -> String.valueOf(e.getId()),
                MyEntity3063Multi::getCustomField
        ));
        this.customFieldDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldList().stream().map(MyEntity3063Multi::getCustomField
        ).collect(Collectors.joining(",")), 12);
        this.customFieldRequired = entity.getCustomFieldRequired();
    }
}