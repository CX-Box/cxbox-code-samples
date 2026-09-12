package org.demo.documentation.widgets.picktree.base.allfields;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
import org.demo.documentation.widgets.picktree.base.allfields.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.picktree.base.allfields.enums.CustomFieldRadioEnum;
import org.demo.documentation.widgets.picktree.base.allfields.forfields.MyEntity3343Multi;

import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3343DTO extends DataResponseDTO {


	@SearchParameter(name = "customFieldEntity.customFieldPick")
	private String customField;
	@SearchParameter(name = "customFieldEntity.id", provider = LongValueProvider.class)
	private Long customFieldId;
	@SearchParameter(name = "customFieldInlinePickTreeEntity.customField")
	private String customFieldInlinePickTree;
	@SearchParameter(name = "customFieldInlinePickTreeEntity.id", provider = LongValueProvider.class)
	private Long customFieldInlinePickTreeId;
	@SearchParameter(name = "customFieldMultivalueList.id", provider = LongValueProvider.class)
	private MultivalueField customFieldMultivalue;
	private String customFieldMultivalueDisplayedKey;
	@SearchParameter(name = "customFieldRadio", provider = EnumValueProvider.class)
	private CustomFieldRadioEnum customFieldRadio;
	@SearchParameter(name = "customFieldFileUploade")
	private String customFieldFileUploade;
	private String customFieldFileUploadeId;
	@SearchParameter(name = "customFieldDictionary", provider = EnumValueProvider.class)
	private CustomFieldDictionaryEnum customFieldDictionary;

	public MyExample3343DTO(MyEntity3343 entity) {
		this.id = entity.getId().toString();

		this.customFieldId = Optional.ofNullable(entity.getCustomFieldEntity())
				.map(e -> e.getId())
				.orElse(null);
		this.customField = Optional.ofNullable(entity.getCustomFieldEntity())
				.map(e -> e.getCustomFieldPick())
				.orElse(null);
		this.customFieldInlinePickTreeId = Optional.ofNullable(entity.getCustomFieldInlinePickTreeEntity())
				.map(e -> e.getId())
				.orElse(null);
		this.customFieldInlinePickTree = Optional.ofNullable(entity.getCustomFieldInlinePickTreeEntity())
				.map(e -> e.getCustomField())
				.orElse(null);
		this.customFieldMultivalue = entity.getCustomFieldMultivalueList().stream().collect(MultivalueField.toMultivalueField(
				e -> String.valueOf(e.getId()),
				e -> String.valueOf(e.getCustomField())
		));
		this.customFieldMultivalueDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldMultivalueList().stream().map(MyEntity3343Multi::getCustomField
		).map(e -> e.toString()).collect(Collectors.joining(",")), 12);
		this.customFieldRadio = entity.getCustomFieldRadio();
		this.customFieldFileUploade = entity.getCustomFieldFileUploade();
		this.customFieldFileUploadeId = entity.getCustomFieldFileUploadeId();
		this.customFieldDictionary = entity.getCustomFieldDictionary();
	}
}