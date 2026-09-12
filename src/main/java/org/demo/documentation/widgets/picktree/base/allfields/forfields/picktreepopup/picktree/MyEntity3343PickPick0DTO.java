package org.demo.documentation.widgets.picktree.base.allfields.forfields.picktreepopup.picktree;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.*;
import org.demo.documentation.widgets.picktree.base.allfields.forfields.MyEntity3343Multi;
import org.demo.documentation.widgets.picktree.base.allfields.forfields.MyEntity3343MultiMulti;
import org.demo.documentation.widgets.picktree.base.allfields.forfields.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.picktree.base.allfields.forfields.enums.CustomFieldRadioEnum;
import org.demo.documentation.widgets.picktree.base.allfields.forfields.picktreepopup.MyEntity3343Pick;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3343PickPick0DTO extends DataResponseDTO {

	@SearchParameter(name = "parentId", provider = LongValueProvider.class)
	private Long parentId;

	private Boolean isLeaf;

	private String customFieldPick;
	@SearchParameter(name = "customFieldMultivalueHoverList.id", provider = LongValueProvider.class)
	private MultivalueField customFieldMultivalueHover;
	private String customFieldMultivalueHoverDisplayedKey;
	@SearchParameter(name = "customFieldMultivalueList.id", provider = LongValueProvider.class)
	private MultivalueField customFieldMultivalue;
	private String customFieldMultivalueDisplayedKey;
	@SearchParameter(name = "customFieldInlinePicktreeEntity.customField")
	private String customFieldInlinePicktree;
	@SearchParameter(name = "customFieldInlinePicktreeEntity.id", provider = LongValueProvider.class)
	private Long customFieldInlinePicktreeId;
	@SearchParameter(name = "customFieldPicktreeEntity.customField")
	private String customFieldPicktree;
	@SearchParameter(name = "customFieldPicktreeEntity.id", provider = LongValueProvider.class)
	private Long customFieldPicktreeId;
	@SearchParameter(name = "customFieldRadio", provider = EnumValueProvider.class)
	private CustomFieldRadioEnum customFieldRadio;
	@SearchParameter(name = "customFieldMoney", provider = BigDecimalValueProvider.class)
	private Double customFieldMoney;
	@SearchParameter(name = "customFieldPercent", provider = BigDecimalValueProvider.class)
	private Long customFieldPercent;
	@SearchParameter(name = "customFieldNumber", provider = BigDecimalValueProvider.class)
	private Long customFieldNumber;
	@SearchParameter(name = "customFieldFileUploade")
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
	@SearchParameter(name = "customFieldText")
	private String customFieldText;
	@SearchParameter(name = "customFieldInput")
	private String customFieldInput;
	@SearchParameter(name = "customField")
	private String customField;

	public MyEntity3343PickPick0DTO(MyEntity3343Pick entity) {
		this.id = entity.getId().toString();
		this.parentId = entity.getParentId();
		this.isLeaf = entity.getChildren().isEmpty();
		this.customFieldPick = entity.getCustomFieldPick();
		this.customFieldMultivalueHover = entity.getCustomFieldMultivalueHoverList().stream().collect(MultivalueField.toMultivalueField(
				e -> String.valueOf(e.getId()),
				MyEntity3343MultiMulti::getCustomField
		));
		this.customFieldMultivalueHoverDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldMultivalueHoverList().stream().map(MyEntity3343MultiMulti::getCustomField
		).collect(Collectors.joining(",")), 12);
		this.customFieldMultivalue = entity.getCustomFieldMultivalueList().stream().collect(MultivalueField.toMultivalueField(
				e -> String.valueOf(e.getId()),
				MyEntity3343Multi::getCustomField
		));
		this.customFieldMultivalueDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldMultivalueList().stream().map(MyEntity3343Multi::getCustomField
		).collect(Collectors.joining(",")), 12);
		this.customFieldInlinePicktreeId = Optional.ofNullable(entity.getCustomFieldInlinePicktreeEntity())
				.map(e -> e.getId())
				.orElse(null);
		this.customFieldInlinePicktree = Optional.ofNullable(entity.getCustomFieldInlinePicktreeEntity())
				.map(e -> e.getCustomField())
				.orElse(null);
		this.customFieldPicktreeId = Optional.ofNullable(entity.getCustomFieldPicktreeEntity())
				.map(e -> e.getId())
				.orElse(null);
		this.customFieldPicktree = Optional.ofNullable(entity.getCustomFieldPicktreeEntity())
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
