package org.demo.documentation.widgets.tree.customizationcolumns;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.*;
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
public class MyExample3268DTO extends DataResponseDTO {

	private Long parentId;
	private Boolean isLeaf;
	private String customField;
	@SearchParameter(name = "customField")
	private String customFieldInput;
	@SearchParameter(name = "customFieldDate", provider = DateValueProvider.class)
	private LocalDateTime customFieldDate;
	@SearchParameter(name = "customFieldCheckbox", provider = BooleanValueProvider.class)
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
	@SearchParameter(name = "customFieldInlineEntity.customField")
	private String customFieldInline;
	@SearchParameter(name = "customFieldInlineEntity.id", provider = LongValueProvider.class)
	private Long customFieldInlineId;
	@SearchParameter(name = "customFieldPickListEntity.customField")
	private String customFieldPickTree;
	@SearchParameter(name = "customFieldPickListEntity.id", provider = LongValueProvider.class)
	private Long customFieldPickTreeId;
	@SearchParameter(name = "customFieldPercent", provider = BigDecimalValueProvider.class)
	private Long customFieldPercent;
	@SearchParameter(name = "customFieldNumber", provider = BigDecimalValueProvider.class)
	private Long customFieldNumber;
	@SearchParameter(name = "customFieldFileUpload")
	private String customFieldFileUpload;
	private String customFieldFileUploadId;
	@SearchParameter(name = "customFieldDateTimeWithSeconds", provider = DateValueProvider.class)
	private LocalDateTime customFieldDateTimeWithSeconds;
	@SearchParameter(name = "customFieldDateTime", provider = DateTimeValueProvider.class)
	private LocalDateTime customFieldDateTime;
	@SearchParameter(name = "customFieldText")
	private String customFieldText;
	private String customFieldHidden;
	@SearchParameter(name = "customFieldMultivalueList.id", provider = LongValueProvider.class)
	private MultivalueField customFieldMultivalue;
	@SearchParameter(name = "customFieldMultipleSelect", multiFieldKey = EnumValueProvider.class, provider = MultiFieldValueProvider.class)
	@EnumValueProvider.BaseEnum(value = CustomFieldMultipleSelectEnum.class)
	private MultivalueField customFieldMultipleSelect;
	@SearchParameter(name = "customFieldMultivalueHoverList.id", provider = LongValueProvider.class)
	private MultivalueField customFieldMultivalueHover;

	public MyExample3268DTO(Myexample3262 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldInput = entity.getCustomField();
		this.customFieldDate = entity.getCustomFieldDate();
		this.customFieldCheckBox = entity.getCustomFieldCheckbox();
		this.customFieldDictionary = entity.getCustomFieldDictionary();

		this.customFieldMultivalueHoverDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldMultivalueHoverList().stream().map(Myexample3262MultiHover::getCustomField
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
		this.customFieldPickTreeId = Optional.ofNullable(entity.getCustomFieldPickListEntity())
				.map(e -> e.getId())
				.orElse(null);
		this.customFieldPickTree = Optional.ofNullable(entity.getCustomFieldPickListEntity())
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
				Myexample3262Multi::getCustomField
		));
		this.customFieldMultivalueDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldMultivalueList().stream().map(Myexample3262Multi::getCustomField
		).collect(Collectors.joining(",")), 12);
		this.customFieldMultipleSelect = entity.getCustomFieldMultipleSelect().stream().collect(MultivalueField.toMultivalueField(Enum::name, CustomFieldMultipleSelectEnum::getValue));
		this.customFieldMultivalueHover = entity.getCustomFieldMultivalueHoverList().stream().collect(MultivalueField.toMultivalueField(
				e -> String.valueOf(e.getId()),
				Myexample3262MultiHover::getCustomField
		));
		this.customFieldMultivalueHoverDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldMultivalueHoverList().stream().map(Myexample3262MultiHover::getCustomField
		).collect(Collectors.joining(",")), 12);
		this.parentId = entity.getParentId();
		this.isLeaf = entity.getParentId() == null ? false : true;
	}
}