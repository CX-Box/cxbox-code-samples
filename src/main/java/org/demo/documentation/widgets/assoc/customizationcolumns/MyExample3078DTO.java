package org.demo.documentation.widgets.assoc.customizationcolumns;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BigDecimalValueProvider;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;

import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3078DTO extends DataResponseDTO {

    @SearchParameter(name = "customField", provider = StringValueProvider.class)
    private String customField;
    @SearchParameter(name = "customFieldTest", provider = StringValueProvider.class)
    private String customFieldTest;
    @SearchParameter(name = "customFieldNumber", provider = BigDecimalValueProvider.class)
    private Long customFieldNumber;
    @SearchParameter(name = "customFieldMultivalueList.id", provider = LongValueProvider.class)
    private MultivalueField customFieldMultivalue;
    private String customFieldMultivalueDisplayedKey;

    public MyExample3078DTO(MyEntity3078 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldTest = entity.getCustomFieldTest();
        this.customFieldNumber = entity.getCustomFieldNumber();
        this.customFieldMultivalue = entity.getCustomFieldMultivalueList().stream().collect(MultivalueField.toMultivalueField(
                e -> String.valueOf(e.getId()),
                e -> String.valueOf(e.getCustomField())
        ));
        this.customFieldMultivalueDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldMultivalueList().stream().map(MyEntity3078Assoc::getCustomField
        ).map(e -> e.toString()).collect(Collectors.joining(",")), 12);
    }
}