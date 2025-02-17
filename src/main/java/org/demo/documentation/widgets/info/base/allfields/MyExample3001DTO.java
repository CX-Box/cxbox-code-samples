package org.demo.documentation.widgets.info.base.allfields;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.*;
import org.demo.documentation.widgets.info.base.allfields.forfields.MyEntity4222Multi;
import org.demo.documentation.widgets.info.base.allfields.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.info.base.allfields.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.info.base.allfields.enums.CustomFieldRadioEnum;
import org.demo.documentation.widgets.info.base.allfields.forfields.MyEntity4222Multi2;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;


@Getter
@Setter
@NoArgsConstructor
public class MyExample3001DTO extends DataResponseDTO {
    public static final String INFO_TEXT = "Info widget is a component only for data viewing";

    @SearchParameter(name = "customField")
    private String customField;
    @SearchParameter(name = "customFieldDate", provider = DateValueProvider.class)
    private LocalDateTime customFieldDate;
    private String customFieldHint;
    @SearchParameter(name = "customFieldMultipleSelect", multiFieldKey = EnumValueProvider.class, provider = MultiFieldValueProvider.class)
    @EnumValueProvider.BaseEnum(value = CustomFieldMultipleSelectEnum.class)
    private MultivalueField customFieldMultipleSelect;
    @SearchParameter(name = "customFieldPercent", provider = BigDecimalValueProvider.class)
    private Long customFieldPercent;
    @SearchParameter(name = "customFieldDateTimeWithSeconds", provider = DateValueProvider.class)
    private LocalDateTime customFieldDateTimeWithSeconds;
    @SearchParameter(name = "customFieldRadio", provider = EnumValueProvider.class)
    private CustomFieldRadioEnum customFieldRadio;
    @SearchParameter(name = "customFieldMoney", provider = BigDecimalValueProvider.class)
    private Double customFieldMoney;
    @SearchParameter(name = "customFieldNum", provider = BigDecimalValueProvider.class)
    private Long customFieldNum;
    @SearchParameter(name = "customFieldDictionary", provider = EnumValueProvider.class)
    private CustomFieldDictionaryEnum customFieldDictionary;
    @SearchParameter(name = "customFieldCheckbox", provider = BooleanValueProvider.class)
    private Boolean customFieldCheckbox;
    @SearchParameter(name = "customFieldDateTime", provider = DateTimeValueProvider.class)
    private LocalDateTime customFieldDateTime;
    @SearchParameter(name = "customFieldText")
    private String customFieldText;
    @SearchParameter(name = "customFieldMultivalueHoverList.id", provider = LongValueProvider.class)
    private MultivalueField customFieldMultivalueHover;
    private String customFieldMultivalueHoverDisplayedKey;
    @SearchParameter(name = "customFieldMultivalueList.id", provider = LongValueProvider.class)
    private MultivalueField customFieldMultivalue;
    private String customFieldMultivalueDisplayedKey;
    @SearchParameter(name = "customFieldPickListEntity.customField")
    private String customFieldPickList;
    @SearchParameter(name = "customFieldPickListEntity.id", provider = LongValueProvider.class)
    private Long customFieldPickListId;
    @SearchParameter(name = "customFieldInlinePickListEntity.customField")
    private String customFieldInlinePickList;
    @SearchParameter(name = "customFieldInlinePickListEntity.id", provider = LongValueProvider.class)
    private Long customFieldInlinePickListId;

    public MyExample3001DTO(MyEntity3001 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldDate = entity.getCustomFieldDate();
        this.customFieldHint = entity.getCustomFieldHint();
        this.customFieldMultipleSelect = entity.getCustomFieldMultipleSelect().stream().collect(MultivalueField.toMultivalueField(Enum::name, CustomFieldMultipleSelectEnum::getValue));
        this.customFieldPercent = entity.getCustomFieldPercent();
        this.customFieldDateTimeWithSeconds = entity.getCustomFieldDateTimeWithSeconds();
        this.customFieldRadio = entity.getCustomFieldRadio();
        this.customFieldMoney = entity.getCustomFieldMoney();
        this.customFieldNum = entity.getCustomFieldNum();
        this.customFieldDictionary = entity.getCustomFieldDictionary();
        this.customFieldCheckbox = entity.getCustomFieldCheckbox();
        this.customFieldDateTime = entity.getCustomFieldDateTime();
        this.customFieldText = entity.getCustomFieldText();
        this.customFieldMultivalueHover = entity.getCustomFieldMultivalueHoverList().stream().collect(MultivalueField.toMultivalueField(
                e -> String.valueOf(e.getId()),
                MyEntity4222Multi::getCustomField
        ));
        this.customFieldMultivalueHoverDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldMultivalueHoverList().stream().map(MyEntity4222Multi::getCustomField
        ).collect(Collectors.joining(",")), 12);
        this.customFieldMultivalue = entity.getCustomFieldMultivalueList().stream().collect(MultivalueField.toMultivalueField(
                e -> String.valueOf(e.getId()),
                MyEntity4222Multi2::getCustomField
        ));
        this.customFieldMultivalueDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldMultivalueList().stream().map(MyEntity4222Multi2::getCustomField
        ).collect(Collectors.joining(",")), 12);
        this.customFieldPickListId = Optional.ofNullable(entity.getCustomFieldPickListEntity())
                .map(e -> e.getId())
                .orElse(null);
        this.customFieldPickList = Optional.ofNullable(entity.getCustomFieldPickListEntity())
                .map(e -> e.getCustomField())
                .orElse(null);
        this.customFieldInlinePickListId = Optional.ofNullable(entity.getCustomFieldInlinePickListEntity())
                .map(e -> e.getId())
                .orElse(null);
        this.customFieldInlinePickList = Optional.ofNullable(entity.getCustomFieldInlinePickListEntity())
                .map(e -> e.getCustomField())
                .orElse(null);
    }

}