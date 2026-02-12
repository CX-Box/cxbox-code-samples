package org.demo.documentation.feature.drilldown.drilldownfilter;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.*;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider.BaseEnum;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.feature.drilldown.drilldownfilter.enums.CustomField4300DictionaryEnum;
import org.demo.documentation.feature.drilldown.drilldownfilter.enums.CustomField4300MultipleSelectEnum;
import org.demo.documentation.feature.drilldown.drilldownfilter.enums.CustomField4300RadioEnum;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class MyExample4300PostActionWithCustomBuilderDTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	@SearchParameter(name = "customFieldHint")
	private String customFieldHint;

	@SearchParameter(name = "customFieldMultipleSelect", multiFieldKey = EnumValueProvider.class, provider = MultiFieldValueProvider.class)
	@BaseEnum(value = CustomField4300MultipleSelectEnum.class)
	private MultivalueField customFieldMultipleSelect;

	@SearchParameter(name = "multivalueList.id", provider = MultiFieldValueProvider.class)
	private MultivalueField customFieldMultivalue;

	private String customFieldMultivalueDisplayKey;

	@SearchParameter(name = "multivalueHoverList.id", provider = MultiFieldValueProvider.class)
	private MultivalueField customFieldMultivalueHover;

	private String customFieldMultivalueHoverDisplayKey;

	@SearchParameter(name = "myEntity4300PickList.value")
	private String customFieldPickList;

	@SearchParameter(name = "myEntity4300PickList.id", provider = LongValueProvider.class)
	private Long customFieldPickListId;

	@SearchParameter(name = "myEntity4300InlinePickList.value")
	private String customFieldInlinePickList;

	@SearchParameter(name = "myEntity4300InlinePickList.id", provider = LongValueProvider.class)
	private Long customFieldInlinePickListId;

	@SearchParameter(name = "customFieldRadio", provider = EnumValueProvider.class)
	private CustomField4300RadioEnum customFieldRadio;

	@SearchParameter(name = "customFieldMoney", provider = BigDecimalValueProvider.class)
	private Double customFieldMoney;

	@SearchParameter(name = "customFieldPercent", provider = BigDecimalValueProvider.class)
	private Long customFieldPercent;

	@SearchParameter(name = "customFieldNumber", provider = BigDecimalValueProvider.class)
	private Long customFieldNumber;

	@SearchParameter(name = "customFieldFileUpload")
	private String customFieldFileUpload;

	private String customFieldFileUploadId;

	@SearchParameter(name = "customFieldDictionary", provider = EnumValueProvider.class)
	private CustomField4300DictionaryEnum customFieldDictionary;

	@SearchParameter(name = "customFieldDateTimeWithSeconds", provider = DateValueProvider.class)
	private LocalDateTime customFieldDateTimeWithSeconds;

	@SearchParameter(name = "customFieldDate", provider = DateValueProvider.class)
	private LocalDateTime customFieldDate;

	@SearchParameter(name = "customFieldCheckbox", provider = BooleanValueProvider.class)
	private Boolean customFieldCheckbox;

	@SearchParameter(name = "customFieldDateTime", provider = DateTimeValueProvider.class)
	private LocalDateTime customFieldDateTime;

	@SearchParameter(name = "customFieldText")
	private String customFieldText;

	@SearchParameter(name = "customFieldHidden")
	private String customFieldHidden;

	public MyExample4300PostActionWithCustomBuilderDTO(MyEntity4300PostActionWithCustomBuilder entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldHint = entity.getCustomFieldHint();
		this.customFieldMultipleSelect = entity.getCustomFieldMultipleSelect().stream()
				.collect(MultivalueField.toMultivalueField(Enum::name, CustomField4300MultipleSelectEnum::getValue));

		this.customFieldMultivalue = entity.getMultivalueList().stream().collect(MultivalueField.toMultivalueField(
				e -> String.valueOf(e.getId()), MyEntity4300Multivalue::getValue
		));
		if (entity.getMultivalueList() != null) {
			this.customFieldMultivalueDisplayKey = entity.getMultivalueList().stream().map(MyEntity4300Multivalue::getValue).collect(Collectors.joining(","));
		}
		this.customFieldMultivalueHover = entity.getMultivalueHoverList().stream().collect(MultivalueField.toMultivalueField(
				e -> String.valueOf(e.getId()), MyEntity4300MultivalueHover::getValue
		));
		if (entity.getMultivalueHoverList() != null) {
			this.customFieldMultivalueHoverDisplayKey = entity.getMultivalueHoverList().stream().map(MyEntity4300MultivalueHover::getValue).collect(Collectors.joining(","));
		}

		this.customFieldInlinePickList = Optional.of(entity).map(MyEntity4300PostActionWithCustomBuilder::getMyEntity4300InlinePickList)
				.map(MyEntity4300InlinePickList::getValue).orElse(null);
		this.customFieldInlinePickListId = Optional.of(entity).map(MyEntity4300PostActionWithCustomBuilder::getMyEntity4300InlinePickList)
				.map(BaseEntity::getId).orElse(null);

		this.customFieldPickList = Optional.of(entity).map(MyEntity4300PostActionWithCustomBuilder::getMyEntity4300PickList)
				.map(MyEntity4300PickList::getValue).orElse(null);
		this.customFieldPickListId = Optional.of(entity).map(MyEntity4300PostActionWithCustomBuilder::getMyEntity4300PickList)
				.map(BaseEntity::getId).orElse(null);

		this.customFieldRadio = entity.getCustomFieldRadio();
		this.customFieldMoney = entity.getCustomFieldMoney();
		this.customFieldPercent = entity.getCustomFieldPercent();
		this.customFieldNumber = entity.getCustomFieldNumber();
		this.customFieldFileUpload = entity.getCustomFieldFileUpload();
		this.customFieldFileUploadId = entity.getCustomFieldFileUploadId();
		this.customFieldDictionary = entity.getCustomFieldDictionary();
		this.customFieldDateTimeWithSeconds = entity.getCustomFieldDateTimeWithSeconds();
		this.customFieldDate = entity.getCustomFieldDate();
		this.customFieldCheckbox = entity.getCustomFieldCheckbox();
		this.customFieldDateTime = entity.getCustomFieldDateTime();
		this.customFieldText = entity.getCustomFieldText();
		this.customFieldHidden = entity.getCustomFieldHidden();
	}

}
