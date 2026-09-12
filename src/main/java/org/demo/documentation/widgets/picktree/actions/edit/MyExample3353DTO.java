package org.demo.documentation.widgets.picktree.actions.edit;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3353DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;
	@SearchParameter(name = "customFieldPickTreeEntity.customField")
	private String customFieldPickTree;
	@SearchParameter(name = "customFieldPickTreeEntity.id", provider = LongValueProvider.class)
	private Long customFieldPickTreeId;
	@SearchParameter(name = "customFieldInlinePickTreeEntity.customField")
	private String customFieldInlinePickTree;
	@SearchParameter(name = "customFieldInlinePickTreeEntity.id", provider = LongValueProvider.class)
	private Long customFieldInlinePickTreeId;

	public MyExample3353DTO(MyEntity3353 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldPickTreeId = Optional.ofNullable(entity.getCustomFieldPickTreeEntity())
				.map(e -> e.getId())
				.orElse(null);
		this.customFieldPickTree = Optional.ofNullable(entity.getCustomFieldPickTreeEntity())
				.map(e -> e.getCustomField())
				.orElse(null);
		this.customFieldInlinePickTreeId = Optional.ofNullable(entity.getCustomFieldInlinePickTreeEntity())
				.map(e -> e.getId())
				.orElse(null);
		this.customFieldInlinePickTree = Optional.ofNullable(entity.getCustomFieldInlinePickTreeEntity())
				.map(e -> e.getCustomField())
				.orElse(null);
	}
}