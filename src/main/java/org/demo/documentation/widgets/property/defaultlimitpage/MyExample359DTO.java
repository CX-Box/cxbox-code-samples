package org.demo.documentation.widgets.property.defaultlimitpage;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;

import org.demo.documentation.widgets.property.defaultlimitpage.forassoc.MyEntity359Assoc;

import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class MyExample359DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;
    @SearchParameter(name = "customFieldMultivalueList.id", provider = LongValueProvider.class)
    private MultivalueField customFieldMultivalue;
    private String customFieldMultivalueDisplayedKey;
    @SearchParameter(name = "customFieldPicklistEntity.customField")
    private String customFieldPicklist;
    @SearchParameter(name = "customFieldPicklistEntity.id", provider = LongValueProvider.class)
    private Long customFieldPicklistId;

    public MyExample359DTO(MyEntity359 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldMultivalue = entity.getCustomFieldMultivalueList().stream().collect(MultivalueField.toMultivalueField(
                e -> String.valueOf(e.getId()),
                e -> String.valueOf(e.getCustomField())
        ));
        this.customFieldMultivalueDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldMultivalueList().stream().map(MyEntity359Assoc::getCustomField
        ).map(e -> e.toString()).collect(Collectors.joining(",")), 12);
        this.customFieldPicklistId = Optional.ofNullable(entity.getCustomFieldPicklistEntity())
                .map(e -> e.getId())
                .orElse(null);
        this.customFieldPicklist = Optional.ofNullable(entity.getCustomFieldPicklistEntity())
                .map(e -> e.getCustomField())
                .orElse(null);
    }
}