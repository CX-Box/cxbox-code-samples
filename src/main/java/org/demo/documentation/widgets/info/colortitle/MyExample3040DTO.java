package org.demo.documentation.widgets.info.colortitle;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.*;
import org.demo.documentation.widgets.info.colortitle.enums.CustomFieldColorDictionaryEnum;
import org.demo.documentation.widgets.info.colortitle.enums.CustomFieldColorRadioEnum;
import org.demo.documentation.widgets.info.colortitle.forfields.MyEntity3040Multi;
import org.demo.documentation.widgets.info.colortitle.forfields.MyEntity3040MultiMulti;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3040DTO extends DataResponseDTO {

    private String customField;
    private String customFieldColor;
    private String customFieldText;
    private String customFieldTextColor;
    @SearchParameter(name = "customFieldColorMultivalueHoverList.id", provider = LongValueProvider.class)
    private MultivalueField customFieldColorMultivalueHover;
    private String customFieldColorMultivalueHoverDisplayedKey;
    @SearchParameter(name = "customFieldColorMultivalueList.id", provider = LongValueProvider.class)
    private MultivalueField customFieldColorMultivalue;
    private String customFieldColorMultivalueDisplayedKey;
    @SearchParameter(name = "customFieldColorInlinePicklistEntity.customField", provider = StringValueProvider.class)
    private String customFieldColorInlinePicklist;
    @SearchParameter(name = "customFieldColorInlinePicklistEntity.id", provider = LongValueProvider.class)
    private Long customFieldColorInlinePicklistId;
    @SearchParameter(name = "customFieldColorPicklistEntity.customField", provider = StringValueProvider.class)
    private String customFieldColorPicklist;
    @SearchParameter(name = "customFieldColorPicklistEntity.id", provider = LongValueProvider.class)
    private Long customFieldColorPicklistId;
    @SearchParameter(name = "customFieldColorRadio", provider = EnumValueProvider.class)
    private CustomFieldColorRadioEnum customFieldColorRadio;
    @SearchParameter(name = "customFieldColorPercent", provider = BigDecimalValueProvider.class)
    private Long customFieldColorPercent;
    @SearchParameter(name = "customFieldColorNumber", provider = BigDecimalValueProvider.class)
    private Long customFieldColorNumber;
    @SearchParameter(name = "customFieldColorFileUploade", provider = StringValueProvider.class)
    private String customFieldColorFileUploade;
    private String customFieldColorFileUploadeId;
    @SearchParameter(name = "customFieldColorDictionary", provider = EnumValueProvider.class)
    private CustomFieldColorDictionaryEnum customFieldColorDictionary;
    @SearchParameter(name = "customFieldColorDateTimeWithSeconds", provider = DateValueProvider.class)
    private LocalDateTime customFieldColorDateTimeWithSeconds;
    @SearchParameter(name = "customFieldColorDate", provider = DateValueProvider.class)
    private LocalDateTime customFieldColorDate;
    @SearchParameter(name = "customFieldColorCheckbox", provider = BooleanValueProvider.class)
    private Boolean customFieldColorCheckbox;
    @SearchParameter(name = "customFieldColorDateTime", provider = DateTimeValueProvider.class)
    private LocalDateTime customFieldColorDateTime;
    @SearchParameter(name = "customFieldColorText", provider = StringValueProvider.class)
    private String customFieldColorText;
    @SearchParameter(name = "customFieldColorInput", provider = StringValueProvider.class)
    private String customFieldColorInput;
    @SearchParameter(name = "customFieldColorMoney", provider = BigDecimalValueProvider.class)
    private Double customFieldColorMoney;

    // --8<-- [start:colorDTO]
    public MyExample3040DTO(MyEntity3040 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldColor = "#eda6a6";
        this.customFieldTextColor = "#a6eda6";
        this.customFieldText = entity.getCustomFieldText();
    // --8<-- [end:colorDTO]
        this.customFieldColorMultivalueHover = entity.getCustomFieldColorMultivalueHoverList().stream().collect(MultivalueField.toMultivalueField(
                e -> String.valueOf(e.getId()),
                MyEntity3040Multi::getCustomField
        ));
        this.customFieldColorMultivalueHoverDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldColorMultivalueHoverList().stream().map(MyEntity3040Multi::getCustomField
        ).collect(Collectors.joining(",")), 12);
        this.customFieldColorMultivalue = entity.getCustomFieldColorMultivalueList().stream().collect(MultivalueField.toMultivalueField(
                e -> String.valueOf(e.getId()),
                MyEntity3040MultiMulti::getCustomField
        ));
        this.customFieldColorMultivalueDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldColorMultivalueList().stream().map(MyEntity3040MultiMulti::getCustomField
        ).collect(Collectors.joining(",")), 12);
        this.customFieldColorInlinePicklistId = Optional.ofNullable(entity.getCustomFieldColorInlinePicklistEntity())
                .map(e -> e.getId())
                .orElse(null);
        this.customFieldColorInlinePicklist = Optional.ofNullable(entity.getCustomFieldColorInlinePicklistEntity())
                .map(e -> e.getCustomField())
                .orElse(null);
        this.customFieldColorPicklistId = Optional.ofNullable(entity.getCustomFieldColorPicklistEntity())
                .map(e -> e.getId())
                .orElse(null);
        this.customFieldColorPicklist = Optional.ofNullable(entity.getCustomFieldColorPicklistEntity())
                .map(e -> e.getCustomField())
                .orElse(null);
        this.customFieldColorRadio = entity.getCustomFieldColorRadio();
        this.customFieldColorPercent = entity.getCustomFieldColorPercent();
        this.customFieldColorNumber = entity.getCustomFieldColorNumber();
        this.customFieldColorFileUploade = entity.getCustomFieldColorFileUploade();
        this.customFieldColorFileUploadeId = entity.getCustomFieldColorFileUploadeId();
        this.customFieldColorDictionary = entity.getCustomFieldColorDictionary();
        this.customFieldColorDateTimeWithSeconds = entity.getCustomFieldColorDateTimeWithSeconds();
        this.customFieldColorDate = entity.getCustomFieldColorDate();
        this.customFieldColorCheckbox = entity.getCustomFieldColorCheckbox();
        this.customFieldColorDateTime = entity.getCustomFieldColorDateTime();
        this.customFieldColorText = entity.getCustomFieldColorText();
        this.customFieldColorInput = entity.getCustomFieldColorInput();
        this.customFieldColorMoney = entity.getCustomFieldColorMoney();
    }
}