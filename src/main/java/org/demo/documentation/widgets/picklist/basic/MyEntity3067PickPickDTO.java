package org.demo.documentation.widgets.picklist.basic;

import org.apache.commons.lang3.StringUtils;
import org.cxbox.api.data.dto.DataResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.*;
import org.demo.documentation.widgets.picklist.basic.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.picklist.basic.enums.CustomFieldRadioEnum;
import org.demo.documentation.widgets.picklist.basic.forfields.MyEntity3067Multi;
import org.demo.documentation.widgets.picklist.basic.forfields.MyEntity3067MultiMulti;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3067PickPickDTO extends DataResponseDTO {

    private String customFieldPick;
    @SearchParameter(name = "customFieldMultivalueHoverList.id", provider = LongValueProvider.class)
    private MultivalueField customFieldMultivalueHover;
    private String customFieldMultivalueHoverDisplayedKey;
    @SearchParameter(name = "customFieldMultivalueList.id", provider = LongValueProvider.class)
    private MultivalueField customFieldMultivalue;
    private String customFieldMultivalueDisplayedKey;
    @SearchParameter(name = "customFieldInlinePicklistEntity.customField", provider = StringValueProvider.class)
    private String customFieldInlinePicklist;
    @SearchParameter(name = "customFieldInlinePicklistEntity.id", provider = LongValueProvider.class)
    private Long customFieldInlinePicklistId;
    @SearchParameter(name = "customFieldPicklistEntity.customField", provider = StringValueProvider.class)
    private String customFieldPicklist;
    @SearchParameter(name = "customFieldPicklistEntity.id", provider = LongValueProvider.class)
    private Long customFieldPicklistId;
    @SearchParameter(name = "customFieldRadio", provider = EnumValueProvider.class)
    private CustomFieldRadioEnum customFieldRadio;
    @SearchParameter(name = "customFieldMoney", provider = BigDecimalValueProvider.class)
    private Double customFieldMoney;
    @SearchParameter(name = "customFieldPercent", provider = BigDecimalValueProvider.class)
    private Long customFieldPercent;
    @SearchParameter(name = "customFieldNumber", provider = BigDecimalValueProvider.class)
    private Long customFieldNumber;
    @SearchParameter(name = "customFieldFileUploade", provider = StringValueProvider.class)
    private String customFieldFileUploade;
    private String customFieldFileUploadeId;
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
    @SearchParameter(name = "customFieldText", provider = StringValueProvider.class)
    private String customFieldText;
    @SearchParameter(name = "customFieldInput", provider = StringValueProvider.class)
    private String customFieldInput;
    @SearchParameter(name = "customField", provider = StringValueProvider.class)
    private String customField;

    public MyEntity3067PickPickDTO(MyEntity3067Pick entity) {
        this.id = entity.getId().toString();
        this.customFieldPick = entity.getCustomFieldPick();
        this.customFieldMultivalueHover = entity.getCustomFieldMultivalueHoverList().stream().collect(MultivalueField.toMultivalueField(
                e -> String.valueOf(e.getId()),
                MyEntity3067MultiMulti::getCustomField
        ));
        this.customFieldMultivalueHoverDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldMultivalueHoverList().stream().map(MyEntity3067MultiMulti::getCustomField
        ).collect(Collectors.joining(",")), 12);
        this.customFieldMultivalue = entity.getCustomFieldMultivalueList().stream().collect(MultivalueField.toMultivalueField(
                e -> String.valueOf(e.getId()),
                MyEntity3067Multi::getCustomField
        ));
        this.customFieldMultivalueDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldMultivalueList().stream().map(MyEntity3067Multi::getCustomField
        ).collect(Collectors.joining(",")), 12);
        this.customFieldInlinePicklistId = Optional.ofNullable(entity.getCustomFieldInlinePicklistEntity())
                .map(e -> e.getId())
                .orElse(null);
        this.customFieldInlinePicklist = Optional.ofNullable(entity.getCustomFieldInlinePicklistEntity())
                .map(e -> e.getCustomField())
                .orElse(null);
        this.customFieldPicklistId = Optional.ofNullable(entity.getCustomFieldPicklistEntity())
                .map(e -> e.getId())
                .orElse(null);
        this.customFieldPicklist = Optional.ofNullable(entity.getCustomFieldPicklistEntity())
                .map(e -> e.getCustomField())
                .orElse(null);
        this.customFieldRadio = entity.getCustomFieldRadio();
        this.customFieldMoney = entity.getCustomFieldMoney();
        this.customFieldPercent = entity.getCustomFieldPercent();
        this.customFieldNumber = entity.getCustomFieldNumber();
        this.customFieldFileUploade = entity.getCustomFieldFileUploade();
        this.customFieldFileUploadeId = entity.getCustomFieldFileUploadeId();
        this.customFieldDictionary = entity.getCustomFieldDictionary();
        this.customFieldDateTimeWithSeconds = entity.getCustomFieldDateTimeWithSeconds();
        this.customFieldDate = entity.getCustomFieldDate();
        this.customFieldCheckbox = entity.getCustomFieldCheckbox();
        this.customFieldDateTime = entity.getCustomFieldDateTime();
        this.customFieldText = entity.getCustomFieldText();
        this.customFieldInput = entity.getCustomFieldInput();
        this.customField = entity.getCustomField();
    }

}
