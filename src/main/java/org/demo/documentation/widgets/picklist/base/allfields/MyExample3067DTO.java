package org.demo.documentation.widgets.picklist.base.allfields;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
import org.demo.documentation.widgets.picklist.base.allfields.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.picklist.base.allfields.enums.CustomFieldRadioEnum;
import org.demo.documentation.widgets.picklist.base.allfields.forfields.MyEntity3067Multi;


import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3067DTO extends DataResponseDTO {


    @SearchParameter(name = "customFieldEntity.customFieldPick")
    private String customField;
    @SearchParameter(name = "customFieldEntity.id", provider = LongValueProvider.class)
    private Long customFieldId;
    @SearchParameter(name = "customFieldInlinePickListEntity.customField")
    private String customFieldInlinePickList;
    @SearchParameter(name = "customFieldInlinePickListEntity.id", provider = LongValueProvider.class)
    private Long customFieldInlinePickListId;
    @SearchParameter(name = "customFieldMultivalueList.id", provider = LongValueProvider.class)
    private MultivalueField customFieldMultivalue;
    private String customFieldMultivalueDisplayedKey;
    @SearchParameter(name = "customFieldRadio", provider = EnumValueProvider.class)
    private CustomFieldRadioEnum customFieldRadio;
    @SearchParameter(name = "customFieldFileUploade")
    private String customFieldFileUploade;
    private String customFieldFileUploadeId;
    @SearchParameter(name = "customFieldDictionary", provider = EnumValueProvider.class)
    private CustomFieldDictionaryEnum customFieldDictionary;

    public MyExample3067DTO(MyEntity3067 entity) {
        this.id = entity.getId().toString();

        this.customFieldId = Optional.ofNullable(entity.getCustomFieldEntity())
                .map(e -> e.getId())
                .orElse(null);
        this.customField = Optional.ofNullable(entity.getCustomFieldEntity())
                .map(e -> e.getCustomFieldPick())
                .orElse(null);
        this.customFieldInlinePickListId = Optional.ofNullable(entity.getCustomFieldInlinePickListEntity())
                .map(e -> e.getId())
                .orElse(null);
        this.customFieldInlinePickList = Optional.ofNullable(entity.getCustomFieldInlinePickListEntity())
                .map(e -> e.getCustomField())
                .orElse(null);
        this.customFieldMultivalue = entity.getCustomFieldMultivalueList().stream().collect(MultivalueField.toMultivalueField(
                e -> String.valueOf(e.getId()),
                e -> String.valueOf(e.getCustomField())
        ));
        this.customFieldMultivalueDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldMultivalueList().stream().map(MyEntity3067Multi::getCustomField
        ).map(e -> e.toString()).collect(Collectors.joining(",")), 12);
        this.customFieldRadio = entity.getCustomFieldRadio();
        this.customFieldFileUploade = entity.getCustomFieldFileUploade();
        this.customFieldFileUploadeId = entity.getCustomFieldFileUploadeId();
        this.customFieldDictionary = entity.getCustomFieldDictionary();
    }
}