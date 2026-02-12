package org.demo.documentation.fields.dictionary.icon;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
import org.demo.documentation.fields.dictionary.icon.assoc.MyEntity3011Multi;
import org.demo.documentation.fields.dictionary.icon.assoc.MyEntity3012Multi;
import org.demo.documentation.fields.dictionary.icon.enums.CustomFieldDictionaryEnum;

import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3011DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;
	@SearchParameter(name = "customFieldDictionary", provider = EnumValueProvider.class)
	private CustomFieldDictionaryEnum customFieldDictionary;
	@SearchParameter(name = "customFieldPickListEntity.customFieldDictionary")
	private CustomFieldDictionaryEnum customFieldPickList;
	@SearchParameter(name = "customFieldPickListEntity.id", provider = LongValueProvider.class)
	private Long customFieldPickListId;
	@SearchParameter(name = "customFieldDictionaryInlinePickListEntity.customFieldDictionary")
	private CustomFieldDictionaryEnum customFieldDictionaryInlinePickList;
	@SearchParameter(name = "customFieldDictionaryInlinePickListEntity.id", provider = LongValueProvider.class)
	private Long customFieldDictionaryInlinePickListId;
	@SearchParameter(name = "customFieldMultivalueList.id", provider = LongValueProvider.class)
	private MultivalueField customFieldMultivalue;
	private String customFieldMultivalueDisplayedKey;
	@SearchParameter(name = "customFieldMultivalueModeIconList.id", provider = LongValueProvider.class)
	private MultivalueField customFieldMultivalueModeIcon;
	private String customFieldMultivalueModeIconDisplayedKey;

	public MyExample3011DTO(MyEntity3011 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldDictionary = entity.getCustomFieldDictionary();
		this.customFieldPickListId = Optional.ofNullable(entity.getCustomFieldPickListEntity())
				.map(e -> e.getId())
				.orElse(null);
		this.customFieldPickList = Optional.ofNullable(entity.getCustomFieldPickListEntity())
				.map(e -> e.getCustomFieldDictionary())
				.orElse(null);
		this.customFieldDictionaryInlinePickListId = Optional.ofNullable(entity.getCustomFieldDictionaryInlinePickListEntity())
				.map(e -> e.getId())
				.orElse(null);
		this.customFieldDictionaryInlinePickList = Optional.ofNullable(entity.getCustomFieldDictionaryInlinePickListEntity())
				.map(e -> e.getCustomFieldDictionary())
				.orElse(null);
		this.customFieldMultivalue = entity.getCustomFieldMultivalueList().stream().collect(MultivalueField.toMultivalueField(
				e -> String.valueOf(e.getId()),
				e -> String.valueOf(e.getCustomFieldDictionary())
		));
		this.customFieldMultivalueDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldMultivalueList().stream().map(MyEntity3011Multi::getCustomFieldDictionary
		).map(e -> e.toString()).collect(Collectors.joining(",")), 12);
		this.customFieldMultivalueModeIcon = entity.getCustomFieldMultivalueModeIconList().stream().collect(MultivalueField.toMultivalueField(
				e -> String.valueOf(e.getId()),
				e -> String.valueOf(e.getCustomFieldDictionary())
		));
		this.customFieldMultivalueModeIconDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldMultivalueModeIconList().stream().map(MyEntity3012Multi::getCustomFieldDictionary
		).map(e -> e.toString()).collect(Collectors.joining(",")), 12);
	}
}