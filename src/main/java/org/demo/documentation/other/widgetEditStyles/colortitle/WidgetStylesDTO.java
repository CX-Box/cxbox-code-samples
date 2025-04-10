package org.demo.documentation.other.widgetEditStyles.colortitle;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.*;
import org.demo.documentation.other.widgetEditStyles.colortitle.enums.*;
import org.demo.documentation.other.widgetEditStyles.colortitle.forfields.WidgetStylesMulti;
import org.demo.documentation.other.widgetEditStyles.colortitle.forfields.WidgetStylesMultiMulti;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class WidgetStylesDTO extends DataResponseDTO {

    private String customField;
    private String customFieldColor;
    @SearchParameter(name = "customFieldColorMultivalueHoverList.id", provider = LongValueProvider.class)
    private MultivalueField customFieldColorMultivalueHover;
    private String customFieldColorMultivalueHoverDisplayedKey;
    @SearchParameter(name = "customFieldColorMultivalueList.id", provider = LongValueProvider.class)
    private MultivalueField customFieldColorMultivalue;
    private String customFieldColorMultivalueDisplayedKey;
    @SearchParameter(name = "customFieldColorInlinePicklistEntity.customField")
    private String customFieldColorInlinePicklist;
    @SearchParameter(name = "customFieldColorInlinePicklistEntity.id", provider = LongValueProvider.class)
    private Long customFieldColorInlinePicklistId;
    @SearchParameter(name = "customFieldColorPicklistEntity.customField")
    private String customFieldColorPicklist;
    @SearchParameter(name = "customFieldColorPicklistEntity.id", provider = LongValueProvider.class)
    private Long customFieldColorPicklistId;
    @SearchParameter(name = "customFieldColorRadio", provider = EnumValueProvider.class)
    private WidgetStylesColorRadioEnum customFieldColorRadio;
    @SearchParameter(name = "customFieldColorMoney", provider = BigDecimalValueProvider.class)
    private Double customFieldColorMoney;
    @SearchParameter(name = "customFieldColorPercent", provider = BigDecimalValueProvider.class)
    private Long customFieldColorPercent;
    @SearchParameter(name = "customFieldColorNumber", provider = BigDecimalValueProvider.class)
    private Long customFieldColorNumber;
    @SearchParameter(name = "customFieldColorFileUploade")
    private String customFieldColorFileUploade;
    private String customFieldColorFileUploadeId;
    @SearchParameter(name = "customFieldColorDictionary", provider = EnumValueProvider.class)
    private WidgetStylesColorDictionaryEnum customFieldColorDictionary;
    @SearchParameter(name = "customFieldColorDateTimeWithSeconds", provider = DateValueProvider.class)
    private LocalDateTime customFieldColorDateTimeWithSeconds;
    @SearchParameter(name = "customFieldColorDate", provider = DateValueProvider.class)
    private LocalDateTime customFieldColorDate;
    @SearchParameter(name = "customFieldColorCheckbox", provider = BooleanValueProvider.class)
    private Boolean customFieldColorCheckbox;
    @SearchParameter(name = "customFieldColorDateTime", provider = DateTimeValueProvider.class)
    private LocalDateTime customFieldColorDateTime;
    @SearchParameter(name = "customFieldColorText")
    private String customFieldColorText;
    @SearchParameter(name = "customFieldColorInput")
    private String customFieldColorInput;
    @SearchParameter(name = "multipleSelect", multiFieldKey = EnumValueProvider.class, provider = MultiFieldValueProvider.class)
    @EnumValueProvider.BaseEnum(value = WidgetStylesTestEnum.class)
    private MultivalueField multipleSelect;
    private String hint;
    @SearchParameter(name = "time", provider = DateTimeValueProvider.class)
    private LocalDateTime time;
    private String hidden;
    @SearchParameter
    private String customFieldSuggestion;
    @SearchParameter
    private LocalDateTime customFieldSuggestionDate;
    @SearchParameter
    private String suggestion;
    @SearchParameter
    private String suggestionDate;

    public WidgetStylesDTO(WidgetStyles entity) {
        this.id = entity.getId().toString();
        this.suggestionDate = entity.getSuggestionDate();
        this.suggestion = entity.getSuggestion();
        this.customField = entity.getCustomField();
        this.customFieldColor = "#eda6a6";
        this.customFieldColorMultivalueHover = entity.getCustomFieldColorMultivalueHoverList().stream().collect(MultivalueField.toMultivalueField(
                e -> String.valueOf(e.getId()),
                WidgetStylesMulti::getCustomField
        ));
        this.customFieldColorMultivalueHoverDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldColorMultivalueHoverList().stream().map(WidgetStylesMulti::getCustomField
        ).collect(Collectors.joining(",")), 12);
        this.customFieldColorMultivalue = entity.getCustomFieldColorMultivalueList().stream().collect(MultivalueField.toMultivalueField(
                e -> String.valueOf(e.getId()),
                WidgetStylesMultiMulti::getCustomField
        ));
        this.customFieldColorMultivalueDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldColorMultivalueList().stream().map(WidgetStylesMultiMulti::getCustomField
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
        this.customFieldColorMoney = entity.getCustomFieldColorMoney();
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
        this.multipleSelect = entity.getMultipleSelect().stream().collect(MultivalueField.toMultivalueField(Enum::name, WidgetStylesTestEnum::getValue));
        this.hint = entity.getHint();
        this.time = entity.getTime();
        this.hidden = entity.getHidden();
    }
}