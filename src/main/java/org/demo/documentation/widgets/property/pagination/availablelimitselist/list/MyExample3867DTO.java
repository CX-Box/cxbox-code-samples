package org.demo.documentation.widgets.property.pagination.availablelimitselist.list;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
import org.demo.documentation.widgets.property.pagination.availablelimitselist.multivalue.MyEntity3867Multi;

import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3867DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;
    @SearchParameter(name = "customFieldMultivalueList.id", provider = LongValueProvider.class)
    private MultivalueField customFieldMultivalue;
    private String customFieldMultivalueDisplayedKey;
    @SearchParameter(name = "customFieldPickListEntity.customField")
    private String customFieldPickList;
    @SearchParameter(name = "customFieldPickListEntity.id", provider = LongValueProvider.class)
    private Long customFieldPickListId;

    public MyExample3867DTO(MyEntity3867 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldMultivalue = entity.getCustomFieldMultivalueList().stream().collect(MultivalueField.toMultivalueField(
                e -> String.valueOf(e.getId()),
                e -> String.valueOf(e.getCustomField())
        ));
        this.customFieldMultivalueDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldMultivalueList().stream().map(MyEntity3867Multi::getCustomField
        ).map(e -> e.toString()).collect(Collectors.joining(",")), 12);
        this.customFieldPickListId = Optional.ofNullable(entity.getCustomFieldPickListEntity())
                .map(e -> e.getId())
                .orElse(null);
        this.customFieldPickList = Optional.ofNullable(entity.getCustomFieldPickListEntity())
                .map(e -> e.getCustomField())
                .orElse(null);
    }
}