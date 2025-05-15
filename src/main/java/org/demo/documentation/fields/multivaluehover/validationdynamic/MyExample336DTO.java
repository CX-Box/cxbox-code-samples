package org.demo.documentation.fields.multivaluehover.validationdynamic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;

import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class MyExample336DTO extends DataResponseDTO {

    @SearchParameter(name = "customFieldMultiHolderList.id", provider = LongValueProvider.class)
    private MultivalueField customFieldMultiHolder;
    private String customFieldMultiHolderDisplayedKey;

    public MyExample336DTO(MyEntity336 entity) {
        this.id = entity.getId().toString();
        this.customFieldMultiHolder = entity.getCustomFieldMultiHolderList().stream().collect(MultivalueField.toMultivalueField(
                e -> String.valueOf(e.getId()),
                e -> String.valueOf(e.getCustomField())
        ));
        this.customFieldMultiHolderDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldMultiHolderList().stream().map(MyEntity339::getCustomField
        ).map(e -> e.toString()).collect(Collectors.joining(",")), 12);
    }

}