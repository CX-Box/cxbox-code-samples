package org.demo.documentation.widgets.additionallist.base.allfields;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.*;
import org.demo.documentation.widgets.additionallist.base.allfields.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.additionallist.base.allfields.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.additionallist.base.allfields.enums.CustomFieldRadioEnum;
import org.demo.documentation.widgets.additionallist.base.allfields.forfields.MyEntity3191Multi;
import org.demo.documentation.widgets.additionallist.base.allfields.forfields.MyEntity3191MultiHover;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3191DTO extends DataResponseDTO {

    @SearchParameter(name = "customField")
    private String customField;
    @SearchParameter(name = "customFieldMultivalueHoverDisplayedKeyList.id", provider = LongValueProvider.class)
    private MultivalueField customFieldMultivalueHoverDisplayedKey;
    private String customFieldMultivalueHoverDisplayedKeyDisplayedKey;
    @SearchParameter(name = "customFieldHint")
    private String customFieldHint;
    @SearchParameter(name = "customFieldMultivalueList.id", provider = LongValueProvider.class)
    private MultivalueField customFieldMultivalue;
    private String customFieldMultivalueDisplayedKey;
    @SearchParameter(name = "customFieldMultipleSelect", multiFieldKey = EnumValueProvider.class, provider = MultiFieldValueProvider.class)
    @EnumValueProvider.BaseEnum(value = CustomFieldMultipleSelectEnum.class)
    private MultivalueField customFieldMultipleSelect;
    @SearchParameter(name = "customFieldRadio", provider = EnumValueProvider.class)
    private CustomFieldRadioEnum customFieldRadio;
    @SearchParameter(name = "customFieldMoney", provider = BigDecimalValueProvider.class)
    private Double customFieldMoney;
    @SearchParameter(name = "customFieldInlineEntity.customField")
    private String customFieldInline;
    @SearchParameter(name = "customFieldInlineEntity.id", provider = LongValueProvider.class)
    private Long customFieldInlineId;
    @SearchParameter(name = "customFieldPickListEntity.customField")
    private String customFieldPickList;
    @SearchParameter(name = "customFieldPickListEntity.id", provider = LongValueProvider.class)
    private Long customFieldPickListId;
    @SearchParameter(name = "customFieldPercent", provider = BigDecimalValueProvider.class)
    private Long customFieldPercent;
    @SearchParameter(name = "customFieldNumber", provider = BigDecimalValueProvider.class)
    private Long customFieldNumber;
    @SearchParameter(name = "customFieldFileUpload")
    private String customFieldFileUpload;
    private String customFieldFileUploadId;
    @SearchParameter(name = "customFieldDictionary", provider = EnumValueProvider.class)
    private CustomFieldDictionaryEnum customFieldDictionary;
    @SearchParameter(name = "customFieldDateTimeWithSeconds", provider = DateValueProvider.class)
    private LocalDateTime customFieldDateTimeWithSeconds;
    @SearchParameter(name = "customFieldDate", provider = DateValueProvider.class)
    private LocalDateTime customFieldDate;
    @SearchParameter(name = "customFieldCheckbox", provider = BooleanValueProvider.class)
    private Boolean customFieldCheckbox;
    @SearchParameter(name = "customFieldDateTime", provider = DateTimeValueProvider.class)
    private LocalDateTime customFieldDateTime;
    @SearchParameter(name = "customFieldHidden")
    private String customFieldHidden;
    @SearchParameter(name = "customFieldText")
    private String customFieldText;

    public MyExample3191DTO(MyEntity3191 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldMultivalueHoverDisplayedKey = entity.getCustomFieldMultivalueHoverDisplayedKeyList().stream().collect(MultivalueField.toMultivalueField(
                e -> String.valueOf(e.getId()),
                e -> String.valueOf(e.getCustomField())
        ));
        this.customFieldMultivalueHoverDisplayedKeyDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldMultivalueHoverDisplayedKeyList().stream().map(MyEntity3191MultiHover::getCustomField
        ).map(e -> e.toString()).collect(Collectors.joining(",")), 12);
        this.customFieldHint = entity.getCustomFieldHint();
        this.customFieldMultivalue = entity.getCustomFieldMultivalueList().stream().collect(MultivalueField.toMultivalueField(
                e -> String.valueOf(e.getId()),
                e -> String.valueOf(e.getCustomField())
        ));
        this.customFieldMultivalueDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldMultivalueList().stream().map(MyEntity3191Multi::getCustomField
        ).map(e -> e.toString()).collect(Collectors.joining(",")), 12);
        this.customFieldMultipleSelect = entity.getCustomFieldMultipleSelect().stream().collect(MultivalueField.toMultivalueField(Enum::name, CustomFieldMultipleSelectEnum::getValue));
        this.customFieldRadio = entity.getCustomFieldRadio();
        this.customFieldMoney = entity.getCustomFieldMoney();
        this.customFieldInlineId = Optional.ofNullable(entity.getCustomFieldInlineEntity())
                .map(e -> e.getId())
                .orElse(null);
        this.customFieldInline = Optional.ofNullable(entity.getCustomFieldInlineEntity())
                .map(e -> e.getCustomField())
                .orElse(null);
        this.customFieldPickListId = Optional.ofNullable(entity.getCustomFieldPickListEntity())
                .map(e -> e.getId())
                .orElse(null);
        this.customFieldPickList = Optional.ofNullable(entity.getCustomFieldPickListEntity())
                .map(e -> e.getCustomField())
                .orElse(null);
        this.customFieldPercent = entity.getCustomFieldPercent();
        this.customFieldNumber = entity.getCustomFieldNumber();
        this.customFieldFileUpload = entity.getCustomFieldFileUpload();
        this.customFieldFileUploadId = entity.getCustomFieldFileUploadId();
        this.customFieldDictionary = entity.getCustomFieldDictionary();
        this.customFieldDateTimeWithSeconds = entity.getCustomFieldDateTimeWithSeconds();
        this.customFieldDate = entity.getCustomFieldDate();
        this.customFieldCheckbox = entity.getCustomFieldCheckbox();
        this.customFieldDateTime = entity.getCustomFieldDateTime();
        this.customFieldHidden = entity.getCustomFieldHidden();
        this.customFieldText = entity.getCustomFieldText();
    }
}