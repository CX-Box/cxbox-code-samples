package org.demo.documentation.widgets.additionalinfo.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.*;
import org.demo.documentation.widgets.additionalinfo.base.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.additionalinfo.base.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.additionalinfo.base.enums.CustomFieldRadioEnum;
import org.demo.documentation.widgets.additionalinfo.base.forfields.MyEntity3600Multi;
import org.demo.documentation.widgets.additionalinfo.base.forfields.MyEntity3600Multi2;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3600DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;
    @SearchParameter(name = "customField2")
    private String customField2;
    @SearchParameter(name = "customField3")
    private String customField3;
    @SearchParameter(name = "customFieldText")
    private String customFieldText;
    @SearchParameter(name = "customFieldDateTime", provider = DateTimeValueProvider.class)
    private LocalDateTime customFieldDateTime;
    @SearchParameter(name = "customFieldCheckbox", provider = BooleanValueProvider.class)
    private Boolean customFieldCheckbox;
    @SearchParameter(name = "customFieldDictionary", provider = EnumValueProvider.class)
    private CustomFieldDictionaryEnum customFieldDictionary;
    @SearchParameter(name = "customFieldNum", provider = BigDecimalValueProvider.class)
    private Long customFieldNum;
    @SearchParameter(name = "customFieldPercent", provider = BigDecimalValueProvider.class)
    private Long customFieldPercent;
    @SearchParameter(name = "customFieldMoney", provider = BigDecimalValueProvider.class)
    private Double customFieldMoney;
    @SearchParameter(name = "customFieldRadio", provider = EnumValueProvider.class)
    private CustomFieldRadioEnum customFieldRadio;
    @SearchParameter(name = "customFieldDateTimeWithSeconds", provider = DateValueProvider.class)
    private LocalDateTime customFieldDateTimeWithSeconds;
    @SearchParameter(name = "customFieldInlinePickListEntity.customField")
    private String customFieldInlinePickList;
    @SearchParameter(name = "customFieldInlinePickListEntity.id", provider = LongValueProvider.class)
    private Long customFieldInlinePickListId;
    @SearchParameter(name = "customFieldPickListEntity.customField")
    private String customFieldPickList;
    @SearchParameter(name = "customFieldPickListEntity.id", provider = LongValueProvider.class)
    private Long customFieldPickListId;
    @SearchParameter(name = "customFieldMultipleSelect", multiFieldKey = EnumValueProvider.class, provider = MultiFieldValueProvider.class)
    @EnumValueProvider.BaseEnum(value = CustomFieldMultipleSelectEnum.class)
    private MultivalueField customFieldMultipleSelect;
    @SearchParameter(name = "customFieldMultivalueList.id", provider = LongValueProvider.class)
    private MultivalueField customFieldMultivalue;
    private String customFieldMultivalueDisplayedKey;
    private String customFieldHint;
    @SearchParameter(name = "customFieldMultivalueHoverList.id", provider = LongValueProvider.class)
    private MultivalueField customFieldMultivalueHover;
    private String customFieldMultivalueHoverDisplayedKey;
    @SearchParameter(name = "customFieldDate", provider = DateValueProvider.class)
    private LocalDateTime customFieldDate;

    public MyExample3600DTO(MyEntity3600 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customField2 = entity.getCustomField2();
        this.customField3 = entity.getCustomField3();
        this.customFieldText = entity.getCustomFieldText();
        this.customFieldDateTime = entity.getCustomFieldDateTime();
        this.customFieldCheckbox = entity.getCustomFieldCheckbox();
        this.customFieldDictionary = entity.getCustomFieldDictionary();
        this.customFieldNum = entity.getCustomFieldNum();
        this.customFieldPercent = entity.getCustomFieldPercent();
        this.customFieldMoney = entity.getCustomFieldMoney();
        this.customFieldRadio = entity.getCustomFieldRadio();
        this.customFieldDateTimeWithSeconds = entity.getCustomFieldDateTimeWithSeconds();
        this.customFieldInlinePickListId = Optional.ofNullable(entity.getCustomFieldInlinePickListEntity())
                .map(e -> e.getId())
                .orElse(null);
        this.customFieldInlinePickList = Optional.ofNullable(entity.getCustomFieldInlinePickListEntity())
                .map(e -> e.getCustomField())
                .orElse(null);
        this.customFieldPickListId = Optional.ofNullable(entity.getCustomFieldPickListEntity())
                .map(e -> e.getId())
                .orElse(null);
        this.customFieldPickList = Optional.ofNullable(entity.getCustomFieldPickListEntity())
                .map(e -> e.getCustomField())
                .orElse(null);
        this.customFieldMultipleSelect = entity.getCustomFieldMultipleSelect().stream().collect(MultivalueField.toMultivalueField(Enum::name, CustomFieldMultipleSelectEnum::getValue));
        this.customFieldMultivalue = entity.getCustomFieldMultivalueList().stream().collect(MultivalueField.toMultivalueField(
                e -> String.valueOf(e.getId()),
                MyEntity3600Multi2::getCustomField
        ));
        this.customFieldMultivalueDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldMultivalueList().stream().map(MyEntity3600Multi2::getCustomField
        ).collect(Collectors.joining(",")), 12);
        this.customFieldHint = entity.getCustomFieldHint();
        this.customFieldMultivalueHover = entity.getCustomFieldMultivalueHoverList().stream().collect(MultivalueField.toMultivalueField(
                e -> String.valueOf(e.getId()),
                MyEntity3600Multi::getCustomField
        ));
        this.customFieldMultivalueHoverDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldMultivalueHoverList().stream().map(MyEntity3600Multi::getCustomField
        ).collect(Collectors.joining(",")), 12);
        this.customFieldDate = entity.getCustomFieldDate();
    }
}