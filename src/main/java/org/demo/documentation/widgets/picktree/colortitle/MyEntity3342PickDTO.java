package org.demo.documentation.widgets.picktree.colortitle;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.*;
import org.demo.documentation.widgets.picktree.colortitle.enums.CustomFieldColorDictionaryEnum;
import org.demo.documentation.widgets.picktree.colortitle.enums.CustomFieldColorRadioEnum;
import org.demo.documentation.widgets.picktree.colortitle.forfields.MyEntity3342Multi;
import org.demo.documentation.widgets.picktree.colortitle.forfields.MyEntity3342MultiMulti;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3342PickDTO extends DataResponseDTO {

	@SearchParameter(name = "parentId", provider = LongValueProvider.class)
	private Long parentId;

	private Boolean isLeaf;

	private String customField;
	private String customFieldColor;
	private String customFieldColorFieldText;
	private String customFieldColorInputConst;
	private String customFieldColorTextConst;
	@SearchParameter(name = "customFieldColorMultivalueHoverList.id", provider = LongValueProvider.class)
	private MultivalueField customFieldColorMultivalueHover;
	private String customFieldColorMultivalueHoverDisplayedKey;
	@SearchParameter(name = "customFieldColorMultivalueList.id", provider = LongValueProvider.class)
	private MultivalueField customFieldColorMultivalue;
	private String customFieldColorMultivalueDisplayedKey;
	@SearchParameter(name = "customFieldColorInlinePicktreeEntity.customField")
	private String customFieldColorInlinePicktree;
	@SearchParameter(name = "customFieldColorInlinePicktreeEntity.id", provider = LongValueProvider.class)
	private Long customFieldColorInlinePicktreeId;
	@SearchParameter(name = "customFieldColorPicktreeEntity.customField")
	private String customFieldColorPicktree;
	@SearchParameter(name = "customFieldColorPicktreeEntity.id", provider = LongValueProvider.class)
	private Long customFieldColorPicktreeId;
	@SearchParameter(name = "customFieldColorRadio", provider = EnumValueProvider.class)
	private CustomFieldColorRadioEnum customFieldColorRadio;
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
	private CustomFieldColorDictionaryEnum customFieldColorDictionary;
	@SearchParameter(name = "customFieldColorDateTimeWithSeconds", provider = DateValueProvider.class)
	private LocalDateTime customFieldColorDateTimeWithSeconds;
	@SearchParameter(name = "customFieldColorDate", provider = DateValueProvider.class)
	private LocalDateTime customFieldColorDate;
	@SearchParameter(name = "customFieldColorCheckbox", provider = BooleanValueProvider.class)
	private Boolean customFieldColorCheckbox;
	@SearchParameter(name = "customFieldColorDateTime", provider = DateTimeValueProvider.class)
	private LocalDateTime customFieldColorDateTime;
	@SearchParameter(name = "customFieldColorInput")
	private String customFieldColorInput;
	@SearchParameter(name = "customFieldColorText")
	private String customFieldColorText;

	// --8<-- [start:colorDTO]
	public MyEntity3342PickDTO(MyEntity3342 entity) {
		this.id = entity.getId().toString();
		this.parentId = entity.getParentId();
		this.isLeaf = entity.getChildren().isEmpty();
		this.customField = entity.getCustomField();
		this.customFieldColor = "#eda6a6";
		this.customFieldColorFieldText = "#a6eda6";
		// --8<-- [end:colorDTO]
		this.customFieldColorMultivalueHover = entity.getCustomFieldColorMultivalueHoverList().stream().collect(MultivalueField.toMultivalueField(
				e -> String.valueOf(e.getId()),
				MyEntity3342Multi::getCustomField
		));
		this.customFieldColorMultivalueHoverDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldColorMultivalueHoverList().stream().map(MyEntity3342Multi::getCustomField
		).collect(Collectors.joining(",")), 12);
		this.customFieldColorMultivalue = entity.getCustomFieldColorMultivalueList().stream().collect(MultivalueField.toMultivalueField(
				e -> String.valueOf(e.getId()),
				MyEntity3342MultiMulti::getCustomField
		));
		this.customFieldColorMultivalueDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldColorMultivalueList().stream().map(MyEntity3342MultiMulti::getCustomField
		).collect(Collectors.joining(",")), 12);
		this.customFieldColorInlinePicktreeId = Optional.ofNullable(entity.getCustomFieldColorInlinePicktreeEntity())
				.map(e -> e.getId())
				.orElse(null);
		this.customFieldColorInlinePicktree = Optional.ofNullable(entity.getCustomFieldColorInlinePicktreeEntity())
				.map(e -> e.getCustomField())
				.orElse(null);
		this.customFieldColorPicktreeId = Optional.ofNullable(entity.getCustomFieldColorPicktreeEntity())
				.map(e -> e.getId())
				.orElse(null);
		this.customFieldColorPicktree = Optional.ofNullable(entity.getCustomFieldColorPicktreeEntity())
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
		this.customFieldColorInputConst = entity.getCustomFieldColorInputConst();
		this.customFieldColorTextConst = entity.getCustomFieldColorTextConst();
		this.customFieldColorInput = entity.getCustomFieldColorInput();
		this.customFieldColorText = entity.getCustomFieldColorText();
	}

}
