package org.demo.documentation.widgets.list.customizationcolumns;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.*;
import org.demo.documentation.widgets.list.customizationcolumns.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.list.customizationcolumns.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.list.customizationcolumns.enums.CustomFieldMultipleSelectEnum1;
import org.demo.documentation.widgets.list.customizationcolumns.enums.CustomFieldRadioEnum;
import org.demo.documentation.widgets.list.customizationcolumns.forfields.MyEntity3135Multi;
import org.demo.documentation.widgets.list.customizationcolumns.forfields.MyEntity3135MultiHover;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3135DTO extends DataResponseDTO {

    private String customField;
    @SearchParameter(name = "customFieldInput", provider = StringValueProvider.class)
    private String customFieldInput;
    @SearchParameter(name = "customFieldDate", provider = DateValueProvider.class)
    private LocalDateTime customFieldDate;
    @SearchParameter(name = "customFieldCheckBox", provider = BooleanValueProvider.class)
    private Boolean customFieldCheckBox;
    @SearchParameter(name = "customFieldDictionary", provider = EnumValueProvider.class)
    private CustomFieldDictionaryEnum customFieldDictionary;

    private String customFieldMultivalueHoverDisplayedKey;
    private String customFieldHint;

    private String customFieldMultivalueDisplayedKey;

    @SearchParameter(name = "customFieldRadio", provider = EnumValueProvider.class)
    private CustomFieldRadioEnum customFieldRadio;
    @SearchParameter(name = "customFieldMoney", provider = BigDecimalValueProvider.class)
    private Double customFieldMoney;
    @SearchParameter(name = "customFieldInlineEntity.customField", provider = StringValueProvider.class)
    private String customFieldInline;
    @SearchParameter(name = "customFieldInlineEntity.id", provider = LongValueProvider.class)
    private Long customFieldInlineId;
    @SearchParameter(name = "customFieldPickListEntity.customField", provider = StringValueProvider.class)
    private String customFieldPickList;
    @SearchParameter(name = "customFieldPickListEntity.id", provider = LongValueProvider.class)
    private Long customFieldPickListId;
    @SearchParameter(name = "customFieldPercent", provider = BigDecimalValueProvider.class)
    private Long customFieldPercent;
    @SearchParameter(name = "customFieldNumber", provider = BigDecimalValueProvider.class)
    private Long customFieldNumber;
    @SearchParameter(name = "customFieldFileUpload", provider = StringValueProvider.class)
    private String customFieldFileUpload;
    private String customFieldFileUploadId;
    @SearchParameter(name = "customFieldDateTimeWithSeconds", provider = DateValueProvider.class)
    private LocalDateTime customFieldDateTimeWithSeconds;
    @SearchParameter(name = "customFieldDateTime", provider = DateTimeValueProvider.class)
    private LocalDateTime customFieldDateTime;
    @SearchParameter(name = "customFieldText", provider = StringValueProvider.class)
    private String customFieldText;
    private String customFieldHidden;
    @SearchParameter(name = "customFieldMultivalueList.id", provider = LongValueProvider.class)
    private MultivalueField customFieldMultivalue;
    @SearchParameter(name = "customFieldMultipleSelect", multiFieldKey = EnumValueProvider.class, provider = MultiFieldValueProvider.class)
    @EnumValueProvider.BaseEnum(value = CustomFieldMultipleSelectEnum1.class)
    private MultivalueField customFieldMultipleSelect;
    @SearchParameter(name = "customFieldMultivalueHoverList.id", provider = LongValueProvider.class)
    private MultivalueField customFieldMultivalueHover;

    public MyExample3135DTO(MyEntity3135 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldInput = entity.getCustomFieldInput();
        this.customFieldDate = entity.getCustomFieldDate();
        this.customFieldCheckBox = entity.getCustomFieldCheckBox();
        this.customFieldDictionary = entity.getCustomFieldDictionary();

        this.customFieldMultivalueHoverDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldMultivalueHoverList().stream().map(MyEntity3135MultiHover::getCustomField
        ).collect(Collectors.joining(",")), 12);
        this.customFieldHint = entity.getCustomFieldHint();
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
        this.customFieldDateTimeWithSeconds = entity.getCustomFieldDateTimeWithSeconds();
        this.customFieldDateTime = entity.getCustomFieldDateTime();
        this.customFieldText = entity.getCustomFieldText();
        this.customFieldHidden = entity.getCustomFieldHidden();
        this.customFieldMultivalue = entity.getCustomFieldMultivalueList().stream().collect(MultivalueField.toMultivalueField(
                e -> String.valueOf(e.getId()),
                MyEntity3135Multi::getCustomField
        ));
        this.customFieldMultivalueDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldMultivalueList().stream().map(MyEntity3135Multi::getCustomField
        ).collect(Collectors.joining(",")), 12);
        this.customFieldMultipleSelect = entity.getCustomFieldMultipleSelect().stream().collect(MultivalueField.toMultivalueField(Enum::name, CustomFieldMultipleSelectEnum::getValue));
        this.customFieldMultivalueHover = entity.getCustomFieldMultivalueHoverList().stream().collect(MultivalueField.toMultivalueField(
                e -> String.valueOf(e.getId()),
                MyEntity3135MultiHover::getCustomField
        ));
        this.customFieldMultivalueHoverDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldMultivalueHoverList().stream().map(MyEntity3135MultiHover::getCustomField
        ).collect(Collectors.joining(",")), 12);
    }
}