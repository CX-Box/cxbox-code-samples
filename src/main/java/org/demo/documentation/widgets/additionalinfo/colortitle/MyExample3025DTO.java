package org.demo.documentation.widgets.additionalinfo.colortitle;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.*;
import org.demo.documentation.widgets.additionalinfo.colortitle.enums.CustomFieldColorDictionaryEnum;
import org.demo.documentation.widgets.additionalinfo.colortitle.enums.CustomFieldColorRadioEnum;
import org.demo.documentation.widgets.additionalinfo.colortitle.forfields.MyEntity3034;
import org.demo.documentation.widgets.additionalinfo.colortitle.forfields.MyEntity3035;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3025DTO extends DataResponseDTO {

	private String customField;
	private String customFieldText;
	private String customFieldColor;
	private String customFieldTextColor;
	@SearchParameter(name = "customFieldColorInput")
	private String customFieldColorInput;
	@SearchParameter(name = "customFieldColorText")
	private String customFieldColorText;
	@SearchParameter(name = "customFieldColorDateTime", provider = DateTimeValueProvider.class)
	private LocalDateTime customFieldColorDateTime;
	@SearchParameter(name = "customFieldColorCheckbox", provider = BooleanValueProvider.class)
	private Boolean customFieldColorCheckbox;
	@SearchParameter(name = "customFieldColorDate", provider = DateValueProvider.class)
	private LocalDateTime customFieldColorDate;
	@SearchParameter(name = "customFieldColorDateTimeWithSeconds", provider = DateValueProvider.class)
	private LocalDateTime customFieldColorDateTimeWithSeconds;
	@SearchParameter(name = "customFieldColorDictionary", provider = EnumValueProvider.class)
	private CustomFieldColorDictionaryEnum customFieldColorDictionary;
	@SearchParameter(name = "customFieldColorFileUploade")
	private String customFieldColorFileUploade;
	private String customFieldColorFileUploadeId;
	@SearchParameter(name = "customFieldColorNumber", provider = BigDecimalValueProvider.class)
	private Long customFieldColorNumber;
	@SearchParameter(name = "customFieldColorPercent", provider = BigDecimalValueProvider.class)
	private Long customFieldColorPercent;
	@SearchParameter(name = "customFieldColorMoney", provider = BigDecimalValueProvider.class)
	private Double customFieldColorMoney;
	@SearchParameter(name = "customFieldColorRadio", provider = EnumValueProvider.class)
	private CustomFieldColorRadioEnum customFieldColorRadio;
	@SearchParameter(name = "customFieldColorPicklistEntity.customField")
	private String customFieldColorPicklist;
	@SearchParameter(name = "customFieldColorPicklistEntity.id", provider = LongValueProvider.class)
	private Long customFieldColorPicklistId;
	@SearchParameter(name = "customFieldColorInlinePicklistEntity.customField")
	private String customFieldColorInlinePicklist;
	@SearchParameter(name = "customFieldColorInlinePicklistEntity.id", provider = LongValueProvider.class)
	private Long customFieldColorInlinePicklistId;
	@SearchParameter(name = "customFieldColorMultivalueHoverList.id", provider = LongValueProvider.class)
	private MultivalueField customFieldColorMultivalueHover;
	private String customFieldColorMultivalueHoverDisplayedKey;
	@SearchParameter(name = "customFieldColorMultivalueList.id", provider = LongValueProvider.class)
	private MultivalueField customFieldColorMultivalue;
	private String customFieldColorMultivalueDisplayedKey;

	// --8<-- [start:colorDTO]
	public MyExample3025DTO(MyEntity3025 entity) {
		this.id = entity.getId().toString();
		this.customFieldColor = "#eda6a6";
		this.customFieldTextColor = "#a6eda6";
		this.customFieldText = entity.getCustomFieldText();
		this.customField = entity.getCustomField();
		// --8<-- [end:colorDTO]
		this.customFieldColorInput = entity.getCustomFieldColorInput();
		this.customFieldColorText = entity.getCustomFieldColorText();
		this.customFieldColorDateTime = entity.getCustomFieldColorDateTime();
		this.customFieldColorCheckbox = entity.getCustomFieldColorCheckbox();
		this.customFieldColorDate = entity.getCustomFieldColorDate();
		this.customFieldColorDateTimeWithSeconds = entity.getCustomFieldColorDateTimeWithSeconds();
		this.customFieldColorDictionary = entity.getCustomFieldColorDictionary();
		this.customFieldColorFileUploade = entity.getCustomFieldColorFileUploade();
		this.customFieldColorFileUploadeId = entity.getCustomFieldColorFileUploadeId();
		this.customFieldColorNumber = entity.getCustomFieldColorNumber();
		this.customFieldColorPercent = entity.getCustomFieldColorPercent();
		this.customFieldColorMoney = entity.getCustomFieldColorMoney();
		this.customFieldColorRadio = entity.getCustomFieldColorRadio();
		this.customFieldColorPicklistId = Optional.ofNullable(entity.getCustomFieldColorPicklistEntity())
				.map(e -> e.getId())
				.orElse(null);
		this.customFieldColorPicklist = Optional.ofNullable(entity.getCustomFieldColorPicklistEntity())
				.map(e -> e.getCustomField())
				.orElse(null);
		this.customFieldColorInlinePicklistId = Optional.ofNullable(entity.getCustomFieldColorInlinePicklistEntity())
				.map(e -> e.getId())
				.orElse(null);
		this.customFieldColorInlinePicklist = Optional.ofNullable(entity.getCustomFieldColorInlinePicklistEntity())
				.map(e -> e.getCustomField())
				.orElse(null);
		this.customFieldColorMultivalueHover = entity.getCustomFieldColorMultivalueHoverList().stream().collect(MultivalueField.toMultivalueField(
				e -> String.valueOf(e.getId()),
				MyEntity3034::getCustomField
		));
		this.customFieldColorMultivalueHoverDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldColorMultivalueHoverList().stream().map(MyEntity3034::getCustomField
		).collect(Collectors.joining(",")), 12);
		this.customFieldColorMultivalue = entity.getCustomFieldColorMultivalueList().stream().collect(MultivalueField.toMultivalueField(
				e -> String.valueOf(e.getId()),
				MyEntity3035::getCustomField
		));
		this.customFieldColorMultivalueDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldColorMultivalueList().stream().map(MyEntity3035::getCustomField
		).collect(Collectors.joining(",")), 12);
	}
}