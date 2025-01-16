package org.demo.documentation.widgets.property.filtration.filtergroupsave;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;
import org.demo.documentation.widgets.property.filtration.filtergroupsave.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.property.filtration.filtergroupsave.forassoc.MyEntity3624;

import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3618DTO extends DataResponseDTO {

    @SearchParameter(name = "customField", provider = StringValueProvider.class)
    private String customField;
    @SearchParameter(name = "customFieldNew", provider = StringValueProvider.class)
    private String customFieldNew;
    @SearchParameter(name = "customFieldDictionary", provider = EnumValueProvider.class)
    private CustomFieldDictionaryEnum customFieldDictionary;
    @SearchParameter(name = "customFieldMultivalueDisplayedKeyList.id", provider = LongValueProvider.class)
    private MultivalueField customFieldMultivalueDisplayedKey;
    private String customFieldMultivalueDisplayedKeyDisplayedKey;
    @SearchParameter(name = "customFieldPicklistEntity.customField", provider = StringValueProvider.class)
    private String customFieldPicklist;
    @SearchParameter(name = "customFieldPicklistEntity.id", provider = LongValueProvider.class)
    private Long customFieldPicklistId;

    public MyExample3618DTO(MyEntity3618 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldNew = entity.getCustomFieldNew();
        this.customFieldDictionary = entity.getCustomFieldDictionary();
        this.customFieldMultivalueDisplayedKey = entity.getCustomFieldMultivalueDisplayedKeyList().stream().collect(MultivalueField.toMultivalueField(
                e -> String.valueOf(e.getId()),
                e -> String.valueOf(e.getCustomField())
        ));
        this.customFieldMultivalueDisplayedKeyDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldMultivalueDisplayedKeyList().stream().map(MyEntity3624::getCustomField
        ).map(e -> e.toString()).collect(Collectors.joining(",")), 12);
        this.customFieldPicklistId = Optional.ofNullable(entity.getCustomFieldPicklistEntity())
                .map(e -> e.getId())
                .orElse(null);
        this.customFieldPicklist = Optional.ofNullable(entity.getCustomFieldPicklistEntity())
                .map(e -> e.getCustomField())
                .orElse(null);
    }
}