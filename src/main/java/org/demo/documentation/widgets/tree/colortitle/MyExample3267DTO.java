package org.demo.documentation.widgets.tree.colortitle;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.*;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.tree.base.allType.Myexample3262;
import org.demo.documentation.widgets.tree.base.allType.entity.Myexample3262Multi;
import org.demo.documentation.widgets.tree.base.allType.entity.Myexample3262MultiHover;

import org.demo.documentation.widgets.tree.base.allType.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.tree.base.allType.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.tree.base.allType.enums.CustomFieldRadioEnum;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3267DTO extends DataResponseDTO {

	@SearchParameter(name = "parentId", provider = LongValueProvider.class)
	private Long parentId;
	private Boolean isLeaf;
	private String customField;
	private String customFieldColor;
	private String customFieldText;
	private String customFieldTextColor;

	@SearchParameter(name = "customFieldMultivalueHoverList.id", provider = LongValueProvider.class)
	private MultivalueField customFieldColorMultivalueHover;
	private String customFieldColorMultivalueHoverDisplayedKey;
	@SearchParameter(name = "customFieldMultivalueList.id", provider = LongValueProvider.class)
	private MultivalueField customFieldColorMultivalue;
	private String customFieldColorMultivalueDisplayedKey;
	@SearchParameter(name = "customFieldInlineEntity.customField")
	private String customFieldColorInlinePicklist;
	@SearchParameter(name = "customFieldInlineEntity.id", provider = LongValueProvider.class)
	private Long customFieldColorInlinePicklistId;
	@SearchParameter(name = "customFieldPickListEntity.customField")
	private String customFieldColorPicklist;
	@SearchParameter(name = "customFieldPickListEntity.id", provider = LongValueProvider.class)
	private Long customFieldColorPicklistId;
	@SearchParameter(name = "customFieldRadio", provider = EnumValueProvider.class)
	private CustomFieldRadioEnum customFieldColorRadio;
	@SearchParameter(name = "customFieldMoney", provider = BigDecimalValueProvider.class)
	private Double customFieldColorMoney;
	@SearchParameter(name = "customFieldPercent", provider = BigDecimalValueProvider.class)
	private Long customFieldColorPercent;
	@SearchParameter(name = "customFieldNumber", provider = BigDecimalValueProvider.class)
	private Long customFieldColorNumber;
	@SearchParameter(name = "customFieldFileUpload")
	private String customFieldColorFileUploade;
	private String customFieldColorFileUploadeId;
	@SearchParameter(name = "customFieldDictionary", provider = EnumValueProvider.class)
	private CustomFieldDictionaryEnum customFieldColorDictionary;
	@SearchParameter(name = "customFieldDateTimeWithSeconds", provider = DateValueProvider.class)
	private LocalDateTime customFieldColorDateTimeWithSeconds;
	@SearchParameter(name = "customFieldDate", provider = DateValueProvider.class)
	private LocalDateTime customFieldColorDate;
	@SearchParameter(name = "customFieldCheckbox", provider = BooleanValueProvider.class)
	private Boolean customFieldColorCheckbox;
	@SearchParameter(name = "customFieldDateTime", provider = DateTimeValueProvider.class)
	private LocalDateTime customFieldColorDateTime;
	@SearchParameter(name = "customFieldText")
	private String customFieldColorText;
	@SearchParameter(name = "customField")
	private String customFieldColorInput;
	private String customFieldColorHint;
	private String customFieldColorHidden;
	@SearchParameter(name = "customFieldMultipleSelect", multiFieldKey = EnumValueProvider.class, provider = MultiFieldValueProvider.class)
	@EnumValueProvider.BaseEnum(value = CustomFieldMultipleSelectEnum.class)
	private MultivalueField customFieldColorMultipleSelect;

	// --8<-- [start:colorDTO]
	public MyExample3267DTO(Myexample3262 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldText = entity.getCustomFieldText();
		this.customFieldColor = "#eda6a6";
		this.customFieldTextColor = "#a6eda6";
		// --8<-- [end:colorDTO]
		this.id = Optional.of(entity).map(BaseEntity::getId).map(String::valueOf).orElse(null);
		this.customFieldColorHint = entity.getCustomFieldHint();
		this.customFieldColorMultivalueHover = entity.getCustomFieldMultivalueHoverList().stream().collect(MultivalueField.toMultivalueField(
				e -> String.valueOf(e.getId()),
				e -> String.valueOf(e.getCustomField())
		));
		this.customFieldColorMultivalueHoverDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldMultivalueHoverList().stream().map(Myexample3262MultiHover::getCustomField
		).map(e -> e.toString()).collect(Collectors.joining(",")), 12);
		this.customFieldColorMultivalue = entity.getCustomFieldMultivalueList().stream().collect(MultivalueField.toMultivalueField(
				e -> String.valueOf(e.getId()),
				e -> String.valueOf(e.getCustomField())
		));
		this.customFieldColorMultivalueDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldMultivalueList().stream().map(Myexample3262Multi::getCustomField
		).map(e -> e.toString()).collect(Collectors.joining(",")), 12);
		this.customFieldColorMultipleSelect = entity.getCustomFieldMultipleSelect().stream().collect(MultivalueField.toMultivalueField(Enum::name, CustomFieldMultipleSelectEnum::getValue));
		this.customFieldColorRadio = entity.getCustomFieldRadio();
		this.customFieldColorMoney = entity.getCustomFieldMoney();
		this.customFieldColorInlinePicklistId = Optional.ofNullable(entity.getCustomFieldInlineEntity())
				.map(e -> e.getId())
				.orElse(null);
		this.customFieldColorInlinePicklist = Optional.ofNullable(entity.getCustomFieldInlineEntity())
				.map(e -> e.getCustomField())
				.orElse(null);
		this.customFieldColorInlinePicklistId = Optional.ofNullable(entity.getCustomFieldPickListEntity())
				.map(e -> e.getId())
				.orElse(null);
		this.customFieldColorPicklist = Optional.ofNullable(entity.getCustomFieldPickListEntity())
				.map(e -> e.getCustomField2())
				.orElse(null);
		this.customFieldColorPercent = entity.getCustomFieldPercent();
		this.customFieldColorNumber = entity.getCustomFieldNumber();
		this.customFieldColorFileUploade = entity.getCustomFieldFileUpload();
		this.customFieldColorFileUploadeId = entity.getCustomFieldFileUploadId();
		this.customFieldColorDictionary = entity.getCustomFieldDictionary();
		this.customFieldColorDateTimeWithSeconds = entity.getCustomFieldDateTimeWithSeconds();
		this.customFieldColorDate = entity.getCustomFieldDate();
		this.customFieldColorCheckbox = entity.getCustomFieldCheckbox();
		this.customFieldColorDateTime = entity.getCustomFieldDateTime();
		this.customFieldText = entity.getCustomFieldText();
		this.customFieldColorHidden = entity.getCustomFieldHidden();
		this.customField = entity.getCustomField();
		this.parentId = entity.getParentId();


	}
}