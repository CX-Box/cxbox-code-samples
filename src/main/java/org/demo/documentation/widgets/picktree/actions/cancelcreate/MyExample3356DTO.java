package org.demo.documentation.widgets.picktree.actions.cancelcreate;

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
public class MyExample3356DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;
	@SearchParameter(name = "customFieldPickTreeEntity.customField")
	private String customFieldPickTree;
	@SearchParameter(name = "customFieldPickTreeEntity.id", provider = LongValueProvider.class)
	private Long customFieldPickTreeId;
	@SearchParameter(name = "customFieldPickTreeOnCancelEntity.customField")
	private String customFieldPickTreeOnCancel;
	@SearchParameter(name = "customFieldPickTreeOnCancelEntity.id", provider = LongValueProvider.class)
	private Long customFieldPickTreeOnCancelId;
	@SearchParameter(name = "customFieldPickTreePostActionEntity.customField")
	private String customFieldPickTreePostAction;
	@SearchParameter(name = "customFieldPickTreePostActionEntity.id", provider = LongValueProvider.class)
	private Long customFieldPickTreePostActionId;

	public MyExample3356DTO(MyEntity3356 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldPickTreeId = Optional.ofNullable(entity.getCustomFieldPickTreeEntity())
				.map(e -> e.getId())
				.orElse(null);
		this.customFieldPickTree = Optional.ofNullable(entity.getCustomFieldPickTreeEntity())
				.map(e -> e.getCustomField())
				.orElse(null);
		this.customFieldPickTreeOnCancelId = Optional.ofNullable(entity.getCustomFieldPickTreeOnCancelEntity())
				.map(e -> e.getId())
				.orElse(null);
		this.customFieldPickTreeOnCancel = Optional.ofNullable(entity.getCustomFieldPickTreeOnCancelEntity())
				.map(e -> e.getCustomField())
				.orElse(null);
		this.customFieldPickTreePostActionId = Optional.ofNullable(entity.getCustomFieldPickTreePostActionEntity())
				.map(e -> e.getId())
				.orElse(null);
		this.customFieldPickTreePostAction = Optional.ofNullable(entity.getCustomFieldPickTreePostActionEntity())
				.map(e -> e.getCustomField())
				.orElse(null);
	}
}