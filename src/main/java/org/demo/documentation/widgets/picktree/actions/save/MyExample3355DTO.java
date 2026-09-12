package org.demo.documentation.widgets.picktree.actions.save;

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
public class MyExample3355DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;
	@SearchParameter(name = "customFieldPickTreeEntity.customField")
	private String customFieldPickTree;
	@SearchParameter(name = "customFieldPickTreeEntity.id", provider = LongValueProvider.class)
	private Long customFieldPickTreeId;

	public MyExample3355DTO(MyEntity3355 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldPickTreeId = Optional.ofNullable(entity.getCustomFieldPickTreeEntity())
				.map(e -> e.getId())
				.orElse(null);
		this.customFieldPickTree = Optional.ofNullable(entity.getCustomFieldPickTreeEntity())
				.map(e -> e.getCustomField())
				.orElse(null);
	}
}